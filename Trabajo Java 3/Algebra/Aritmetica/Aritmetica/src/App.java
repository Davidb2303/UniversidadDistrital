import java.util.List;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entero:"));
        List<Factor> factores = FactorizacionPrima.factorizar(numero);
        ControladorVista.mostrarFactorizacionPrima(numero, factores);
    }
}
