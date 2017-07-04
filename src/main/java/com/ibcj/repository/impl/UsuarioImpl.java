package com.ibcj.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ibcj.model.Usuario;
import com.ibcj.repository.IUsuario;

public class UsuarioImpl implements Serializable, IUsuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	@Override
	public List<Usuario> listar() {
		Query query = em.createQuery("from Usuario u join fetch u.grupos Grupo");
		List<Usuario> listaUsuarios = query.getResultList();
		return listaUsuarios;
	}

	@Override
	public Usuario buscarPorId(Long id) {
		Usuario usuario = em.find(Usuario.class, id);
		return usuario;
	}

	@Override
	public void salvar(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		em.merge(usuario);		
	}

	@Override
	public void remover(Long id) {
		Usuario usuario = em.find(Usuario.class, id);
		em.remove(usuario);
	}
}