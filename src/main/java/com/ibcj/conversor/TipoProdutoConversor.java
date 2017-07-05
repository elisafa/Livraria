package com.ibcj.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ibcj.model.TipoProduto;
import com.ibcj.repository.impl.TipoProdutoImpl;
import com.ibcj.util.cdi.CDIServiceLocator;

@FacesConverter(value="tipoProdutoConversor", forClass=TipoProduto.class)
public class TipoProdutoConversor implements Converter{

	private TipoProdutoImpl tipoProdutoImpl;
	
	public TipoProdutoConversor() {
		tipoProdutoImpl = CDIServiceLocator.getBean(TipoProdutoImpl.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		TipoProduto tipoProduto = null;			

		if (valor != null) {
			tipoProduto = tipoProdutoImpl.buscarPorId(new Long(valor));
		}

		return tipoProduto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object valor) {
		
		if (valor != null) {
			TipoProduto tipoProduto = (TipoProduto) valor;
			return tipoProduto.getId() == null ? null : tipoProduto.getId().toString();

		}
		
		return null;
	}
}
