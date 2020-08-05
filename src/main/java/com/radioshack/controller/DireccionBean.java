package com.radioshack.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.radioshack.dao.DireccionDAO;
import com.radioshack.model.Direccion;

@Named
@RequestScoped
public class DireccionBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	DireccionDAO direccionDAO;
	List<Direccion> listaDirecciones = new ArrayList<Direccion>();
	
	public List<Direccion> getListaDirecciones() {
		direccionDAO = new DireccionDAO();
		listaDirecciones = direccionDAO.buscarTodos();
		return listaDirecciones;
	}
	
	public String editar(Short idDireccion) {
		direccionDAO = new DireccionDAO();
		Direccion direccion = new Direccion();
		direccion = direccionDAO.buscarPorId(idDireccion);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("direccion", direccion);
		return "editDirecciones";
	}
	
	public String actualizar(Direccion direccion) {
		DireccionDAO direccionDAO = new DireccionDAO();
		direccionDAO.editar(direccion);
		return "allDirecciones";
	}
	
	public void setListaDirecciones(List<Direccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}
	
	List<Direccion> listaNombreDireccion = new ArrayList<>();
	
	public List<Direccion> getListaNombreDireccion() {
		direccionDAO = new DireccionDAO();
		listaNombreDireccion = direccionDAO.buscarTodos();
		return listaNombreDireccion;
		}
	
	public void setListaNombreDireccion(List<Direccion> listaNombreDireccion) {
		this.listaNombreDireccion = listaNombreDireccion;
		}
}
