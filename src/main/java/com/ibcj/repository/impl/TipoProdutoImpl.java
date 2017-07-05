package com.ibcj.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ibcj.model.TipoProduto;
import com.ibcj.repository.ITipoProduto;

public class TipoProdutoImpl implements Serializable, ITipoProduto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	@Override
	public TipoProduto buscarPorId(Long id) {
		TipoProduto tipoProduto = em.find(TipoProduto.class, id);
		return tipoProduto;
	}

	@Override
	public void editar(TipoProduto tipoProduto) {
		em.merge(tipoProduto);		
	}

	@Override
	public List<TipoProduto> listar() {
		Query query = em.createQuery("from TipoProduto");
		List<TipoProduto> listaTipoProdutos = query.getResultList();
		return listaTipoProdutos;
	}
	
	@Override
	public void remover(Long id) {
		TipoProduto tipoProduto = em.find(TipoProduto.class, id);
		em.remove(tipoProduto);		
	}

	@Override
	public void salvar(TipoProduto tipoProduto) {
		em.persist(tipoProduto);		
	}
}