import numpy as np
import matplotlib.pyplot as plt

# Datos
angulos = [19, 14, 11]  # Ángulos en grados
alcance = [7.99, 26.04, 14.38]  # Alcance en metros

# Ajustar una función polinomial de grado 2 (puedes cambiar el grado si lo deseas)
coefficients = np.polyfit(angulos, alcance, 2)
polynomial = np.poly1d(coefficients)

# Crear un rango de valores para los ángulos
x_values = np.linspace(min(angulos), max(angulos), 100)

# Evaluar la función polinomial en el rango de valores de ángulos
y_values = polynomial(x_values)

# Graficar
plt.figure(figsize=(8, 6))
plt.plot(angulos, alcance, marker='o', linestyle='', color='b', label='Datos')
plt.plot(x_values, y_values, linestyle='-', color='r', label='Curva de tendencia')
plt.title('Gráfico de Alcance vs Ángulo con Curva de Tendencia')
plt.xlabel('Ángulo (grados)')
plt.ylabel('Alcance (metros)')
plt.grid(True)
plt.legend()
plt.show()
