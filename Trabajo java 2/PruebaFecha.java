public class PruebaFecha {
    public static void main(String[] args) {
        // Crear un objeto Fecha
        Fecha fecha1 = new Fecha(2, 25, 2024);

        // Obtener y mostrar los valores de la fecha
        System.out.println("Fecha:");
        System.out.println("Mes: " + fecha1.obtenerMes());
        System.out.println("Día: " + fecha1.obtenerDia());
        System.out.println("Año: " + fecha1.obtenerAño());
        System.out.print("Fecha completa: ");
        fecha1.mostrarFecha();

        // Establecer nuevos valores para la fecha
        fecha1.establecerMes(12);
        fecha1.establecerDia(31);
        fecha1.establecerAño(2025);

        // Obtener y mostrar los nuevos valores de la fecha
        System.out.println("\nNuevos valores de la fecha:");
        System.out.println("Mes: " + fecha1.obtenerMes());
        System.out.println("Día: " + fecha1.obtenerDia());
        System.out.println("Año: " + fecha1.obtenerAño());
        System.out.print("Fecha completa: ");
        fecha1.mostrarFecha();
    }
}
