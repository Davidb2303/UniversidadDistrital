public class App {
    public static void main(String[] args) {
        VistaPolinomio vista = new VistaPolinomio();
        ControladorPolinomio controlador = new ControladorPolinomio(vista);
        controlador.iniciar();
    }
}
