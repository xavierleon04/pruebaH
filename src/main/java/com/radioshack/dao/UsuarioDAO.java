package com.radioshack.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radioshack.model.JPAUtil;
import com.radioshack.model.Usuario;

public class UsuarioDAO {
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar un registro de usuario
	public void guardar(Usuario usuario) {
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
	//Editar un registro de usuario
	public void editar(Usuario usuario) {
		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//Obtener un registro de usuario
	public Usuario buscarPorId(Short idUsuario) {
		Usuario usuario;
		usuario = entityManager.find(Usuario.class, idUsuario);
		//JPAUtil.shutdown();
		return usuario;
	}
	//Consultar todos los registros de usuario
	public List<Usuario> buscarTodos() {
		List<Usuario> listUsuarios;
		Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.estado = true");
		listUsuarios = query.getResultList();
		Iterator iterator = listUsuarios.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		return listUsuarios;
	}
	
	//Eliminar un usuario fisicamente
	public void eliminar(Short idUsuario) {
		Usuario usuario;
		usuario = entityManager.find(Usuario.class, idUsuario);
		entityManager.getTransaction().begin();
		entityManager.remove(usuario);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();
	}
	
	public List<String> obtenerNombres() {
		List<String> listNombres;
		Query query = entityManager.createQuery("SELECT u.usuario FROM Usuario u WHERE u.estado = true");
		listNombres = query.getResultList();
		/*Iterator iterator = listProductos.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());*/
		return listNombres;
	}
	
	public boolean esValido(String usuario, String contrasena) {
		System.out.println("esValido() " + usuario + "" + contrasena);
		Query query = entityManager.createQuery(
				"SELECT u.usuario, u.contrasena FROM Usuario u WHERE u.usuario LIKE :usuario and u.contrasena LIKE :contrasena");
		query.setParameter("usuario", usuario);
		query.setParameter("contrasena", contrasena);
		List<String> dato = query.getResultList();
		if (!dato.isEmpty()) {
			System.out.println("Datos correctos");
			return true;
		}
		return false;
	}

}
