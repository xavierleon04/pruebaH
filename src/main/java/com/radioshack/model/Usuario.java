package com.radioshack.model;

import javax.persistence.*;

@Entity
@Table
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Short idUsuario;
	@Column
	private String usuario;
	@Column
	private String contrasena;
	@Column
	private String imagen;
	@Column(name = "fecha_creacion")
	private String fechaCreacion;
	@Column
	private String tipo;
	@Column
	private Boolean estado;
	
	public Short getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Short idUsuario) {
		this.idUsuario = idUsuario;
	}
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", contrasena=" + contrasena + ", imagen="
				+ imagen + ", fechaCreacion=" + fechaCreacion + ", tipo=" + tipo + ", estado=" + estado + "]";
	}
}
