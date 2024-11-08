public class MultiplicaciónDeMatrices {

    public static void main(String[] args) {

        int matriz1[][] = new int[2][3];
        int matriz2[][] = new int[3][2];
        int matrizResultante[][] = new int[2][2];

        //llenado de matriz1
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                matriz1[i][j] = (int) (Math.random() * 5);
            }
        }

        //llenado de matriz2
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                matriz2[i][j] = (int) (Math.random() * 5);
            }
        }

        //Multiplicación de matrices
        for (int i = 0; i < 2; i++) {
            
            for (int j = 0; j < 2; j++) {
                int valorAcumulado = 0;
                for (int k = 0; k < 3; k++) {
                    
                    valorAcumulado += matriz1[i][k] * matriz2[k][j];

                    if (k == 2) {
                        matrizResultante[i][j] = valorAcumulado;
                    }
                }
            }
        }

        //impresion en pantalla
        for (int i = 0; i < 3; i++) {

            if (i < 2) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("[" + matriz1[i][j] + "]");
                }

                //****************************
                if (i == 0) {
                    System.out.print("   x   ");
                } else {
                    System.out.print("       ");
                }
                //****************************

                for (int j = 0; j < 2; j++) {
                    System.out.print("[" + matriz2[i][j] + "]");
                }

                //***************************
                if (i == 0) {
                    System.out.print("   =   ");
                } else {
                    System.out.print("       ");
                }
                //****************************

                for (int j = 0; j < 2; j++) {
                    System.out.print("[" + matrizResultante[i][j] + "]");
                }
                System.out.println("");
            } else {
                
                System.out.print("                ");
                
                for (int j = 0; j < 2; j++) {
                    System.out.print("["+matriz2[i][j]+"]");
                }
                System.out.println("");
            }
          

        }
    }
}