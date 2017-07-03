package com.ibcj.repository;

import java.util.List;

import com.ibcj.model.Usuario;

public interface IUsuario {

	public List<Usuario> listar();
	public Usuario buscarPorId(Long id);
	public void salvar(Usuario usuario);
	public void editar(Usuario usuario);
	public void remover(Long id);
	
}
