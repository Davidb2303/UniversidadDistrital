import javax.swing.*;
import java.awt.*;

public class VistaResultadoBusqueda extends JDialog {
    public VistaResultadoBusqueda(boolean encontrada) {
        setModal(true);
        setSize(300, 150);
        setTitle("Resultado de búsqueda");
        getContentPane().setBackground(encontrada ? Color.GREEN : Color.RED);
        JLabel mensajeLabel = new JLabel();
        if (encontrada) {
            mensajeLabel.setText("La película fue encontrada.");
        } else {
            mensajeLabel.setText("La película no fue encontrada.");
        }

        add(mensajeLabel);
        setLocationRelativeTo(null);
    }
}
