import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Se inicializa el piso
        Piso piso = new Piso(20, 20);

        // Se crean los comandos para la tortuga
        ArrayList<String> comandos = new ArrayList<>();
        comandos.add("ABAJO");
        comandos.add("AVANZA");
        comandos.add("AVANZA");
        comandos.add("DERECHA");
        comandos.add("AVANZA");
        comandos.add("ARRIBA");
        comandos.add("AVANZA");
        comandos.add("ABAJO");
        comandos.add("AVANZA");

        // Se crea una instancia de la tortuga con el piso
        Tortuga tortuga = new Tortuga(piso);

        // Se ejecutan los comandos de la tortuga
        for (String comando : comandos) {
            tortuga.ejecutarComando(comando);
        }

        // Se imprime el piso con las figuras trazadas por la tortuga
        piso.mostrarPiso();
    }
}