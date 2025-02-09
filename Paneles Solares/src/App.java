import Controlador.Controlador;
import Modelo.Modelo;
import Vista.InterfazGrafica;

public class App {
    public static void main(String[] args) {
        InterfazGrafica vista = new InterfazGrafica();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);
    }
}
