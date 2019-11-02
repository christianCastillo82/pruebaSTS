package idat.edu.pe.supermercado.controlador;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.edu.pe.supermercado.excepcion.RecursoNoEncontradoException;
import idat.edu.pe.supermercado.excepcion.dto.RespuestaExcepcion;
import idat.edu.pe.supermercado.modelo.Articulo;
import idat.edu.pe.supermercado.repositorio.ArticuloRepositorio;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/supermercado/articulos")
public class ArticuloController {

	@Autowired
	private ArticuloRepositorio repositorio;

	@Autowired
	private MessageSource messageSource;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	@ApiOperation(value = "Devuelve la lista de todos los articulos", httpMethod = "GET", nickname = "buscarArticulos")
	public ResponseEntity<Object> buscarTodo() {

		List<Articulo> listaArticulos = repositorio.buscarArticulos();
		return new ResponseEntity<Object>(listaArticulos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	@ApiOperation(value = "Devuele un articulo por su Id", httpMethod = "GET", nickname = "buscarArticuloPorID")
	public ResponseEntity<Object> buscarPorId(@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@ApiParam(value = "Identificador del articulo", required = true) @PathVariable("id") String id) {
		Articulo articulo = repositorio.buscarArticuloPorId(id);

		if (articulo == null)

			throw new RecursoNoEncontradoException(new RespuestaExcepcion(new Date(), "Error",
					messageSource.getMessage("articulosPorId.NotFound.message", null, locale)));
		
		return new ResponseEntity<Object>(articulo, HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> crear(@RequestBody Articulo articulo) {

		if (articulo.getId() == null || articulo.getId() == "")
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Articulo no encontrado");

		repositorio.crearArticulo(articulo);
		;
		return new ResponseEntity<Object>("Articulio creado correctamente", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> eliminar(@PathVariable("id") String id) {
		repositorio.eliminarArticulo(id);
		return new ResponseEntity<Object>("Articulo eliminado correctamente", HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> actualizar(@PathVariable("id") String id, @RequestBody Articulo articulo) {

		if (!repositorio.getArticulos().containsKey(id))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Articulo no encontrado,imposible de actualizar");
		repositorio.actualizarArticulo(id, articulo);
		return new ResponseEntity<Object>("Articulo actualizado correctamente", HttpStatus.OK);
	}

}
