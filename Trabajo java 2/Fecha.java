class Fecha {
    private int mes;
    private int dia;
    private int año;

    public Fecha(int mes, int dia, int año) {
        this.mes = mes;
        this.dia = dia;
        this.año = año;
    }

    public void establecerMes(int mes) {
        this.mes = mes;
    }

    public int obtenerMes() {
        return this.mes;
    }

    public void establecerDia(int dia) {
        this.dia = dia;
    }

    public int obtenerDia() {
        return this.dia;
    }

    public void establecerAño(int año) {
        this.año = año;
    }

    public int obtenerAño() {
        return this.año;
    }

    public void mostrarFecha() {
        System.out.println(this.mes + "/" + this.dia + "/" + this.año);
    }
}

