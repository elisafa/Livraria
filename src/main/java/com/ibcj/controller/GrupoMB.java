package com.ibcj.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import com.ibcj.model.Grupo;
import com.ibcj.repository.IGrupo;
import com.ibcj.repository.impl.GrupoImpl;
import com.ibcj.util.JpaUtil;

@ManagedBean
@ViewScoped
public class GrupoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Grupo grupo = new Grupo();
	private Grupo grupoSelecionado;
	private List<Grupo> listaGrupos = new ArrayList<Grupo>();
	
	public String cadastrar(){
		
		System.out.println("Nome do Grupo: " + grupo.getNome());
		IGrupo grupoModelo = new GrupoImpl();
		grupoModelo.salvar(grupo);
		
		return "index.xhtml?faces-redirect=true";
		
	}
	
	public List<Grupo> listar(){
		
		IGrupo grupoModelo = new GrupoImpl();
		listaGrupos = grupoModelo.listar();
		
		return listaGrupos;
		
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
