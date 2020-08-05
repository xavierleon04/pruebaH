package com.radioshack.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radioshack.model.JPAUtil;
import com.radioshack.model.Empleado;

public class EmpleadoDAO {
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar un registro de empleado
	public void guardar(Empleado empleado) {
		entityManager.getTransaction().begin();
		entityManager.persist(empleado);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
	//Editar un registro de empleado
	public void editar(Empleado empleado) {
		entityManager.getTransaction().begin();
		entityManager.merge(empleado);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//Obtener un registro de empleado
	public Empleado buscarPorId(Short idEmpleado) {
		Empleado empleado;
		empleado = entityManager.find(Empleado.class, idEmpleado);
		//JPAUtil.shutdown();
		return empleado;
	}
	//Consultar todos los registros de empleado
	public List<Empleado> buscarTodos() {
		List<Empleado> listEmpleados;
		Query query = entityManager.createQuery("SELECT e FROM Empleado e WHERE estado = true");
		listEmpleados = query.getResultList();
		Iterator iterator = listEmpleados.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		return listEmpleados;
	}
	
	//Eliminar un empleado fisicamente
	public void eliminar(Short idEmpleado) {
		Empleado empleado;
		empleado = entityManager.find(Empleado.class, idEmpleado);
		entityManager.getTransaction().begin();
		entityManager.remove(empleado);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
}