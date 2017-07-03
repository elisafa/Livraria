package com.ibcj.interfaces.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.ibcj.interfaces.IUsuario;
import com.ibcj.model.Usuario;

public class UsuarioImpl implements IUsuario{

	EntityManager em;
	
	public UsuarioImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Usuario> listar() {
		
		return null;
	}

	@Override
	public Usuario buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}

}
