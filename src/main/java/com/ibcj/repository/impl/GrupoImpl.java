package com.ibcj.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ibcj.model.Grupo;
import com.ibcj.repository.IGrupo;

public class GrupoImpl implements Serializable, IGrupo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Override
	public Grupo buscarPorId(Long id) {
		Grupo grupo = em.find(Grupo.class, id);
		return grupo;
	}

	@Override
	public void editar(Grupo grupo) {
		em.merge(grupo);
	}

	@Override
	public List<Grupo> listar() {
		Query query = em.createQuery("from Grupo");
		List<Grupo> listaGrupos = query.getResultList();
		return listaGrupos;
	}
	
	@Override
	public void remover(Long id) {
		Grupo grupo = em.find(Grupo.class, id);
		em.remove(grupo);
	}
	
	@Override
	public void salvar(Grupo grupo) {
		em.persist(grupo);
	}
}