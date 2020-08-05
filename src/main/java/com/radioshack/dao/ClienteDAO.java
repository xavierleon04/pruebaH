package com.radioshack.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radioshack.model.JPAUtil;
import com.radioshack.model.Cliente;

public class ClienteDAO {
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar un registro de cliente
	public void guardar(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
	//Editar un registro de cliente
	public void editar(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//Obtener un registro de cliente
	public Cliente buscarPorId(Short idCliente) {
		Cliente cliente;
		cliente = entityManager.find(Cliente.class, idCliente);
		//JPAUtil.shutdown();
		return cliente;
	}
	//Consultar todos los registros de cliente
	public List<Cliente> buscarTodos() {
		List<Cliente> listClientes;
		Query query = entityManager.createQuery("SELECT cl FROM Cliente cl WHERE estado = true");
		listClientes = query.getResultList();
		Iterator iterator = listClientes.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		return listClientes;
	}
	
	//Eliminar un cliente fisicamente
	public void eliminar(Short idCliente) {
		Cliente cliente;
		cliente = entityManager.find(Cliente.class, idCliente);
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
}