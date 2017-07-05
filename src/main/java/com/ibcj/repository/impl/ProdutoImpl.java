package com.ibcj.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ibcj.model.Produto;
import com.ibcj.repository.IProduto;

public class ProdutoImpl implements Serializable, IProduto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	@Override
	public Produto buscarPorId(Long id) {
		Produto produto = em.find(Produto.class, id);
		return produto;
	}

	@Override
	public void editar(Produto produto) {
		em.merge(produto);
	}

	@Override
	public List<Produto> listar() {
		Query query = em.createQuery("from Produto");
		List<Produto> listaProdutos = query.getResultList();
		return listaProdutos;
	}

	@Override
	public void remover(Long id) {
		Produto produto = em.find(Produto.class, id);
		em.remove(produto);
	}

	@Override
	public void salvar(Produto produto) {
		em.persist(produto);		
	}

}
