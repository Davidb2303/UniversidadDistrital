import java.util.function.DoubleUnaryOperator;

public class CalculadoraIntegral {

    // Método para calcular la integral numéricamente usando el método de Simpson
    double calcularIntegral(DoubleUnaryOperator funcion, double limiteInferior, double limiteSuperior) {
        SimpsonIntegrator integrator = new SimpsonIntegrator(); // Crear un integrador de Simpson
        return integrator.integrate(1000, funcion, limiteInferior, limiteSuperior); // Integrar la función
    }
}
