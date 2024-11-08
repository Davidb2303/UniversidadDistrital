class Piso {
    private int[][] piso;
    private int filas;
    private int columnas;

    public Piso(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        piso = new int[filas][columnas];
    }

    public void marcarPosicion(int x, int y) {
        if (x >= 0 && x < filas && y >= 0 && y < columnas) {
            piso[x][y] = 1;
        }
    }

    public void mostrarPiso() {
        for (int[] fila : piso) {
            for (int valor : fila) {
                System.out.print(valor == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }

    public int getFilas() {
        return filas;
    }
}
