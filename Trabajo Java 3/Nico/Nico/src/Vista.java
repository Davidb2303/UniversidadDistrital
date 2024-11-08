import javax.swing.JOptionPane;

class Vista {
    private VentasMesPasado modelo;

    public Vista(VentasMesPasado modelo) {
        this.modelo = modelo;
    }

    public void ejecutar() {
        JOptionPane.showMessageDialog(null, "Ingrese las ventas del mes pasado para cada vendedor y producto.\n" +
                "Formato: Vendedor Producto Valor (-1 para terminar)");

        while (true) {
            int vendedor = Integer.parseInt(JOptionPane.showInputDialog("Número del vendedor (-1 para terminar):"));
            if (vendedor == -1)
                break; // Salir si se ingresa -1

            int producto = Integer.parseInt(JOptionPane.showInputDialog("Número del producto:"));
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor total en dólares:"));

            modelo.agregarVenta(vendedor, producto, valor);
        }

        mostrarResultados();
    }

    private void mostrarResultados() {
        StringBuilder tabla = new StringBuilder();
        tabla.append("Ventas totales del mes pasado:\n");
        tabla.append("=====================================\n");
        tabla.append("Producto\tVendedor 1\tVendedor 2\tVendedor 3\tVendedor 4\tTotal\n");
        tabla.append("=====================================\n");

        double[][] ventas = modelo.obtenerVentas();
        double totalMes = 0;

        for (int i = 0; i < ventas.length; i++) {
            double totalProducto = 0;
            tabla.append((i + 1)).append("\t\t");

            for (int j = 0; j < ventas[i].length; j++) {
                tabla.append(ventas[i][j]).append("\t\t");
                totalProducto += ventas[i][j];
            }

            tabla.append(totalProducto).append("\n");
            totalMes += totalProducto;
        }

        tabla.append("=====================================\n");
        tabla.append("Total\t\t");
        for (int j = 0; j < ventas[0].length; j++) {
            double totalVendedor = 0;
            for (int i = 0; i < ventas.length; i++) {
                totalVendedor += ventas[i][j];
            }
            tabla.append(totalVendedor).append("\t\t");
        }

        tabla.append("\nTotal del mes: ").append(totalMes);

        JOptionPane.showMessageDialog(null, tabla.toString());
    }
}