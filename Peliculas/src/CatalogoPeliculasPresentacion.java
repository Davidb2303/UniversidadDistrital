import javax.swing.*;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        while (true) {
            InicioDialog dialogoInicio = new InicioDialog();
            dialogoInicio.setVisible(true);

            if ("usu1234".equals(dialogoInicio.getClave())) {
                VistaPeliculas vista = new VistaPeliculas();

                ICatalogoPeliculas catalogo = new CatalogoDePeliculasImpl();
                ControladorPeliculas controlador = new ControladorPeliculas(vista, catalogo);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Clave incorrecta");
            }
        }
    }
}
