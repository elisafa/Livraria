package com.ibcj.repository;

import java.util.List;

import com.ibcj.model.Usuario;

public interface IUsuario {
	
	public Usuario buscarPorId(Long id);
	public void editar(Usuario usuario);
	public List<Usuario> listar();
	public void remover(Long id);
	public void salvar(Usuario usuario);
}
