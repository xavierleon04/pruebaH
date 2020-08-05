package com.radioshack.model;

import javax.persistence.*;

@Entity
@Table
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direccion")
	private Short idDireccion;
	@Column
	private String calle;
	@Column
	private String numero;
	@Column
	private String colonia;
	@Column(name = "codigo_p")
	private String codigoP;
	@Column
	private String ciudad;
	@Column(name = "entidad_f")
	private String entidadF;
	@Column
	private Boolean estado;
	
	public Short getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(Short idDireccion) {
		this.idDireccion = idDireccion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCodigoP() {
		return codigoP;
	}
	public void setCodigoP(String codigoP) {
		this.codigoP = codigoP;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEntidadF() {
		return entidadF;
	}
	public void setEntidadF(String entidadF) {
		this.entidadF = entidadF;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calle=" + calle + ", numero=" + numero + ", colonia="
				+ colonia + ", codigoP=" + codigoP + ", ciudad=" + ciudad + ", entidadF=" + entidadF + ", estado="
				+ estado + "]";
	}
}
