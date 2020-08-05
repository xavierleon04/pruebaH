package com.radioshack.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.radioshack.dao.ClienteDAO;
import com.radioshack.model.Cliente;

@Named
@RequestScoped
public class ClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDAO;
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	
	public List<Cliente> getListaClientes() {
		clienteDAO = new ClienteDAO();
		listaClientes = clienteDAO.buscarTodos();
		return listaClientes;
	}
	
	public String editar(Short idCliente) {
		clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		cliente = clienteDAO.buscarPorId(idCliente);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", cliente);
		return "editClientes";
	}
	
	public String actualizar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
		return "allClientes";
	}
	
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
}
