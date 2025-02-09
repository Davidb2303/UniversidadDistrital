package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Modelo;
import Vista.InterfazGrafica;

public class Controlador implements ActionListener {
    private InterfazGrafica vista; // Vista
    // Constructor que recibe la vista y el modelo

    public Controlador(InterfazGrafica vista, Modelo modelo) {
        this.vista = vista;
        // Agregar el controlador como listener al botón de la vista
        this.vista.getPanelControl().getBtnEncenderApagar().addActionListener(this);
    }

    // Método actionPerformed para manejar eventos de botón
    @Override
    public void actionPerformed(ActionEvent e) {
        // Verificar si el evento proviene del botón de encender/apagar
        if (e.getSource() == vista.getPanelControl().getBtnEncenderApagar()) {
            // Aquí puedes implementar la lógica para encender o apagar los paneles solares
            // Por ejemplo, cambiar el estado del modelo y actualizar la vista en
            // consecuencia
        }
    }
}
