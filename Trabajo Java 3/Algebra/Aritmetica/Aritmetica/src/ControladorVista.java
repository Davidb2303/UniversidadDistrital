import java.util.List;

import javax.swing.JOptionPane;

class ControladorVista {
    public static void mostrarFactorizacionPrima(int numero, List<Factor> factores) {
        StringBuilder mensaje = new StringBuilder("<html>");
        mensaje.append("Factorización prima de ").append(numero).append(":<br>");

        for (Factor factor : factores) {
            String factorFormateado = "<font color='blue'>" + factor.factor + "</font>";
            String exponenteFormateado = "<font color='red'>" + factor.exponente + "</font>";
            mensaje.append(factorFormateado).append("^").append(exponenteFormateado).append("<br>");
        }
        mensaje.append("</html>");

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
