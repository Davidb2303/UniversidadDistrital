import tkinter as tk
from tkinter import ttk
import RPi.GPIO as GPIO
import time
from threading import Thread

class ServoController:
    def __init__(self, pin, limit_high, limit_low, current_angle=7.5):
        """
        Inicializa un controlador de servo.

        Args:
            pin (int): Número del pin GPIO al que está conectado el servo.
            limit_high (float): Valor máximo del ciclo de trabajo del PWM para el servo.
            limit_low (float): Valor mínimo del ciclo de trabajo del PWM para el servo.
            current_angle (float, optional): Ángulo inicial del servo. Por defecto es 7.5 (posición media).
        """
        self.pin = pin
        self.limit_high = limit_high
        self.limit_low = limit_low
        self.current_angle = current_angle

        GPIO.setup(self.pin, GPIO.OUT)  # Configura el pin como salida
        self.pwm = GPIO.PWM(self.pin, 50)  # Inicia un objeto PWM con una frecuencia de 50 Hz
        self.pwm.start(self.current_angle)  # Inicia el PWM en la posición inicial

    def update_angle(self, increment):
        """
        Actualiza el ángulo del servo.

        Args:
            increment (float): Incremento para el ángulo del servo.
        """
        new_angle = self.current_angle + increment
        if self.limit_low <= new_angle <= self.limit_high:
            self.current_angle = new_angle
            self.pwm.ChangeDutyCycle(self.current_angle)

    def stop(self):
        """Detiene el PWM del servo."""
        self.pwm.stop()

class LDRSensor:
    def __init__(self, pin):
        """
        Inicializa un sensor LDR.

        Args:
            pin (int): Número del pin GPIO al que está conectado el sensor.
        """
        self.pin = pin
        GPIO.setup(self.pin, GPIO.IN)  # Configura el pin como entrada

    def read_value(self):
        """Lee y retorna el valor del sensor LDR."""
        return GPIO.input(self.pin)

class SolarTracker:
    def __init__(self):
        """Inicializa el rastreador solar."""
        GPIO.setmode(GPIO.BCM)

        self.servo_hori = ServoController(18, 12.0, 2.5)  # Crea un controlador de servo horizontal
        self.servo_verti = ServoController(17, 12.0, 2.5)  # Crea un controlador de servo vertical

        # Crea sensores LDR para cada posición
        self.ldrs = {
            'top_left': LDRSensor(2),
            'top_right': LDRSensor(3),
            'bottom_left': LDRSensor(4),
            'bottom_right': LDRSensor(5)
        }

        time.sleep(0.5)  # Pequeña pausa para asegurarse de que todo esté listo
        self.running = False  # Indicador para controlar el bucle de ejecución

    def read_ldr_values(self):
        """Lee y retorna los valores de los sensores LDR."""
        return {key: sensor.read_value() for key, sensor in self.ldrs.items()}

    def calculate_averages(self, values):
        """
        Calcula los promedios de los valores de los sensores LDR.

        Args:
            values (dict): Diccionario con los valores de los sensores LDR.

        Returns:
            float: Promedio de los sensores LDR superiores.
            float: Promedio de los sensores LDR inferiores.
            float: Promedio de los sensores LDR izquierdos.
            float: Promedio de los sensores LDR derechos.
        """
        avgtop = (values['top_left'] + values['top_right']) / 2
        avgbot = (values['bottom_left'] + values['bottom_right']) / 2
        avgleft = (values['top_left'] + values['bottom_left']) / 2
        avgright = (values['top_right'] + values['bottom_right']) / 2
        return avgtop, avgbot, avgleft, avgright

    def adjust_servos(self, avgtop, avgbot, avgleft, avgright):
        """
        Ajusta los servos basado en los promedios de los valores de los sensores LDR.

        Args:
            avgtop (float): Promedio de los sensores LDR superiores.
            avgbot (float): Promedio de los sensores LDR inferiores.
            avgleft (float): Promedio de los sensores LDR izquierdos.
            avgright (float): Promedio de los sensores LDR derechos.
        """
        if avgtop < avgbot:
            self.servo_verti.update_angle(0.1)  # Incrementa el ángulo
        elif avgbot < avgtop:
            self.servo_verti.update_angle(-0.1)  # Decrementa el ángulo

        if avgleft > avgright:
            self.servo_hori.update_angle(0.1)  # Incrementa el ángulo
        elif avgright > avgleft:
            self.servo_hori.update_angle(-0.1)  # Decrementa el ángulo

    def run(self):
        """Ejecuta el rastreador solar."""
        self.running = True
        while self.running:
            values = self.read_ldr_values()
            avgtop, avgbot, avgleft, avgright = self.calculate_averages(values)
            self.adjust_servos(avgtop, avgbot, avgleft, avgright)
            time.sleep(0.05)

    def stop(self):
        """Detiene el rastreador solar."""
        self.running = False
        self.servo_hori.stop()
        self.servo_verti.stop()
        GPIO.cleanup()

