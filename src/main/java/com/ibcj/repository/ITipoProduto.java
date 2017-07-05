package com.ibcj.repository;

import java.util.List;

import com.ibcj.model.TipoProduto;

public interface ITipoProduto {
	
	public TipoProduto buscarPorId(Long id);
	public void editar(TipoProduto tipoProduto);
	public List<TipoProduto> listar();
	public void remover(Long id);
	public void salvar(TipoProduto tipoProduto);
}
