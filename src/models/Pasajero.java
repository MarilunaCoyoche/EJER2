package models;

/**
 * Clase que representa los datos de un pasajero.
 * Almacena toda la información relevante para la compra de un pasaje.
 */
public class Pasajero {
    private String nombre;
    private String documento;
    private String fechaViaje;
    private String origen;
    private String destino;
    private String tipoServicio;
    private int numeroPiso;
    private boolean usaAudifonos;
    private boolean pideManta;
    private boolean quiereRevistas;

    // Constructor
    public Pasajero() {
        // Inicialización de valores por defecto si es necesario
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getFechaViaje() { return fechaViaje; }
    public void setFechaViaje(String fechaViaje) { this.fechaViaje = fechaViaje; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }

    public int getNumeroPiso() { return numeroPiso; }
    public void setNumeroPiso(int numeroPiso) { this.numeroPiso = numeroPiso; }

    public boolean isUsaAudifonos() { return usaAudifonos; }
    public void setUsaAudifonos(boolean usaAudifonos) { this.usaAudifonos = usaAudifonos; }

    public boolean isPideManta() { return pideManta; }
    public void setPideManta(boolean pideManta) { this.pideManta = pideManta; }

    public boolean isQuiereRevistas() { return quiereRevistas; }
    public void setQuiereRevistas(boolean quiereRevistas) { this.quiereRevistas = quiereRevistas; }

    /**
     * Genera un resumen de los datos del pasajero.
     * @return String con el resumen formateado.
     */
    public String generarResumen() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("Resumen de la compra:\n\n");
        resumen.append("Nombre: ").append(nombre).append("\n");
        resumen.append("Documento: ").append(documento).append("\n");
        resumen.append("Fecha de viaje: ").append(fechaViaje).append("\n");
        resumen.append("Ruta: ").append(origen).append(" -> ").append(destino).append("\n");
        resumen.append("Servicio: ").append(tipoServicio).append("\n");
        resumen.append("Piso: ").append(numeroPiso).append("\n");
        resumen.append("\nServicios adicionales:\n");
        resumen.append("- Audífonos: ").append(usaAudifonos ? "Sí" : "No").append("\n");
        resumen.append("- Manta: ").append(pideManta ? "Sí" : "No").append("\n");
        resumen.append("- Revistas: ").append(quiereRevistas ? "Sí" : "No").append("\n");
        return resumen.toString();
    }
}