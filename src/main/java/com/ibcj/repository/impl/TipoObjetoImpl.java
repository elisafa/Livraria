package com.ibcj.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ibcj.model.Grupo;
import com.ibcj.model.TipoObjeto;
import com.ibcj.repository.ITipoObjeto;

public class TipoObjetoImpl implements Serializable, ITipoObjeto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	@Override
	public TipoObjeto buscarPorId(Long id) {
		TipoObjeto tipoObjeto = em.find(TipoObjeto.class, id);
		return tipoObjeto;
	}

	@Override
	public void editar(TipoObjeto tipoObjeto) {
		em.merge(tipoObjeto);		
	}

	@Override
	public List<TipoObjeto> listar() {
		Query query = em.createQuery("from TipoObjeto");
		List<TipoObjeto> listaTipoObjetos = query.getResultList();
		return listaTipoObjetos;
	}
	
	@Override
	public void remover(Long id) {
		TipoObjeto tipoObjeto = em.find(TipoObjeto.class, id);
		em.remove(tipoObjeto);		
	}

	@Override
	public void salvar(TipoObjeto tipoObjeto) {
		em.persist(tipoObjeto);		
	}
}