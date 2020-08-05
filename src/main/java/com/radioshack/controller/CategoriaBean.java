package com.radioshack.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.radioshack.dao.CategoriaDAO;
import com.radioshack.model.Categoria;

@Named
@RequestScoped
public class CategoriaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	CategoriaDAO categoriaDAO;
	List<Categoria> listaCategorias = new ArrayList<Categoria>();
	
	public List<Categoria> getListaCategorias() {
		categoriaDAO = new CategoriaDAO();
		listaCategorias = categoriaDAO.buscarTodos();
		return listaCategorias;
	}
	
	public String editar(Short idCategoria) {
		categoriaDAO = new CategoriaDAO();
		Categoria categoria = new Categoria();
		categoria = categoriaDAO.buscarPorId(idCategoria);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("categoria", categoria);
		return "editCategoria";
	}
	
	public String actualizar(Categoria categoria) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.editar(categoria);
		return "allCategoria";
	}
	
	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	
	List<Categoria> listaNombreCategoria = new ArrayList<>();
	
	public List<Categoria> getListaNombreCategoria() {
		categoriaDAO = new CategoriaDAO();
		listaNombreCategoria = categoriaDAO.buscarTodos();
		return listaNombreCategoria;
		}
	
	public void setListaNombreCategoria(List<Categoria> listaNombreCategoria) {
		this.listaNombreCategoria = listaNombreCategoria;
		}
}
