// Esta interfaz define las operaciones que se pueden realizar en el catálogo de películas.

import java.util.List;

public interface ICatalogoPeliculas {
    public void agregarPelicula(String nombrePleicula, String nombreArchivo);
    public List<Pelicula> listarPelicula(String nombreArchivo);
    public String buscarPelicula(String nombreArchio, String buscar);
    public void iniciarArchivo(String nombreArchivo);
    public boolean existePelicula(String string, String nombreABuscar);
}
