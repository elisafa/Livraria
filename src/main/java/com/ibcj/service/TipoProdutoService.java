package com.ibcj.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ibcj.model.TipoProduto;
import com.ibcj.repository.impl.TipoProdutoImpl;
import com.ibcj.util.jpa.Transactional;

public class TipoProdutoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoProdutoImpl tipoProdutoImpl;
	
	@Transactional
	public TipoProduto buscarPorId(Long id) {
		return tipoProdutoImpl.buscarPorId(id);
	}
	
	@Transactional
	public void editar(TipoProduto tipoProduto){
		tipoProdutoImpl.editar(tipoProduto);
	}
	
	@Transactional
	public List<TipoProduto> listar() {
		return tipoProdutoImpl.listar();
	}
	
	@Transactional
	public void remover(Long id) {
		tipoProdutoImpl.remover(id);
	}
	
	@Transactional
	public void salvar(TipoProduto tipoProduto){
		tipoProdutoImpl.salvar(tipoProduto);
	}
}