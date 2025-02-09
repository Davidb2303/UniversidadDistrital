import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaPeliculas extends JFrame {
    private JTextField campoTexto;
    private JButton botonAgregar;
    private JButton botonListar;
    private JButton botonBuscar;
    private JButton botonIniciar;
    private JList<String> listaPeliculas;

    public VistaPeliculas() {
        // Configuración de la ventana
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cinephile's Compendium");
        getContentPane().setLayout(new BorderLayout());

        // Panel para la imagen y los botones
        JPanel panelSuperior = new JPanel(new BorderLayout());

        // Cambiar tamaño de la imagen
        ImageIcon icono = new ImageIcon("ctp.jpg"); // Reemplaza con la ruta de tu imagen
        Image imagen = icono.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH); // Cambiar tamaño a 200x100
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        JLabel imagenLabel = new JLabel(iconoRedimensionado);
        panelSuperior.add(imagenLabel, BorderLayout.CENTER);

        // Botones en la parte superior
        JPanel panelBotones = new JPanel(new FlowLayout());
        botonAgregar = new JButton("Agregar película");
        botonListar = new JButton("Listar películas");
        botonBuscar = new JButton("Buscar película");
        botonIniciar = new JButton("Iniciar archivo");
        panelBotones.add(botonAgregar);
        panelBotones.add(botonListar);
        panelBotones.add(botonBuscar);
        panelBotones.add(botonIniciar);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        getContentPane().add(panelSuperior, BorderLayout.NORTH);

        // Campo de texto y lista de películas en el centro
        JPanel panelCentral = new JPanel(new BorderLayout());
        campoTexto = new JTextField(20);
        panelCentral.add(campoTexto, BorderLayout.NORTH);

        listaPeliculas = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaPeliculas);
        panelCentral.add(scrollPane, BorderLayout.SOUTH);

        getContentPane().add(panelCentral, BorderLayout.CENTER);

        // Estilo de los componentes
        botonAgregar.setBackground(new Color(191, 234, 124));
        botonAgregar.setForeground(new Color(65, 109, 25));
        botonAgregar.setFont(new Font("Arial", Font.BOLD, 14));
        botonListar.setBackground(new Color(191, 234, 124));
        botonListar.setForeground(new Color(65, 109, 25));
        botonListar.setFont(new Font("Arial", Font.BOLD, 14));
        botonBuscar.setBackground(new Color(191, 234,124));
        botonBuscar.setForeground(new Color(65, 109, 25));
        botonBuscar.setFont(new Font("Arial", Font.BOLD, 14));
        botonIniciar.setBackground(new Color(191, 234, 124));
        botonIniciar.setForeground(new Color(65, 109, 25));
        botonIniciar.setFont(new Font("Arial", Font.BOLD, 14));
        campoTexto.setFont(new Font("Arial", Font.BOLD, 14));
        campoTexto.setBackground(new Color(191, 234, 124));
        campoTexto.setForeground(new Color(65, 109, 25));
        listaPeliculas.setBackground(new Color(191, 234, 124));
        listaPeliculas.setForeground(new Color(65, 109, 25));

        // Mostrar la ventana
        setVisible(true);
    }

    // Métodos para manipular la GUI desde el controlador

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public void ocultarBotones() {
        botonAgregar.setVisible(false);
        botonListar.setVisible(false);
        botonBuscar.setVisible(false);
    }

    public void mostrarBotones() {
        botonAgregar.setVisible(true);
        botonListar.setVisible(true);
        botonBuscar.setVisible(true);
    }

    public void actualizarListaPeliculas(List<String> nombresPeliculas) {
        listaPeliculas.setListData(nombresPeliculas.toArray(new String[0]));
    }

    // Getters para los componentes de la GUI

    public JTextField getCampoTexto() {
        return campoTexto;
    }

    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public JButton getBotonListar() {
        return botonListar;
    }

    public JButton getBotonBuscar() {
        return botonBuscar;
    }

    public JButton getBotonIniciar() {
        return botonIniciar;
    }
    public void limpiarVista() {
        campoTexto.setText(""); // Limpiar el campo de texto
        listaPeliculas.setListData(new String[0]); // Limpiar la lista de películas
    }
}


