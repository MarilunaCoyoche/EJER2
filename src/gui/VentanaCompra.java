package gui;

import models.Pasajero;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal para la compra de pasajes.
 * Contiene todos los componentes de la interfaz gráfica.
 */
public class VentanaCompra extends JFrame {
    
    // Declaración de componentes de la interfaz
    private JTextField txtNombre;
    private JTextField txtDocumento;
    private JTextField txtFecha;
    private JComboBox<String> cboOrigen;
    private JComboBox<String> cboDestino;
    private JComboBox<String> cboServicio;
    private JRadioButton rbtnPiso1;
    private JRadioButton rbtnPiso2;
    private JCheckBox chkAudifonos;
    private JCheckBox chkManta;
    private JCheckBox chkRevistas;
    private JButton btnProcesar;
    private JButton btnLimpiar;

    // Modelo que almacena la información del pasajero
    private Pasajero pasajero;

    /**
     * Constructor de la ventana.
     * Inicializa y configura todos los componentes.
     */
    public VentanaCompra() {
        // Configuración básica de la ventana
        setTitle("Compra de Pasajes - Sistema de Transporte");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridBagLayout());

        // Inicialización del modelo
        pasajero = new Pasajero();

        // Inicializar componentes
        inicializarComponentes();

        // Configurar eventos
        configurarEventos();

        // Centrar ventana en la pantalla
        setLocationRelativeTo(null);
    }

    /**
     * Inicializa todos los componentes de la interfaz.
     */
    private void inicializarComponentes() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Etiquetas y campos de texto
        agregarComponente(new JLabel("Nombre:"), gbc, 0, 0);
        txtNombre = new JTextField(20);
        agregarComponente(txtNombre, gbc, 1, 0);

        agregarComponente(new JLabel("Documento:"), gbc, 0, 1);
        txtDocumento = new JTextField(20);
        agregarComponente(txtDocumento, gbc, 1, 1);

        agregarComponente(new JLabel("Fecha de viaje:"), gbc, 0, 2);
        txtFecha = new JTextField(20);
        agregarComponente(txtFecha, gbc, 1, 2);

        // Combos de origen y destino
        String[] ciudades = {"Lima", "Arequipa", "Cusco", "Trujillo", "Chiclayo"};
        agregarComponente(new JLabel("Origen:"), gbc, 0, 3);
        cboOrigen = new JComboBox<>(ciudades);
        agregarComponente(cboOrigen, gbc, 1, 3);

        agregarComponente(new JLabel("Destino:"), gbc, 0, 4);
        cboDestino = new JComboBox<>(ciudades);
        agregarComponente(cboDestino, gbc, 1, 4);

        // Tipo de servicio
        agregarComponente(new JLabel("Servicio:"), gbc, 0, 5);
        String[] servicios = {"Económico", "Standard", "VIP"};
        cboServicio = new JComboBox<>(servicios);
        agregarComponente(cboServicio, gbc, 1, 5);

        // Radio buttons para pisos
        JPanel panelPisos = new JPanel();
        rbtnPiso1 = new JRadioButton("1er Piso");
        rbtnPiso2 = new JRadioButton("2do Piso");
        
        ButtonGroup grupoPisos = new ButtonGroup();
        grupoPisos.add(rbtnPiso1);
        grupoPisos.add(rbtnPiso2);
        
        panelPisos.add(rbtnPiso1);
        panelPisos.add(rbtnPiso2);
        
        agregarComponente(new JLabel("Piso:"), gbc, 0, 6);
        agregarComponente(panelPisos, gbc, 1, 6);

        // Checkboxes para servicios adicionales
        JPanel panelServicios = new JPanel();
        
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        
        panelServicios.add(chkAudifonos);
        panelServicios.add(chkManta);
        panelServicios.add(chkRevistas);
        
        agregarComponente(new JLabel("Servicios adicionales:"), gbc, 0, 7);
        agregarComponente(panelServicios, gbc, 1, 7);

       // Botones para procesar y limpiar
       JPanel panelBotones = new JPanel();
       btnProcesar = new JButton("Procesar Compra");
       btnLimpiar = new JButton("Limpiar");
       
       panelBotones.add(btnProcesar);
       panelBotones.add(btnLimpiar);
       
       gbc.gridwidth = 2;
       agregarComponente(panelBotones, gbc, 0, 8);
   }

   /**
     * Configura los eventos para todos los componentes interactivos.
     */
   private void configurarEventos() {
       btnProcesar.addActionListener(e -> procesarCompra());
       btnLimpiar.addActionListener(e -> limpiarFormulario());
   }

   /**
     * Procesa los datos del formulario y muestra el resumen.
     */
   private void procesarCompra() {
       try {
           // Validar campos obligatorios
           if (txtNombre.getText().trim().isEmpty() || 
               txtDocumento.getText().trim().isEmpty() || 
               txtFecha.getText().trim().isEmpty()) {
               JOptionPane.showMessageDialog(this,
                   "Por favor complete todos los campos obligatorios",
                   "Error",
                   JOptionPane.ERROR_MESSAGE);
               return;
           }

           // Actualizar modelo con datos del formulario
           pasajero.setNombre(txtNombre.getText());
           pasajero.setDocumento(txtDocumento.getText());
           pasajero.setFechaViaje(txtFecha.getText());
           pasajero.setOrigen(cboOrigen.getSelectedItem().toString());
           pasajero.setDestino(cboDestino.getSelectedItem().toString());
           pasajero.setTipoServicio(cboServicio.getSelectedItem().toString());
           pasajero.setNumeroPiso(rbtnPiso1.isSelected() ? 1 : (rbtnPiso2.isSelected() ? 2 : -1));
           pasajero.setUsaAudifonos(chkAudifonos.isSelected());
           pasajero.setPideManta(chkManta.isSelected());
           pasajero.setQuiereRevistas(chkRevistas.isSelected());

           // Mostrar resumen en diálogo
           JOptionPane.showMessageDialog(this,
               pasajero.generarResumen(),
               "Resumen de Compra",
               JOptionPane.INFORMATION_MESSAGE);
       } catch (Exception e) {
           e.printStackTrace(); // Imprimir la traza de la excepción en caso de error
           JOptionPane.showMessageDialog(this,
               "Ocurrió un error al procesar la compra.",
               "Error",
               JOptionPane.ERROR_MESSAGE);
       }
   }

   /**
     * Limpia todos los campos del formulario.
     */
   private void limpiarFormulario() {
       txtNombre.setText("");
       txtDocumento.setText("");
       txtFecha.setText("");
       cboOrigen.setSelectedIndex(0);
       cboDestino.setSelectedIndex(0);
       cboServicio.setSelectedIndex(0);
       rbtnPiso1.setSelected(true); // Por defecto seleccionamos el primer piso
       chkAudifonos.setSelected(false);
       chkManta.setSelected(false);
       chkRevistas.setSelected(false);
   }

   /**
     * Método auxiliar para agregar componentes al layout.
     */
   private void agregarComponente(Component comp, GridBagConstraints gbc, int x, int y) {
       gbc.gridx = x;
       gbc.gridy = y;
       add(comp, gbc); // Agregar componente al layout con las restricciones especificadas
   }
}