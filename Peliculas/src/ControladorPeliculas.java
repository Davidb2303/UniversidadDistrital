import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorPeliculas {
    private VistaPeliculas vista;
    private ICatalogoPeliculas catalogo;

    public ControladorPeliculas(VistaPeliculas vista, ICatalogoPeliculas catalogo) {
        this.vista = vista;
        this.catalogo = catalogo;

        // Agregar ActionListener a los botones
        vista.getBotonListar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarPeliculas();
            }
        });
        
        vista.getBotonAgregar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarPelicula();
            }
        });

        vista.getBotonBuscar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPelicula();
            }
        });

        vista.getBotonIniciar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarArchivo();
            }
        });
    }

    private void iniciarArchivo() {
        catalogo.iniciarArchivo("peliculas.txt");
        vista.mostrarMensajeExito("Archivo iniciado con éxito.");
        vista.ocultarBotones();
    }

    private void listarPeliculas() {
        List<Pelicula> peliculas = catalogo.listarPelicula("peliculas.txt");
        List<String> nombresPeliculas = peliculas.stream()
                .map(Pelicula::getNombre)
                .collect(Collectors.toList());

        vista.actualizarListaPeliculas(nombresPeliculas);
    }

    private void agregarPelicula() {
        String nombrePelicula = vista.getCampoTexto().getText().trim();
        if (nombrePelicula.isEmpty()) {
            vista.mostrarMensajeError("No se puede guardar algo vacío.");
        } else {
            catalogo.agregarPelicula(nombrePelicula, "peliculas.txt");
            vista.mostrarMensajeExito("La película se agregó con éxito.");
            vista.mostrarBotones();
            listarPeliculas(); // Actualizar la lista después de agregar una película
            vista.limpiarVista(); // Limpiar la vista
        }
    }
    

    private void buscarPelicula() {
        String nombrePelicula = vista.getCampoTexto().getText().trim();
        if (nombrePelicula.isEmpty()) {
            vista.mostrarMensajeError("No ha ingresado el nombre de ninguna película.");
        } else {
            List<Pelicula> peliculas = catalogo.listarPelicula("peliculas.txt");
    
            // Filtrar las películas cuyos nombres contengan la palabra proporcionada
            List<Pelicula> peliculasCoincidentes = peliculas.stream()
                    .filter(pelicula -> pelicula.getNombre().toLowerCase().contains(nombrePelicula.toLowerCase()))
                    .collect(Collectors.toList());
    
            // Extraer los nombres de las películas coincidentes
            List<String> nombresPeliculas = peliculasCoincidentes.stream()
                    .map(Pelicula::getNombre)
                    .collect(Collectors.toList());
    
            // Actualizar la vista con las películas encontradas
            vista.actualizarListaPeliculas(nombresPeliculas);
        }

    }
}
