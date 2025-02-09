import javax.swing.*;
import java.awt.*;

public class InicioDialog extends JDialog {
    private JButton botonAceptar;
    private JPasswordField campoClave;

    public InicioDialog() {
        setModal(true);
        setSize(300, 200);
        setLayout(new BorderLayout()); // Cambio en el layout
        setTitle("Inicio de Sesión"); // Agregamos un título al diálogo
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel para la imagen
        JPanel panelImagen = new JPanel(new BorderLayout());
        ImageIcon icono = new ImageIcon("ctp1.jpg"); 
        Image imagen = icono.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH); // Cambiar tamaño a 300x100
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        JLabel imagenLabel = new JLabel(iconoRedimensionado);
        panelImagen.add(imagenLabel, BorderLayout.CENTER);
        add(panelImagen, BorderLayout.NORTH);

        // Cambiamos el color de fondo del diálogo
        getContentPane().setBackground(new Color(255,246,126));
        botonAceptar = new JButton("Aceptar");
        campoClave = new JPasswordField(10);

        add(new JLabel("Clave:"), BorderLayout.WEST);
        add(campoClave, BorderLayout.CENTER);
        add(botonAceptar, BorderLayout.SOUTH);

        botonAceptar.addActionListener(e -> setVisible(false));
    }

    public String getClave() {
        return new String(campoClave.getPassword());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InicioDialog dialog = new InicioDialog();
            dialog.setVisible(true);
        });
    }
}
