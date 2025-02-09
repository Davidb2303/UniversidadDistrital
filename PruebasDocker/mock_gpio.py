# mock_gpio.py
from unittest.mock import MagicMock
import sys

# Crear un módulo falso para RPi.GPIO
sys.modules['RPi'] = MagicMock()
sys.modules['RPi.GPIO'] = MagicMock()

# Definir el comportamiento simulado (opcional)
GPIO = sys.modules['RPi.GPIO']
GPIO.setmode = MagicMock()
GPIO.setup = MagicMock()
GPIO.output = MagicMock()
GPIO.cleanup = MagicMock()

print("Simulando RPi.GPIO con MagicMock")

'''#Emular RPi.GPIO en Docker
try:
    import RPi.GPIO as GPIO  # Si estás en una Raspberry Pi, esto debería funcionar
except (ImportError, RuntimeError):
    print("RPi.GPIO no encontrado, utilizando simulación.")
    from mock_gpio import GPIO  # Importa el mock si el módulo real no está disponible

# CodigoNormal 
# Por ejemplo:
GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT)
GPIO.output(18, GPIO.HIGH)
'''

