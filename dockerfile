# Usar una imagen base de Python 3
FROM python:3.9

# Instalar el paquete RPi.GPIO
RUN pip install RPi.GPIO

# Crear un directorio en el contenedor para tu aplicación
WORKDIR /app

# Copiar todo el contenido de tu proyecto al contenedor
COPY . /app

# Comando para ejecutar tu aplicación
CMD ["python", "SolarTrackerPanel.py"]  

