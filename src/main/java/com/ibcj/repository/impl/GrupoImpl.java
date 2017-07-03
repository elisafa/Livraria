package com.ibcj.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ibcj.model.Grupo;
import com.ibcj.repository.IGrupo;
import com.ibcj.util.JpaUtil;

public class GrupoImpl implements IGrupo{

	private EntityManager em;
	
	@Override
	public List<Grupo> listar() {
		
		em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Grupo");
		List<Grupo> listaGrupos = query.getResultList();
		em.close();
		
		return listaGrupos;
	}

	@Override
	public Grupo buscarPorId(Long id) {
		
		em = JpaUtil.getEntityManager();
		Grupo grupo = em.find(Grupo.class, id);
		em.close();
		
		return grupo;
	}

	@Override
	public void salvar(Grupo grupo) {
		
		em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(grupo);
		tx.commit();
		em.close();		
	}

	@Override
	public void editar(Grupo grupo) {
		
		em = JpaUtil.getEntityManager();
		em.merge(grupo);
		em.close();		
	}

	@Override
	public void remover(Long id) {
		
		em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Grupo grupo = em.find(Grupo.class, id);
		em.remove(grupo);
		em.close();		
	}

}