class SolarTrackerGUI(tk.Tk):
    def __init__(self, tracker):
        """Inicializa la interfaz gráfica del rastreador solar."""
        super().__init__()
        self.tracker = tracker  # Guarda la referencia al objeto rastreador solar
        self.title("Solar Tracker")  # Título de la ventana
        self.geometry("400x300")  # Dimensiones de la ventana

        # Botón para iniciar el rastreo solar
        self.start_button = ttk.Button(self, text="Start", command=self.start_tracking)
        self.start_button.pack(pady=10)  # Agrega el botón a la ventana con un margen superior/inferior de 10

        # Botón para detener el rastreo solar
        self.stop_button = ttk.Button(self, text="Stop", command=self.stop_tracking)
        self.stop_button.pack(pady=10)  # Agrega el botón a la ventana con un margen superior/inferior de 10

        # Etiqueta para mostrar el estado del rastreo
        # Etiqueta para mostrar el estado del rastreo
        self.status_label = ttk.Label(self, text="Status: Stopped")
        self.status_label.pack(pady=10)  # Agrega la etiqueta a la ventana con un margen superior/inferior de 10

        # Variables para mostrar los valores de los sensores LDR
        self.sensor_values = {
            'top_left': tk.StringVar(value="Top Left: 0"),
            'top_right': tk.StringVar(value="Top Right: 0"),
            'bottom_left': tk.StringVar(value="Bottom Left: 0"),
            'bottom_right': tk.StringVar(value="Bottom Right: 0")
        }

        # Crea y agrega etiquetas para mostrar los valores de los sensores LDR
        for key, var in self.sensor_values.items():
            label = ttk.Label(self, textvariable=var)
            label.pack()

        self.update_thread = None  # Hilo para actualizar el estado de los sensores

    def start_tracking(self):
        """Inicia el rastreo solar."""
        if self.update_thread is None or not self.update_thread.is_alive():
            self.tracker_thread = Thread(target=self.tracker.run)  # Crea un hilo para ejecutar el rastreador solar
            self.tracker_thread.start()
            self.status_label.config(text="Status: Running")  # Actualiza el estado a "Running"
            self.update_thread = Thread(target=self.update_status)  # Crea un hilo para actualizar el estado de los sensores
            self.update_thread.start()

    def stop_tracking(self):
        """Detiene el rastreo solar."""
        self.tracker.stop()  # Detiene el rastreador solar
        if self.update_thread and self.update_thread.is_alive():
            self.update_thread.join()  # Espera a que el hilo de actualización termine
        self.status_label.config(text="Status: Stopped")  # Actualiza el estado a "Stopped"

    def update_status(self):
        """Actualiza el estado de los sensores LDR en la interfaz gráfica."""
        while self.tracker.running:
            values = self.tracker.read_ldr_values()  # Lee los valores de los sensores LDR
            for key, value in values.items():
                self.sensor_values[key].set(f"{key.replace('_', ' ').title()}: {value}")  # Actualiza los valores en la interfaz gráfica
            time.sleep(1)  # Pausa de 1 segundo antes de la próxima actualización

if __name__ == "__main__":
    tracker = SolarTracker()  # Crea una instancia del rastreador solar
    app = SolarTrackerGUI(tracker)  # Crea una instancia de la interfaz gráfica
    app.mainloop()  # Inicia el bucle principal de la interfaz gráfica
