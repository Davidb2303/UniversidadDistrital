// Esta clase se encarga de manejar la lógica principal del programa

import java.util.concurrent.TimeUnit;

class Controller<GpioController> {
    private GpioController gpio;
    private ServoControl servohori; // Control para el servo horizontal
    private ServoControl servoverti; // Control para el servo vertical
    private LDRControl ldrtopl; // Control para el LDR superior izquierdo
    private LDRControl ldrtopr; // Control para el LDR superior derecho
    private LDRControl ldrbotl; // Control para el LDR inferior izquierdo
    private LDRControl ldrbotr; // Control para el LDR inferior derecho

    public Controller() {
        // Inicializamos la instancia de la clase GpioController
        gpio = GpioFactory.getInstance();
        // Creamos instancias para controlar los pines de los servos y los LDRs
        servohori = new ServoControl(gpio, RaspiPin.GPIO_10);
        servoverti = new ServoControl(gpio, RaspiPin.GPIO_9);
        ldrtopl = new LDRControl(gpio, RaspiPin.GPIO_2);
        ldrtopr = new LDRControl(gpio, RaspiPin.GPIO_1);
        ldrbotl = new LDRControl(gpio, RaspiPin.GPIO_3);
        ldrbotr = new LDRControl(gpio, RaspiPin.GPIO_0);
    }

    public void start() throws InterruptedException {
        // Configuramos los pines de los servos y los LDRs
        servohori.setup();
        servoverti.setup();
        ldrtopl.setup();
        ldrtopr.setup();
        ldrbotl.setup();
        ldrbotr.setup();

        // Bucle principal del programa
        while (true) {
            // Obtenemos los valores de los servos
            int servoh = servohori.getPwm();
            int servov = servoverti.getPwm();

            // Obtenemos los valores de los LDRs
            int topl = ldrtopl.getValue();
            int topr = ldrtopr.getValue();
            int botl = ldrbotl.getValue();
            int botr = ldrbotr.getValue();

            // Calculamos los promedios de los valores de los LDRs
            int avgtop = (topl + topr) / 2;
            int avgbot = (botl + botr) / 2;
            int avgleft = (topl + botl) / 2;
            int avgright = (topr + botr) / 2;

            // Control del servo vertical basado en los valores de los LDRs superiores e
            // inferiores
            if (avgtop < avgbot) {
                servoverti.setPwm(servov + 1); // Incrementamos el ángulo del servo vertical
                TimeUnit.MILLISECONDS.sleep(10); // Pequeña pausa
            } else if (avgbot < avgtop) {
                servoverti.setPwm(servov - 1); // Decrementamos el ángulo del servo vertical
                TimeUnit.MILLISECONDS.sleep(10); // Pequeña pausa
            }

            // Control del servo horizontal basado en los valores de los LDRs izquierdos y
            // derechos
            if (avgleft > avgright) {
                servohori.setPwm(servoh + 1); // Incrementamos el ángulo del servo horizontal
                TimeUnit.MILLISECONDS.sleep(10); // Pequeña pausa
            } else if (avgright > avgleft) {
                servohori.setPwm(servoh - 1); // Decrementamos el ángulo del servo horizontal
                TimeUnit.MILLISECONDS.sleep(10); // Pequeña pausa
            }

            TimeUnit.MILLISECONDS.sleep(50); // Pausa antes de la próxima iteración
        }
    }
}
