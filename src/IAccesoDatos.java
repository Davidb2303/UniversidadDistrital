
import java.io.FileNotFoundException;
import java.util.*;

// Esta interfaz define las operaciones que se pueden realizar en los archivos de datos.
public interface IAccesoDatos{
    public boolean existe(String nombreArchivo) throws FileNotFoundException;
    public List <Pelicula> listar(String nombre) ;
    public void escribir(Pelicula pelicala, String nombreArchivo, boolean anexar);
    public String buscar(String nombreArchivo, String buscar);
    public void crear(String nombreArchivo);
    public void borrar(String nombreArchivo);
}
