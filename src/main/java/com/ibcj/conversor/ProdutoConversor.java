package com.ibcj.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ibcj.model.Produto;
import com.ibcj.repository.impl.ProdutoImpl;
import com.ibcj.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Produto.class)
public class ProdutoConversor implements Converter{

	private ProdutoImpl produtoImpl;
	
	public ProdutoConversor() {
		produtoImpl = CDIServiceLocator.getBean(ProdutoImpl.class);
	}	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		Produto produto = null;			

		if (valor != null) {
			produto = produtoImpl.buscarPorId(new Long(valor));
		}

		return produto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object valor) {
		
		if (valor != null) {
			Produto produto = (Produto) valor;
			return produto.getId() == null ? null : produto.getId().toString();

		}
		
		return null;
	}
	
}
