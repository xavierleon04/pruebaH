package com.radioshack.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.radioshack.dao.EmpleadoDAO;
import com.radioshack.model.Empleado;

@Named
@RequestScoped
public class EmpleadoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	EmpleadoDAO empleadoDAO;
	List<Empleado> listaEmpleados = new ArrayList<Empleado>();
	
	public List<Empleado> getListaEmpleados() {
		empleadoDAO = new EmpleadoDAO();
		listaEmpleados = empleadoDAO.buscarTodos();
		return listaEmpleados;
	}

	public String editar(Short idEmpleado) {
		empleadoDAO = new EmpleadoDAO();
		Empleado empleado = new Empleado();
		empleado = empleadoDAO.buscarPorId(idEmpleado);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("empleado", empleado);
		return "editEmpleados";
	}
	
	public String actualizar(Empleado empleado) {
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		empleadoDAO.editar(empleado);
		return "allEmpleados";
	}
	
	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
}
