// Clase para representar una función matemática

import java.util.function.DoubleUnaryOperator;

class FuncionMatematica {
    private DoubleUnaryOperator funcion;

    // Constructor
    public FuncionMatematica(DoubleUnaryOperator funcion) {
        this.funcion = funcion;
    }

    public FuncionMatematica() {
    }

    // Método para evaluar la función en un punto dado
    public double evaluar(double x) {
        return funcion.applyAsDouble(x);
    }

    public DoubleUnaryOperator getFuncion() {
        return funcion;
    }

    public void setFuncion(DoubleUnaryOperator funcion) {
        this.funcion = funcion;
    }
}


