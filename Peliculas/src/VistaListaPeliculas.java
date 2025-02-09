import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class VistaListaPeliculas extends JDialog {
    private JList<String> listaPeliculas;

    public VistaListaPeliculas() {
        // Configuración de la ventana y otros componentes

        // Crear la lista de películas y agregarla al panel
        listaPeliculas = new JList<>();
        add(new JScrollPane(listaPeliculas));

        // Configurar otros componentes y acciones
    }

    // Método para actualizar la lista de películas en la vista
    public void actualizarVista(List<String> nombresPeliculas) {
        listaPeliculas.setListData(nombresPeliculas.toArray(new String[0]));
    }
}