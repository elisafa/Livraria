package com.ibcj.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ibcj.model.Usuario;
import com.ibcj.repository.IUsuario;
import com.ibcj.util.JpaUtil;

public class UsuarioImpl implements IUsuario{

	private EntityManager em;
	
	@Override
	public List<Usuario> listar() {
	
		em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Usuario");
		List<Usuario> listaUsuarios = query.getResultList();
		em.close();
		
		return listaUsuarios;
	}

	@Override
	public Usuario buscarPorId(Long id) {
		
		em = JpaUtil.getEntityManager();
		Usuario usuario = em.find(Usuario.class, id);
		em.close();
		
		return usuario;
	}

	@Override
	public void salvar(Usuario usuario) {
		
		em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(usuario);
		tx.commit();
		em.close();
		
	}

	@Override
	public void editar(Usuario usuario) {
		
		em = JpaUtil.getEntityManager();
		em.merge(usuario);
		em.close();
		
	}

	@Override
	public void remover(Long id) {
		
		em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Usuario usuario = em.find(Usuario.class, id);
		em.remove(usuario);
		em.close();
	}
}