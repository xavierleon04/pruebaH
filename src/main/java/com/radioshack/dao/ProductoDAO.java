package com.radioshack.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radioshack.model.JPAUtil;
import com.radioshack.model.Producto;

public class ProductoDAO {
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar un registro de producto
	public void guardar(Producto producto) {
		entityManager.getTransaction().begin();
		entityManager.persist(producto);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//Editar un registro de producto
	public void editar(Producto producto) {
		entityManager.getTransaction().begin();
		entityManager.merge(producto);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//Obtener un registro de producto
	public Producto buscarPorId(Short idProducto) {
		Producto producto;
		producto = entityManager.find(Producto.class, idProducto);
		//JPAUtil.shutdown();
		return producto;
	}
	//Consultar todos los registros de producto
	public List<Producto> buscarTodos() {
		List<Producto> listProductos;
		Query query = entityManager.createQuery("SELECT p FROM Producto p WHERE estado = true");
		listProductos = query.getResultList();
		Iterator iterator = listProductos.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		return listProductos;
	}
	
	//Eliminar un producto fisicamente
	public void eliminar(Short idProducto) {
		Producto producto;
		producto = entityManager.find(Producto.class, idProducto);
		entityManager.getTransaction().begin();
		entityManager.remove(producto);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
}
