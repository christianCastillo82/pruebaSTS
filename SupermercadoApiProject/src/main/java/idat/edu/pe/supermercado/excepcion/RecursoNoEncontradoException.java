package idat.edu.pe.supermercado.excepcion;

import idat.edu.pe.supermercado.excepcion.dto.RespuestaExcepcion;


public class RecursoNoEncontradoException extends RuntimeException {

	private RespuestaExcepcion respuesta;

	public RecursoNoEncontradoException(RespuestaExcepcion respuesta) {
		super();
		this.respuesta = respuesta;
	}

	public RespuestaExcepcion getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(RespuestaExcepcion respuesta) {
		this.respuesta = respuesta;
	}
	
	
	
	
}
