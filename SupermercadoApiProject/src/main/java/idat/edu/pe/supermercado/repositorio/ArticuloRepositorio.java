package idat.edu.pe.supermercado.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import idat.edu.pe.supermercado.modelo.Articulo;
import idat.edu.pe.supermercado.modelo.Categoria;

@Component
public class ArticuloRepositorio {


	private static final Map<String,Articulo> articulos = new HashMap<>();

	@PostConstruct
	public void initData() {
		
		Categoria lacteos = new Categoria("001", "lacteos");
		Categoria frutas = new Categoria("002", "frutas");
		
		Articulo lecheGloria = new Articulo("ART001", "Leche Evaporada Gloria" , "Leche evaporada de 1L.t en tetrapack", 500, "gloria.jpg", lacteos);
		Articulo pinaGolden = new Articulo("ART002","Piña Golden","Piña Golden por kilo",560,"piña.jpg",frutas);
		
		
		articulos.put(lecheGloria.getId(), lecheGloria);
		articulos.put(pinaGolden.getId(),pinaGolden);

	}

	public List<Articulo> buscarArticulos() {
		List<Articulo> listaResultante = new ArrayList<Articulo>();
		Entry<String, Articulo> entry = null;
		for (Iterator<Entry<String, Articulo>> it = articulos.entrySet().iterator(); it.hasNext();) {
			entry = it.next();
			listaResultante.add(entry.getValue());
		}

		return listaResultante;
	}
	
	public Articulo buscarArticuloPorId(String id)
	{
		return articulos.get(id);
	}
	
	public void crearArticulo(Articulo articulo)
	{
		articulos.put(articulo.getId(), articulo);
	}
	
	public void eliminarArticulo(String id)
	{
		articulos.remove(id);
	}
	
	public void actualizarArticulo(String id , Articulo articulo)
	{
		articulos.put(String.valueOf(id), articulo);
	}

	public static Map<String, Articulo> getArticulos() {
		return articulos;
	}
	
	
	
	

	
}
