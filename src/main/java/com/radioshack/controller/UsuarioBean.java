package com.radioshack.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.radioshack.dao.UsuarioDAO;
import com.radioshack.model.Usuario;

@Named
@RequestScoped
public class UsuarioBean implements Serializable{
	private Part img;
	private String usuario;
	private String contrasena;
	public static final String LOGOUT_PAGE_REDIRECT = "/login.xhtml?faces-redirect=true";

	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDAO;
	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String validar() {
		System.out.println("Validar(): " + usuario + "" + contrasena);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		boolean valido = usuarioDAO.esValido(usuario, contrasena);
		if (valido) {
			HttpSession session = SesionUtils.getSession();
			session.setAttribute("usuario", usuario);
			return "dashboard";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}

	public String cerrar() {
		System.out.println("Cerrando");
		HttpSession session = SesionUtils.getSession();
		session.invalidate();
		return LOGOUT_PAGE_REDIRECT;
	}

	
	
	public List<Usuario> getListaUsuarios() {
		usuarioDAO = new UsuarioDAO();
		listaUsuarios = usuarioDAO.buscarTodos();
		return listaUsuarios;
	}
	
	public String editar(Short idUsuario) {
		usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario = usuarioDAO.buscarPorId(idUsuario);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", usuario);
		return "editUsuarios";
	}
	
	public String actualizar(Usuario usuario) {
		usuario.setImagen(img.getSubmittedFileName());
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.editar(usuario);
		return "allUsuarios";
	}
	
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	List<Usuario> listaNombreUsuario = new ArrayList<>();
	
	public List<Usuario> getListaNombreUsuario() {
		usuarioDAO = new UsuarioDAO();
		listaNombreUsuario = usuarioDAO.buscarTodos();
		return listaNombreUsuario;
	}
	
	public void setListaNombreUsuario(List<Usuario> listaNombreUsuario) {
		this.listaNombreUsuario = listaNombreUsuario;
	}
	
	public Part getImg() {
		return img;
	}

	public void setImg(Part img) {
		this.img = img;
	}
}
