package com.ibcj.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ibcj.model.TipoObjeto;
import com.ibcj.service.TipoObjetoService;

@Named
@ViewScoped
public class TipoObjetoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoObjetoService tipoObjetoService;
	private TipoObjeto tipoObjeto = new TipoObjeto();
	private TipoObjeto tipoObjetoSelecionado;
	private List<TipoObjeto> listaTipoObjetos = new ArrayList<TipoObjeto>();
	
	
	public String cadastrar(){
		tipoObjetoService.salvar(tipoObjeto);
		return "/index.xhtml?faces-redirect=true";	
	}
	
	public String editar(){
		tipoObjetoService.editar(tipoObjeto);
		return "/index.xhtml?faces-redirect=true";	
	}
	
	public List<TipoObjeto> listar(){
		listaTipoObjetos = tipoObjetoService.listar();
		return listaTipoObjetos;	
	}
	
	public String novo(){
		String pagina = "/site/TipoObjeto/Cadastro/TipoObjeto.xhtml?faces-redirect=true";
		return pagina;
	}
	
	public String edicao(){	
		String pagina = "/site/TipoObjeto/Edicao/TipoObjeto.xhtml?id="+tipoObjetoSelecionado.getId()+"faces-redirect=true";
		return pagina;
	}
	
	public void excluir(){
		tipoObjetoService.remover(tipoObjetoSelecionado.getId());
		tipoObjetoSelecionado = null;
		listar();
	}	
	
	public TipoObjetoService getTipoObjetoService() {
		return tipoObjetoService;
	}
	public void setTipoObjetoService(TipoObjetoService tipoObjetoService) {
		this.tipoObjetoService = tipoObjetoService;
	}
	public TipoObjeto getTipoObjeto() {
		return tipoObjeto;
	}
	public void setTipoObjeto(TipoObjeto tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}
	public TipoObjeto getTipoObjetoSelecionado() {
		return tipoObjetoSelecionado;
	}
	public void setTipoObjetoSelecionado(TipoObjeto tipoObjetoSelecionado) {
		this.tipoObjetoSelecionado = tipoObjetoSelecionado;
	}
	public List<TipoObjeto> getListaTipoObjetos() {
		return listaTipoObjetos;
	}
	public void setListaTipoObjetos(List<TipoObjeto> listaTipoObjetos) {
		this.listaTipoObjetos = listaTipoObjetos;
	}
}
