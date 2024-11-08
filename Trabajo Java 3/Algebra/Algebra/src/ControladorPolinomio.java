public class ControladorPolinomio {
    public ControladorPolinomio(VistaPolinomio vista) {
    }

    public void iniciar() {
        double[] coeficientes = VistaPolinomio.obtenerCoeficientes();
        Polinomio polinomio = new Polinomio(coeficientes);
        double[] raices = polinomio.encontrarRaices();
        VistaPolinomio.mostrarRaices(raices);
    }
}
