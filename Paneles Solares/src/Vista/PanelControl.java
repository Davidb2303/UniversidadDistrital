package Vista;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelControl extends JPanel {
    // Botón para encender y apagar
    private JButton btnEncenderApagar;

    public PanelControl() {
        setBackground(Color.LIGHT_GRAY); // Establece el color de fondo del panel
        setLayout(new FlowLayout(FlowLayout.CENTER)); // Establece el diseño del panel

        btnEncenderApagar = new JButton("Encender"); // Crea el botón con el texto "Encender"
        add(btnEncenderApagar); // Agrega el botón al panel
    }

    // Métodos getter y setter para el botón
    public JButton getBtnEncenderApagar() {
        return btnEncenderApagar;
    }

    public void setBtnEncenderApagar(JButton btnEncenderApagar) {
        this.btnEncenderApagar = btnEncenderApagar;
    }
}
