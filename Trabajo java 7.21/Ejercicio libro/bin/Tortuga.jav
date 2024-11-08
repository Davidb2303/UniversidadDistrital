class Tortuga {
    private int x;
    private int y;
    private boolean boligrafoAbajo;
    private Piso piso;

    public Tortuga(Piso piso) {
        this.x = 0;
        this.y = 0;
        this.boligrafoAbajo = false;
        this.piso = piso;
    }

    public void ejecutarComando(String comando) {
        switch (comando) {
            case "AVANZA":
                avanzar();
                break;
            case "DERECHA":
                girarDerecha();
                break;
            case "IZQUIERDA":
                girarIzquierda();
                break;
            case "ABAJO":
                bajarBoligrafo();
                break;
            case "ARRIBA":
                subirBoligrafo();
                break;
        }
    }

    private void avanzar() {
        if (boligrafoAbajo) {
            piso.marcarPosicion(x, y);
        }

        // Lógica para avanzar (actualiza las coordenadas x, y)
        x++;
        if (x >= piso.getFilas()) {
            x = piso.getFilas() - 1;
        }
    }

    private void girarDerecha() {
        // Lógica para girar a la derecha
    }

    private void girarIzquierda() {
        // Lógica para girar a la izquierda
    }

    private void bajarBoligrafo() {
        boligrafoAbajo = true;
    }

    private void subirBoligrafo() {
        boligrafoAbajo = false;
    }
}