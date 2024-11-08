
// Clase para representar un intervalo de integración
class IntervalosIntegral {
    private double limiteInferior;
    private double limiteSuperior;

    public double getLimiteSuperior() {
        return limiteSuperior;
    }

    // Constructor
    public void Intervalo(double limiteInferior, double limiteSuperior) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    // Métodos para obtener los límites del intervalo
    public double getLimiteInferior() {
        return limiteInferior;
    }
    
    public void setLimiteSuperior(double limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public void setLimiteInferior(double limiteInferior) {
        this.limiteInferior = limiteInferior;
    }
}
