package Vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLogo extends JPanel {
    // Ruta de la imagen del logo
    private static final String RUTA_IMAGEN = "./imagenes/logoPaneles.png";

    // Etiqueta para mostrar la imagen
    private JLabel etiqueta;

    public PanelLogo() {
        setBackground(Color.WHITE); // Establece el color de fondo del panel
        ImageIcon imagen = new ImageIcon(RUTA_IMAGEN); // Crea un ImageIcon con la imagen
        etiqueta = new JLabel(); // Crea una etiqueta para mostrar la imagen
        etiqueta.setIcon(imagen); // Asigna la imagen a la etiqueta
        add(etiqueta); // Agrega la etiqueta al panel
    }
}
