package com.radioshack.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radioshack.model.JPAUtil;
import com.radioshack.model.Proveedor;

public class ProveedorDAO {
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar un registro de proveedor
	public void guardar(Proveedor proveedor) {
		entityManager.getTransaction().begin();
		entityManager.persist(proveedor);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
	//Editar un registro de proveedor
	public void editar(Proveedor proveedor) {
		entityManager.getTransaction().begin();
		entityManager.merge(proveedor);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//Obtener un registro de proveedor
	public Proveedor buscarPorId(Short idProveedor) {
		Proveedor proveedor;
		proveedor = entityManager.find(Proveedor.class, idProveedor);
		//JPAUtil.shutdown();
		return proveedor;
	}
	//Consultar todos los registros de proveedor
	public List<Proveedor> buscarTodos() {
		List<Proveedor> listProveedores;
		Query query = entityManager.createQuery("SELECT pr FROM Proveedor pr WHERE estado = true");
		listProveedores = query.getResultList();
		Iterator iterator = listProveedores.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		return listProveedores;
	}
	//Eliminar un proveedor fisicamente
	public void eliminar(Short idProveedor) {
		Proveedor proveedor;
		proveedor = entityManager.find(Proveedor.class, idProveedor);
		entityManager.getTransaction().begin();
		entityManager.remove(proveedor);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
}
