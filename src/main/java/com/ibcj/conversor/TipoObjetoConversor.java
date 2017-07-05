package com.ibcj.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ibcj.model.TipoObjeto;
import com.ibcj.repository.impl.TipoObjetoImpl;
import com.ibcj.util.cdi.CDIServiceLocator;

@FacesConverter(value="tipoObjetoConversor", forClass=TipoObjeto.class)
public class TipoObjetoConversor implements Converter{

	private TipoObjetoImpl tipoObjetoImpl;
	
	public TipoObjetoConversor() {
		tipoObjetoImpl = CDIServiceLocator.getBean(TipoObjetoImpl.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		TipoObjeto tipoObjeto = null;			

		if (valor != null) {
			tipoObjeto = tipoObjetoImpl.buscarPorId(new Long(valor));
		}

		return tipoObjeto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object valor) {
		
		if (valor != null) {
			TipoObjeto tipoObjeto = (TipoObjeto) valor;
			return tipoObjeto.getId() == null ? null : tipoObjeto.getId().toString();

		}
		
		return null;
	}
}
