package idat.edu.pe.supermercado.modelo;

import java.io.Serializable;

public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -877830025038128584L;

	
	private String codigo;
	
	private String descripcion;

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
