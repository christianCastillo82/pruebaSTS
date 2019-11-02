package idat.edu.pe.supermercado.excepcion.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import idat.edu.pe.supermercado.excepcion.RecursoNoEncontradoException;

@ControllerAdvice
@RestController
public class ExcepcionesController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecursoNoEncontradoException.class)
	public final ResponseEntity<Object> handleRecursoNoEncontrado(RecursoNoEncontradoException ex, WebRequest request) throws Exception {
		return new ResponseEntity<Object>(ex.getRespuesta(),HttpStatus.NOT_FOUND);
	}
}
