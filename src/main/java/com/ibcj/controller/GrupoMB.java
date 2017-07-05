package com.ibcj.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ibcj.model.Grupo;
import com.ibcj.service.GrupoService;

@Named
@ViewScoped
public class GrupoMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GrupoService grupoService;
	private Grupo grupo = new Grupo();
	private Grupo grupoSelecionado;
	private List<Grupo> listaGrupos = new ArrayList<Grupo>();	
	
	public String cadastrar(){
		grupoService.salvar(grupo);
		return "/site/Grupo/Consulta/Grupo.xhtml?faces-redirect=true";	
	}
	
	public String editar(){
		grupoService.editar(grupo);
		return "/site/Grupo/Consulta/Grupo.xhtml?faces-redirect=true";	
	}
	
	public List<Grupo> listar(){
		listaGrupos = grupoService.listar();
		return listaGrupos;	
	}
	
	public String novo(){
		String pagina = "/site/Grupo/Cadastro/Grupo.xhtml?faces-redirect=true";
		return pagina;
	}
	
	public String edicao(){	
		String pagina = "/site/Grupo/Edicao/Grupo.xhtml?id="+grupoSelecionado.getId()+"faces-redirect=true";
		return pagina;
	}
	
	public void excluir(){
		grupoService.remover(grupoSelecionado.getId());
		grupoSelecionado = null;
		listar();
	}	
	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public Grupo getGrupoSelecionado() {
		return grupoSelecionado;
	}
	public void setGrupoSelecionado(Grupo grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}
	
	public List<Grupo> getListaGrupos() {
		return listaGrupos;
	}
	public void setListaGrupos(List<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}	
}
