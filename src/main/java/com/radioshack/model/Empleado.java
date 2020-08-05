package com.radioshack.model;

import javax.persistence.*;

@Entity
@Table
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empleado")
	private Short idEmpleado;
	@Column
	private String nombre;
	@Column(name = "apellido_p")
	private String apellidoP;
	@Column(name = "apellido_m")
	private String apellidoM;
	@Column
	private String telefono;
	@Column(name = "correo_e")
	private String correoE;
	@Column
	private String puesto;
	@Column
	private Double sueldo;
	@Column
	private Boolean estado;
	@Column(name = "id_direccion")
	private Short idDireccion;
	@Column(name = "id_usuario")
	private Short idUsuario;
	
	public Short getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Short idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoE() {
		return correoE;
	}
	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Short getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(Short idDireccion) {
		this.idDireccion = idDireccion;
	}
	public Short getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Short idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM="
				+ apellidoM + ", telefono=" + telefono + ", correoE=" + correoE + ", puesto=" + puesto + ", sueldo="
				+ sueldo + ", estado=" + estado + ", idDireccion=" + idDireccion + ", idUsuario=" + idUsuario + "]";
	}
}
