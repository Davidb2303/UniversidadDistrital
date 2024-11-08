#include <iostream>

using namespace std;

int main() {
    char op;
    float num1, num2, resultado;

    cout << "Ingrese operador (+, -, *, /): ";
    cin >> op;

    cout << "Ingrese dos numeros: ";
    cin >> num1 >> num2;

    switch(op) {
        case '+':
            resultado = num1 + num2;
            cout << "La suma es: " << resultado << endl;
            break;

        case '-':
            resultado = num1 - num2;
            cout << "La resta es: " << resultado << endl;
            break;

        case '*':
            resultado = num1 * num2;
            cout << "La multiplicacion es: " << resultado << endl;
            break;

        case '/':
            if (num2 != 0) {
                resultado = num1 / num2;
                cout << "La division es: " << resultado << endl;
            } else {
                cout << "Error: No se puede dividir por cero." << endl;
            }
            break;

        default:
            cout << "Operador invalido." << endl;
    }

    return 0;
}

