public class Main {
    public static void main(String[] args) {
        VentasMesPasado ventasMesPasado = new VentasMesPasado();
        Vista vista = new Vista(ventasMesPasado);
        vista.ejecutar();
    }
}