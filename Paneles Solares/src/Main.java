public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Creamos una instancia del controlador y lo iniciamos
        @SuppressWarnings("rawtypes")
        Controller controller = new Controller();
        controller.start();
    }
}
