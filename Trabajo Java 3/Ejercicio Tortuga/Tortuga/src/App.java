import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Tortuga tortuga = new Tortuga(); // Crear una instancia de Tortuga

        Scanner scanner = new Scanner(System.in);

        // Leer los comandos hasta que se ingrese "SALIR"
        while (true) {
            System.out.print("Ingrese un comando (AVANZAR, IZQUIERDA, DERECHA, RETROCEDER, SALIR): ");
            String comando = scanner.nextLine().toUpperCase();

            // Procesar el comando ingresado
            switch (comando) {
                case "AVANZAR":
                    tortuga.avanzar(1);
                    break;
                case "IZQUIERDA":
                    tortuga.girarIzquierda();
                    break;
                case "DERECHA":
                    tortuga.girarDerecha();
                    break;
                case "RETROCEDER":
                    tortuga.retroceder(1);
                    break;
                case "SALIR":
                    guardarEstadoTortuga(tortuga, "estado_tortuga.txt"); // Guardar estado de la tortuga antes de salir
                    System.out.println("Saliendo del programa...");
                    scanner.close(); // Cerrar el scanner
                    System.exit(0); // Salir del programa
            }

            // Imprimir la posición actual de la tortuga después de cada comando
            int[] posicion = tortuga.getPosicion();
            System.out.println("Posición actual de la tortuga: (" + posicion[0] + ", " + posicion[1] + ")");
        }
    }

 