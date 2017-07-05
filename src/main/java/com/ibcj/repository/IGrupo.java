package com.ibcj.repository;

import java.util.List;

import com.ibcj.model.Grupo;

public interface IGrupo {

	public Grupo buscarPorId(Long id);
	public void editar(Grupo grupo);
	public List<Grupo> listar();	
	public void remover(Long id);
	public void salvar(Grupo grupo);
}
