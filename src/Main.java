import javax.swing.SwingUtilities;

import gui.VentanaCompra;

/**
 * Clase principal que inicia la aplicación.
 */
public class Main {
   public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
           VentanaCompra ventana = new VentanaCompra();
           ventana.setVisible(true); // Hacer visible la ventana principal
       });
   }
}