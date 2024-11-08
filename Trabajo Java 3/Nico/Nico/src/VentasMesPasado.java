class VentasMesPasado {
    private double[][] ventas;

    public VentasMesPasado() {
        ventas = new double[5][4]; // 5 productos y 4 vendedores
    }

    public void agregarVenta(int vendedor, int producto, double valor) {
        ventas[producto - 1][vendedor - 1] += valor;
    }

    public double[][] obtenerVentas() {
        return ventas;
    }
}