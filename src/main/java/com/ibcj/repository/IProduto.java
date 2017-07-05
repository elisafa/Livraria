package com.ibcj.repository;

import java.util.List;

import com.ibcj.model.Produto;

public interface IProduto {

	public Produto buscarPorId(Long id);
	public void editar(Produto produto);
	public List<Produto> listar();	
	public void remover(Long id);
	public void salvar(Produto produto);
	
}
