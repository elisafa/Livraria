package com.ibcj.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ibcj.model.Produto;
import com.ibcj.repository.impl.ProdutoImpl;
import com.ibcj.util.jpa.Transactional;

public class ProdutoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoImpl produtoImpl;
	
	@Transactional
	public Produto buscarPorId(Long id) {
		return produtoImpl.buscarPorId(id);
	}
	
	@Transactional
	public void editar(Produto produto){
		produtoImpl.editar(produto);
	}
	
	@Transactional
	public List<Produto> listar() {
		return produtoImpl.listar();
	}
	
	@Transactional
	public void remover(Long id) {
		produtoImpl.remover(id);
	}
	
	@Transactional
	public void salvar(Produto produto){
		produtoImpl.salvar(produto);
	}
}