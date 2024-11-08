import java.util.function.DoubleUnaryOperator;

import javax.swing.JOptionPane;

public class Vista {

    public static void mostrarVentanaPrincipal() {
        // Obtener la función del usuario
        String funcionInput = JOptionPane.showInputDialog(null,
                "<html><font color='blue'>Introduce la función (por ejemplo, x^2):</font></html>");
        DoubleUnaryOperator funcion = x -> {
            try {
                return Double.parseDouble(funcionInput.replace("x", String.valueOf(x)));
            } catch (NumberFormatException e) {
                mostrarMensajeError("Función inválida. Asegúrate de usar el formato correcto (por ejemplo, x).");
                System.exit(1);
                return 0; // Nunca se llega aquí, pero necesario para compilar
            }
        };

        // Obtener los límites de integración del usuario
        String limiteInferiorInput = JOptionPane.showInputDialog(null,
                "<html><font color='blue'>Introduce el límite inferior de integración:</font></html>");
        double limiteInferior = Double.parseDouble(limiteInferiorInput);

        String limiteSuperiorInput = JOptionPane.showInputDialog(null,
                "<html><font color='blue'>Introduce el límite superior de integración:</font></html>");
        double limiteSuperior = Double.parseDouble(limiteSuperiorInput);

        // Crear un objeto de la clase CalculadoraIntegral
        CalculadoraIntegral calculadora = new CalculadoraIntegral();

        // Calcular la integral
        double resultado = calculadora.calcularIntegral(funcion, limiteInferior, limiteSuperior);

        // Mostrar el resultado
        mostrarMensajeResultado("<html><font color='green'>El resultado de la derivada de la integral es: " + resultado
                + "</font></html>");
    }

    private static void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, "<html><font color='red'>" + mensaje + "</font></html>", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private static void mostrarMensajeResultado(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}
