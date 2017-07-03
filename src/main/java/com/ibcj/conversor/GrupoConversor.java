package com.ibcj.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ibcj.model.Grupo;
import com.ibcj.repository.IGrupo;
import com.ibcj.repository.impl.GrupoImpl;

@FacesConverter(value="grupoConversor")
public class GrupoConversor implements Converter{

	private IGrupo iGrupo;
	
	public GrupoConversor() {
		iGrupo = new GrupoImpl();
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		Grupo grupo = null;			

		if (valor != null) {
			grupo = iGrupo.buscarPorId(new Long(valor));
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
