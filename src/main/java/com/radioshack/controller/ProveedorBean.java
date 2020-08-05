package com.radioshack.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.radioshack.dao.ProveedorDAO;
import com.radioshack.model.Proveedor;

@Named
@RequestScoped
public class ProveedorBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	ProveedorDAO proveedorDAO;
	List<Proveedor> listaProveedores = new ArrayList<Proveedor>();
	
	public List<Proveedor> getListaProveedores() {
		proveedorDAO = new ProveedorDAO();
		listaProveedores = proveedorDAO.buscarTodos();
		return listaProveedores;
	}
	
	public String editar(Short idProveedor) {
		proveedorDAO = new ProveedorDAO();
		Proveedor proveedor = new Proveedor();
		proveedor = proveedorDAO.buscarPorId(idProveedor);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("proveedor", proveedor);
		return "editProveedores";
	}
	
	public String actualizar(Proveedor proveedor) {
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		proveedorDAO.editar(proveedor);
		return "allProveedores";
	}
	
	public void setListaProveedores(List<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}
}
