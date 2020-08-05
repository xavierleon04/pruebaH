package com.radioshack.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.radioshack.dao.ProductoDAO;
import com.radioshack.model.Producto;

@Named
@RequestScoped
public class ProductoBean implements Serializable{
	private Part img;
	private static final long serialVersionUID = 1L;
	ProductoDAO productoDAO;
	List<Producto> listaProductos = new ArrayList<Producto>();
	
	public String nuevo() {
		Producto producto = new Producto();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", producto);
		return  "addProduct";
	}
	
	public String guardar (Producto producto) {	
		producto.setEstado(true);
		producto.setImagen(img.getSubmittedFileName());
		ProductoDAO productoDAO= new ProductoDAO();
		productoDAO.guardar(producto);
		return  "allProducts";
	}
	
	public List<Producto> getListaProductos() {
		productoDAO = new ProductoDAO();
		listaProductos = productoDAO.buscarTodos();
		return listaProductos;
	}
	
	public String editar(Short idProducto) {
		productoDAO = new ProductoDAO();
		Producto producto = new Producto();
		producto = productoDAO.buscarPorId(idProducto);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", producto);
		return "editProduct";
	}
	
	public String actualizar(Producto producto) {
		if(img != null) {
			producto.setImagen(img.getSubmittedFileName());
		}		
		ProductoDAO productoDAO = new ProductoDAO();
		productoDAO.editar(producto);
		return "allProducts";
	}
	public String eliminar (Short idProducto) {
		productoDAO = new ProductoDAO();
		Producto producto = new Producto();
		producto = productoDAO.buscarPorId(idProducto);	
		
		producto.setEstado(false);
		productoDAO.editar(producto);
		return "allProducts";
		
	}
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Part getImg() {
		return img;
	}

	public void setImg(Part img) {
		this.img = img;
	}
}
