package com.ibcj.repository;

import java.util.List;

import com.ibcj.model.Grupo;

public interface IGrupo {

	public List<Grupo> listar();
	public Grupo buscarPorId(Long id);
	public void salvar(Grupo grupo);
	public void editar(Grupo grupo);
	public void remover(Long id);	
}
