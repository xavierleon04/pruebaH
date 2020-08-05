package com.radioshack.model;

import javax.persistence.*;

@Entity
@Table
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Short idProducto;
	@Column
	private String sku;
	@Column
	private String descripcion;
	@Column(name = "precio_compra")
	private Double precioCompra;
	@Column(name = "precio_venta")
	private Double precioVenta;
	@Column
	private Integer existencia;
	@Column
	private String imagen;
	@Column
	private Boolean estado;
	@Column(name = "id_categoria")
	private Short idCategoria;
	
	public Short getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Short idProducto) {
		this.idProducto = idProducto;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public Integer getExistencia() {
		return existencia;
	}
	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Short getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Short idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", sku=" + sku + ", descripcion=" + descripcion
				+ ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", existencia=" + existencia
				+ ", imagen=" + imagen + ", estado=" + estado + ", idCategoria=" + idCategoria + "]";
	}
}
