
package com.ibcj.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ibcj.model.Usuario;
import com.ibcj.service.UsuarioService;
import com.ibcj.util.Utilitaria;

@Named
@ViewScoped
public class UsuarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioService usuarioService;
	private Usuario usuario = new Usuario();
	private Usuario usuarioSelecionado;
	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public String cadastrar(){
		String senha = this.usuario.getSenha();
		this.usuario.setSenha(Utilitaria.md5(senha));
		usuarioService.salvar(usuario);
		return "/index.xhtml?faces-redirect=true";
		
	}
	
	public String editar(){
		usuarioService.editar(usuario);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public List<Usuario> listar(){
		listaUsuarios = usuarioService.listar();
		return listaUsuarios;	
	}
	
	public void excluir(){
		usuarioService.remover(usuarioSelecionado.getId());
		usuarioSelecionado = null;
		listar();
	}
	
	
	public String novo(){
		String pagina = "/site/Usuario/Cadastro/Usuario.xhtml?faces-redirect=true";
		return pagina;
	}
	
	public String edicao(){	
		String pagina = "/site/Usuario/Edicao/Usuario.xhtml?id="+usuarioSelecionado.getId()+"faces-redirect=true";
		return pagina;
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
