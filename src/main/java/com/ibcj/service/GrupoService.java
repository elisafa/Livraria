package com.ibcj.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ibcj.model.Grupo;
import com.ibcj.repository.impl.GrupoImpl;
import com.ibcj.util.jpa.Transactional;

public class GrupoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private GrupoImpl grupoImpl;
	
	@Transactional
	public void salvar(Grupo grupo){
		grupoImpl.salvar(grupo);
	}
	
	@Transactional
	public void editar(Grupo grupo){
		grupoImpl.editar(grupo);
	}

	@Transactional
	public Grupo porCodigo(Long id) {
		return grupoImpl.buscarPorId(id);
	}
	
	@Transactional
	public void remover(Long id) {
		grupoImpl.remover(id);
	}
	
	@Transactional
	public List<Grupo> listar() {
		return grupoImpl.listar();
	}
}
