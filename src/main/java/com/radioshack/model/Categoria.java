package com.radioshack.model;

import javax.persistence.*;

@Entity
@Table
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Short idCategoria;
	@Column
	private String nombre;
	@Column
	private Boolean estado;
	
	public Short getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Short idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
}
