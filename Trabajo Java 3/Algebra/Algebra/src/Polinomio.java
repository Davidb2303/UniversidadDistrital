public class Polinomio {
    private double[] coeficientes;

    public Polinomio(double[] coeficientes) {
        this.coeficientes = coeficientes;
    }

    public double[] encontrarRaices() {
        return coeficientes;
        // Implementar algoritmo para encontrar raíces
        // Puedes usar métodos numéricos como el método de Newton-Raphson o el método de
        // la bisección
        // Este método debe devolver un array de raíces
    }
}
