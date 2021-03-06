package com.ibcj.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ibcj.model.Grupo;
import com.ibcj.repository.impl.GrupoImpl;
import com.ibcj.util.cdi.CDIServiceLocator;

@FacesConverter(value="grupoConversor", forClass=Grupo.class)
public class GrupoConversor implements Converter{

	private GrupoImpl grupoImpl;
	
	public GrupoConversor() {
		grupoImpl = CDIServiceLocator.getBean(GrupoImpl.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		Grupo grupo = null;			

		if (valor != null) {
			grupo = grupoImpl.buscarPorId(new Long(valor));
		}

		return grupo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object valor) {
		
		if (valor != null) {
			Grupo grupo = (Grupo) valor;
			return grupo.getId() == null ? null : grupo.getId().toString();

		}
		
		return null;
	}

}
