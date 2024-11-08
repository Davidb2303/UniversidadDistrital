package Vista;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class InterfazGrafica {
    private JFrame marcoPrincipal; // Ventana principal
    private Container contenedorMarcoPrincipal; // Contenedor principal
    private PanelLogo panelLogo; // Panel para mostrar el logo
    private PanelControl panelControl; // Panel para los controles

    public InterfazGrafica() {
        // Creación del marco principal y su contenedor
        marcoPrincipal = new JFrame("Sistema de Paneles Solares");
        contenedorMarcoPrincipal = marcoPrincipal.getContentPane();
        contenedorMarcoPrincipal.setLayout(new BorderLayout(5, 5));

        // Creación de los paneles
        panelLogo = new PanelLogo();
        panelControl = new PanelControl();

        // Agregar los paneles al contenedor principal
        contenedorMarcoPrincipal.add(panelLogo, BorderLayout.CENTER);
        contenedorMarcoPrincipal.add(panelControl, BorderLayout.SOUTH);

        // Ajustar el tamaño del marco según los componentes
        marcoPrincipal.pack();
        // Hacer visible el marco
        marcoPrincipal.setVisible(true);
        // Cerrar la aplicación al cerrar la ventana
        marcoPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Getters para acceder a los paneles desde el controlador
    public PanelLogo getPanelLogo() {
        return panelLogo;
    }

    public PanelControl getPanelControl() {
        return panelControl;
    }
}
