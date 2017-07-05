package com.ibcj.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ibcj.model.TipoProduto;
import com.ibcj.service.TipoProdutoService;

@Named
@ViewScoped
public class TipoProdutoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoProdutoService tipoProdutoService;
	private TipoProduto tipoProduto = new TipoProduto();
	private TipoProduto tipoProdutoSelecionado;
	private List<TipoProduto> listaTipoProdutos = new ArrayList<TipoProduto>();
	
	
	public String cadastrar(){
		tipoProdutoService.salvar(tipoProduto);
		return "/site/TipoProduto/Consulta/TipoProduto.xhtml?faces-redirect=true";	
	}
	
	public String editar(){
		tipoProdutoService.editar(tipoProduto);
		return "/site/TipoProduto/Consulta/TipoProduto.xhtml?faces-redirect=true";	
	}
	
	public List<TipoProduto> listar(){
		listaTipoProdutos = tipoProdutoService.listar();
		return listaTipoProdutos;	
	}
	
	public String novo(){
		String pagina = "/site/TipoProduto/Cadastro/TipoProduto.xhtml?faces-redirect=true";
		return pagina;
	}
	
	public String edicao(){	
		String pagina = "/site/TipoProduto/Edicao/TipoProduto.xhtml?id="+tipoProdutoSelecionado.getId()+"faces-redirect=true";
		return pagina;
	}
	
	public void excluir(){
		tipoProdutoService.remover(tipoProdutoSelecionado.getId());
		tipoProdutoSelecionado = null;
		listar();
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public TipoProduto getTipoProdutoSelecionado() {
		return tipoProdutoSelecionado;
	}

	public void setTipoProdutoSelecionado(TipoProduto tipoProdutoSelecionado) {
		this.tipoProdutoSelecionado = tipoProdutoSelecionado;
	}

	public List<TipoProduto> getListaTipoProdutos() {
		return listaTipoProdutos;
	}

	public void setListaTipoProdutos(List<TipoProduto> listaTipoProdutos) {
		this.listaTipoProdutos = listaTipoProdutos;
	}
}