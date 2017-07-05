package com.ibcj.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ibcj.model.Produto;
import com.ibcj.model.TipoProduto;
import com.ibcj.service.ProdutoService;

@Named
@ViewScoped
public class ProdutoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoService produtoService;
	private Produto produto = new Produto();
	private Produto produtoSelecionado;
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	public String cadastrar(){
		produtoService.salvar(produto);
		return "/site/Produto/Consulta/Produto.xhtml?faces-redirect=true";	
	}
	
	public String editar(){
		produtoService.editar(produto);
		return "/site/Produto/Consulta/Produto.xhtml?faces-redirect=true";	
	}
	
	public List<Produto> listar(){
		listaProdutos = produtoService.listar();
		return listaProdutos;	
	}
	
	public String novo(){
		String pagina = "/site/Produto/Cadastro/Produto.xhtml?faces-redirect=true";
		return pagina;
	}
	
	public String edicao(){	
		String pagina = "/site/Produto/Edicao/Produto.xhtml?id="+produtoSelecionado.getId()+"faces-redirect=true";
		return pagina;
	}
	
	public void excluir(){
		produtoService.remover(produtoSelecionado.getId());
		produtoSelecionado = null;
		listar();
	}
	
	public Produto escolherTipoProduto(ValueChangeEvent evento){
		produto.getTipoProduto().setNome(evento.getNewValue().toString());
		System.out.println("Tipo de Produto Selecionado: " + produto.getTipoProduto());
		
		return produto;
	}
	
	public void listener(AjaxBehaviorEvent event) {
	        System.out.println("listener");
	        String result = "called by " + event.getComponent().getClass().getName();
	        System.out.println(result);
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
}