package com.ibcj.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ibcj.model.Usuario;
import com.ibcj.repository.impl.UsuarioImpl;
import com.ibcj.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConversor implements Converter{

	private UsuarioImpl usuarioImpl;
	
	public UsuarioConversor() {
		usuarioImpl = CDIServiceLocator.getBean(UsuarioImpl.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		Usuario usuario = null;			

		if (valor != null) {
			usuario = usuarioImpl.buscarPorId(new Long(valor));
		}

		return usuario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object valor) {
		
		if (valor != null) {
			Usuario usuario = (Usuario) valor;
			return usuario.getId() == null ? null : usuario.getId().toString();

		}
		
		return null;
	}

}
