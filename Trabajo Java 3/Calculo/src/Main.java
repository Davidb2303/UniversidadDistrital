import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Solicitar la función al usuario
        String funcionInput = JOptionPane.showInputDialog(null, "Ingrese la función (utilice 'x' como variable):");

        // Solicitar los límites de integración al usuario
        double limiteInferior = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el límite inferior:"));
        double limiteSuperior = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el límite superior:"));

        // Crear la función a partir de la entrada del usuario
        UnivariateFunction funcion = x -> evaluateFuncion(funcionInput, x);

        // Calcular la integral utilizando el método de Simpson
        SimpsonIntegrator integrator = new SimpsonIntegrator();
        double resultado = integrator.integrate(1000, funcion, limiteInferior, limiteSuperior);

        // Mostrar el resultado utilizando JOptionPane
        JOptionPane.showMessageDialog(null, "El resultado de la integral es: " + resultado);
    }

    // Método para evaluar la función ingresada por el usuario
    private static double evaluateFuncion(String funcionInput, double x) {
        try {
            return Double.parseDouble(funcionInput.replace("x", String.valueOf(x)));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Función inválida. Asegúrese de usar el formato correcto.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            return 0; // Nunca se llega aquí, pero necesario para compilar
        }
    }
}
