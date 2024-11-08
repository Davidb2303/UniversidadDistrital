// Clase para controlar los servos

import java.util.concurrent.TimeUnit;

class ServoControl {
    private GpioPinPwmOutput servoPin; // Pin PWM para el servo
    private int pwm; // Valor del PWM para el servo

    public <GpioController> ServoControl(GpioController gpio, Pin pin) {
        servoPin = gpio.provisionPwmOutputPin(pin); // Inicializamos el pin del servo
        servoPin.setPwmRange(100); // Establecemos el rango del PWM
    }

    public void setup() {
        servoPin.setPwm(0); // Inicializamos el servo con un ángulo de 0 grados
        try {
            TimeUnit.MILLISECONDS.sleep(500); // Pequeña pausa para la inicialización
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getPwm() {
        return pwm; // Devuelve el valor del PWM actual del servo
    }

    public void setPwm(int pwm) {
        this.pwm = pwm; // Establece el valor del PWM para el servo
        servoPin.setPwm(pwm); // Controla el servo con el nuevo valor del PWM
    }
}
