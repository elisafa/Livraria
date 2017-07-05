package com.ibcj.repository;

import java.util.List;

import com.ibcj.model.TipoObjeto;

public interface ITipoObjeto {
	
	public TipoObjeto buscarPorId(Long id);
	public void editar(TipoObjeto tipoObjeto);
	public List<TipoObjeto> listar();
	public void remover(Long id);
	public void salvar(TipoObjeto tipoObjeto);
}
