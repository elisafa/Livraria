package com.ibcj.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ibcj.model.Usuario;
import com.ibcj.repository.impl.UsuarioImpl;
import com.ibcj.util.jpa.Transactional;

public class UsuarioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioImpl usuarioImpl;
	
	@Transactional
	public void salvar(Usuario usuario){
		usuarioImpl.salvar(usuario);
	}
	
	@Transactional
	public void editar(Usuario usuario){
		usuarioImpl.editar(usuario);
	}

	@Transactional
	public Usuario porCodigo(Long id) {
		return usuarioImpl.buscarPorId(id);
	}
	
	@Transactional
	public void remover(Long id) {
		usuarioImpl.remover(id);
	}
	
	@Transactional
	public List<Usuario> listar() {
		return usuarioImpl.listar();
	}
	
	
	
	
}
