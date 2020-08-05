package com.radioshack.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radioshack.model.JPAUtil;
import com.radioshack.model.Direccion;

public class DireccionDAO {
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar un registro de direccion
	public void guardar(Direccion direccion) {
		entityManager.getTransaction().begin();
		entityManager.persist(direccion);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
	//Editar un registro de direccion
	public void editar(Direccion direccion) {
		entityManager.getTransaction().begin();
		entityManager.merge(direccion);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//Obtener un registro de direccion
	public Direccion buscarPorId(Short idDireccion) {
		Direccion direccion;
		direccion = entityManager.find(Direccion.class, idDireccion);
		//JPAUtil.shutdown();
		return direccion;
	}
	//Consultar todos los registros de direccion
	public List<Direccion> buscarTodos() {
		List<Direccion> listDirecciones;
		Query query = entityManager.createQuery("SELECT d FROM Direccion d WHERE estado = true");
		listDirecciones = query.getResultList();
		Iterator iterator = listDirecciones.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		return listDirecciones;
	}
	
	//Eliminar una direccion fisicamente
	public void eliminar(Short idDireccion) {
		Direccion direccion;
		direccion = entityManager.find(Direccion.class, idDireccion);
		entityManager.getTransaction().begin();
		entityManager.remove(direccion);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
}
