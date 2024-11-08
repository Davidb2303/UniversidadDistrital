import java.util.ArrayList;
import java.util.List;

class FactorizacionPrima {
    public static List<Factor> factorizar(int n) {
        List<Factor> factores = new ArrayList<>();
        for (int i = 2; i <= n / i; i++) {
            int exponente = 0;
            while (n % i == 0) {
                n /= i;
                exponente++;
            }
            if (exponente > 0) {
                factores.add(new Factor(i, exponente));
            }
        }
        if (n > 1) {
            factores.add(new Factor(n, 1));
        }
        return factores;
    }
}
