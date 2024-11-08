class Piso {
    private int[][] piso;

    public Piso(int filas, int columnas) {
        piso = new int[filas][columnas];
    }

    public void marcarPosicion(int x, int y) {
        piso[x][y] = 1;
    }

    public void mostrarPiso() {
        for (int[] fila : piso) {
            for (int valor : fila) {
                System.out.print(valor == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}