class Tortuga {
    private int x;
    private int y;
    private boolean boligrafoAbajo;
    private int[][] piso; // Piso de dibujo bidimensional

    // Constructor de la clase Tortuga
    public Tortuga() {
        // Inicialización de variables
        this.x = 0;
        this.y = 0;
        this.boligrafoAbajo = true;
        this.piso = new int[20][20]; // Piso de dibujo bidimensional de 20x20
    }

    // Método para avanzar hacia adelante en el eje x
    public void avanzar(int pasos) {
        if (boligrafoAbajo) {
            // Marcar la posición actual en el piso si el bolígrafo está abajo
            piso[x][y] = 1;
        }

        // Actualizar la posición de la tortuga en el eje x
        for (int i = 0; i < pasos; i++) {
            if (x < 19) {
                x++;
            }
        }
    }

    // Método para retroceder hacia atrás en el eje x
    public void retroceder(int pasos) {
        // Actualizar la posición de la tortuga en el eje x
        for (int i = 0; i < pasos; i++) {
            if (x > 0) {
                x--;
            }
        }
    }

    // Métodos para girar la tortuga
    public void girarIzquierda() {
        // Decrementar la coordenada 'y' para girar hacia la izquierda
        if (y > 0) {
            y--;
        }
    }

    public void girarDerecha() {
        // Incrementar la coordenada 'y' para girar hacia la derecha
        if (y < 19) {
            y++;
        }
    }

    // Método para bajar el bolígrafo
    public void bajarBoligrafo() {
        boligrafoAbajo = true;
    }

    // Método para subir el bolígrafo
    public void subirBoligrafo() {
        boligrafoAbajo = false;
    }

    // Métodos para obtener el piso de dibujo y la posición actual de la tortuga
    public int[][] getPiso() {
        return piso;
    }

    public int[] getPosicion() {
        int[] posicion = { x, y };
        return posicion;
    }
}
