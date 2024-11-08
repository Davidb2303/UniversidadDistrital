import javax.swing.JOptionPane;

public class VistaPolinomio {
    public static double[] obtenerCoeficientes() {
        String input = JOptionPane.showInputDialog("Ingrese los coeficientes del polinomio separados por comas:");
        String[] coeficientesStr = input.split(",");
        double[] coeficientes = new double[coeficientesStr.length];
        for (int i = 0; i < coeficientesStr.length; i++) {
            coeficientes[i] = Double.parseDouble(coeficientesStr[i]);
        }
        return coeficientes;
    }

    public static void mostrarRaices(double[] raices) {
        StringBuilder mensaje = new StringBuilder("Las raíces del polinomio son:\n");
        for (double raiz : raices) {
            mensaje.append(raiz).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
