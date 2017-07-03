package com.ibcj.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ibcj.model.Usuario;
import com.ibcj.repository.IUsuario;
import com.ibcj.repository.impl.UsuarioImpl;
import com.ibcj.util.JpaUtil;

@ManagedBean
@ViewScoped
public class UsuarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	private Usuario usuarioSelecionado;
	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public String cadastrar(){
		
		IUsuario usuarioModelo = new UsuarioImpl();
		usuarioModelo.salvar(usuario);
		JpaUtil.close();
		
		return "index.xhtml?faces-redirect=true";
		
	}
	
	public List<Usuario> listar(){
		
		IUsuario usuarioModelo = new UsuarioImpl();
		listaUsuarios = usuarioModelo.listar();
		JpaUtil.close();
		
		return listaUsuarios;
		
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}
