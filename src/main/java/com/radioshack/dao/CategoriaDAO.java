package com.radioshack.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radioshack.model.JPAUtil;
import com.radioshack.model.Categoria;

public class CategoriaDAO {
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar un registro de categoria
	public void guardar(Categoria categoria) {
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
	//Editar un registro de categoria
	public void editar(Categoria categoria) {
		entityManager.getTransaction().begin();
		entityManager.merge(categoria);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//Obtener un registro de categoria
	public Categoria buscarPorId(Short idCategoria) {
		Categoria categoria;
		categoria = entityManager.find(Categoria.class, idCategoria);
		//JPAUtil.shutdown();
		return categoria;
	}
	//Consultar todos los registros de categoria
	public List<Categoria> buscarTodos() {
		List<Categoria> listCategorias;
		Query query = entityManager.createQuery("SELECT c FROM Categoria c WHERE estado = true");
		listCategorias = query.getResultList();
		Iterator iterator = listCategorias.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		return listCategorias;
	}
	
	//Eliminar una categoria fisicamente
	public void eliminar(Short idCategoria) {
		Categoria categoria;
		categoria = entityManager.find(Categoria.class, idCategoria);
		entityManager.getTransaction().begin();
		entityManager.remove(categoria);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
	
	public List<String> obtenerNombres() {
		List<String> listNombres;
		Query query = entityManager.createQuery("SELECT c.nombre FROM Categoria c WHERE c.estado = true");
		listNombres = query.getResultList();
		/*Iterator iterator = listProductos.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());*/
		return listNombres;
	}
}
