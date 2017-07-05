package com.ibcj.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ibcj.model.TipoObjeto;
import com.ibcj.repository.impl.TipoObjetoImpl;
import com.ibcj.util.jpa.Transactional;

public class TipoObjetoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoObjetoImpl tipoObjetoImpl;
	
	@Transactional
	public TipoObjeto buscarPorId(Long id) {
		return tipoObjetoImpl.buscarPorId(id);
	}
	
	@Transactional
	public void editar(TipoObjeto tipoObjeto){
		tipoObjetoImpl.editar(tipoObjeto);
	}
	
	@Transactional
	public List<TipoObjeto> listar() {
		return tipoObjetoImpl.listar();
	}
	
	@Transactional
	public void remover(Long id) {
		tipoObjetoImpl.remover(id);
	}
	
	@Transactional
	public void salvar(TipoObjeto tipoObjeto){
		tipoObjetoImpl.salvar(tipoObjeto);
	}
}