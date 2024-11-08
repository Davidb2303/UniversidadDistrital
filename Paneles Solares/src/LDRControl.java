// Clase para controlar los sensores LDR
class LDRControl {
    private GpioPinAnalogInput ldrPin; // Pin analógico para el sensor LDR

    public LDRControl(GpioController gpio, Pin pin) {
        ldrPin = gpio.provisionAnalogInputPin(pin); // Inicializamos el pin del LDR
    }

    public void setup() {
        // No se necesita configuración adicional para el LDR en este caso
    }

    public int getValue() {
        return (int) (ldrPin.getValue() * 100); // Devuelve el valor leído del LDR (en porcentaje)
    }
}
