public class PruebaFactura {
    public static void main(String[] args) {
        // Crear una instancia de Factura
        Factura factura = new Factura("001", "Martillo", 5, 10.99);

        // Mostrar la información de la factura
        System.out.println("Número de pieza: " + factura.getNumeroPieza());
        System.out.println("Descripción de la pieza: " + factura.getDescripcionPieza());
        System.out.println("Cantidad: " + factura.getCantidad());
        System.out.println("Precio por artículo: " + factura.getPrecio());
        System.out.println("Monto total de la factura: " + factura.obtenerMontoFactura());
    }
}
