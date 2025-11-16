package com.mycompany.proyecto_firebase;
import com.mycompany.proyecto_firebase.Producto;

/**
 * CLASE HIJA: AsistenteCasa
 * Hereda de Producto y representa dispositivos de domótica y casa inteligente
 */
public class AsistenteCasa extends Producto {
    // ==================== ATRIBUTOS PROPIOS ====================
    private String tipoDispositivo;        // Ej: "Asistente vocal", "Sensor movimiento", "Foco inteligente"
    private String protocoloComunicacion;  // Ej: "WiFi", "Zigbee", "Bluetooth"
    private String compatibilidadAsistente;// Ej: "Alexa, Google Assistant, Apple HomeKit"
    private boolean tienePantalla;         // Si el dispositivo incluye pantalla
    private String entradasSalidas;        // Conexiones: "Audio 3.5mm", "USB", "HDMI", etc.
    private boolean esInalambrico;         // Si funciona sin cables
    private String rangoConexion;          // Alcance: "Todo el hogar", "Hasta 10m", etc.
    private boolean requiereHub;           // Si necesita un concentrador central

    // ==================== CONSTRUCTOR ====================
    /**
     * CONSTRUCTOR COMPLETO - Inicializa atributos padre e hijos
     * @param Id - ID del producto (padre)
     * @param nombre - Nombre del producto (padre)
     * @param precio - Precio base (padre)
     * @param stock - Cantidad disponible (padre)
     * @param marca - Marca del producto (padre)
     * @param modelo - Modelo específico (padre)
     * @param garantia - Años de garantía (padre)
     * @param tipoDispositivo - Tipo de dispositivo inteligente (hijo)
     * @param protocoloComunicacion - Tecnología de conexión (hijo)
     * @param compatibilidadAsistente - Asistentes compatibles (hijo)
     * @param tienePantalla - Si tiene pantalla (hijo)
     * @param entradasSalidas - Conexiones físicas (hijo)
     * @param esInalambrico - Si es wireless (hijo)
     * @param rangoConexion - Alcance de conexión (hijo)
     * @param requiereHub - Si necesita hub (hijo)
     */
    public AsistenteCasa(int Id, String nombre, Double precio, int stock, 
                        String marca, String modelo, double garantia,
                        String tipoDispositivo, String protocoloComunicacion, 
                        String compatibilidadAsistente, boolean tienePantalla, 
                        String entradasSalidas, boolean esInalambrico,
                        String rangoConexion, boolean requiereHub) {
        
        // ✅ super() - Llama al constructor de la clase Padre (Producto)
        // Inicializa todos los atributos heredados: Id, nombre, precio, stock, marca, modelo, garantia
        super(Id, nombre, precio, stock, marca, modelo, garantia);
        
        // ✅ Inicializa atributos propios de la clase hija
        this.tipoDispositivo = tipoDispositivo;
        this.protocoloComunicacion = protocoloComunicacion;
        this.compatibilidadAsistente = compatibilidadAsistente;
        this.tienePantalla = tienePantalla;
        this.entradasSalidas = entradasSalidas;
        this.esInalambrico = esInalambrico;
        this.rangoConexion = rangoConexion;
        this.requiereHub = requiereHub;
    }

    
    // ==================== MÉTODOS ABSTRACTOS OBLIGATORIOS ====================
    /**
     * MÉTODO ABSTRACTO HEREDADO - Calcula el precio con IVA
     * @return double - Precio con IVA incluido (19% para electrónicos)
     */
    @Override
    public double calcularPercioIVa() {
        double iva = 0.19;  // IVA del 19% para productos electrónicos
        return this.getPrecio() * (1 + iva);
    }
    
    /**
     * MÉTODO ABSTRACTO HEREDADO - Define la categoría del producto
     * @return String - Categoría específica para este tipo de producto
     */
    @Override
    public String getTipoCategoria() {
        return "Dispositivo Casa Inteligente";
    }

    // ==================== MÉTODOS ESPECÍFICOS DE LA CLASE ====================
    /**
     * Determina el uso principal según el tipo de dispositivo
     * @return String - Descripción del uso principal
     */
    public String determinarUsoPrincipal() {
        switch(tipoDispositivo.toLowerCase()) {
            case "asistente vocal":
                return "Control por voz y centro de automatización";
            case "sensor movimiento":
                return "Seguridad y automatización de luces";
            case "foco inteligente":
                return "Iluminación automatizada y ambientes";
            case "enchufe inteligente":
                return "Control remoto de electrodomésticos";
            case "termostato":
                return "Control climático y ahorro energético";
            case "cerradura inteligente":
                return "Seguridad y acceso remoto";
            case "cámara seguridad":
                return "Vigilancia y monitoreo remoto";
            case "sensor puerta/ventana":
                return "Seguridad y notificaciones de apertura";
            default:
                return "Dispositivo de automatización del hogar";
        }
    }
    
    /**
     * Genera string con requisitos de instalación
     * @return String - Requisitos concatenados
     */
    public String obtenerRequisitosInstalacion() {
        StringBuilder requisitos = new StringBuilder();
        
        if (requiereHub) {
            requisitos.append("Requiere Hub central • ");
        }
        if (esInalambrico) {
            requisitos.append("Conexión ").append(protocoloComunicacion).append(" • ");
        } else {
            requisitos.append("Conexión cableada • ");
        }
        if (!compatibilidadAsistente.equals("Ninguna")) {
            requisitos.append("Compat: ").append(compatibilidadAsistente);
        }
        
        return requisitos.toString();
    }
    
    /**
     * Verifica si es de fácil instalación para el usuario final
     * @return boolean - True si es fácil de instalar
     */
    public boolean esFacilInstalacion() {
        return esInalambrico && !requiereHub;
    }
    
    /**
     * Determina el nivel de consumo energético
     * @return String - Descripción del consumo
     */
    public String getNivelEnergia() {
        if (esInalambrico) {
            return "Bajo consumo - Batería/USB";
        } else {
            return "Consumo estándar - Corriente eléctrica";
        }
    }
    
    /**
     * MÉTODO COMBINADO - Usa atributos del padre y la hija
     * @return String - Información completa del producto
     */
    public String getInfoCompleta() {
        return String.format(
            "%s %s - %s | Precio: $%.2f | Stock: %d | Tipo: %s",
            this.getMarca(),          // Del padre
            this.getModelo(),         // Del padre  
            this.getNombre(),         // Del padre
            this.getPrecio(),         // Del padre
            this.getStock(),          // Del padre
            this.tipoDispositivo      // De la hija
        );
    }
    
    /**
     * Verifica disponibilidad para venta
     * @return boolean - True si está disponible
     */
    public boolean estaDisponible() {
        return this.getStock() > 0 && this.getPrecio() > 0;
    }

    // ==================== GETTERS Y SETTERS ====================
    /**
     * GETTERS Y SETTERS - Acceso a atributos privados
     * Permiten leer y modificar los valores de los atributos
     */
    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getProtocoloComunicacion() {
        return protocoloComunicacion;
    }

    public void setProtocoloComunicacion(String protocoloComunicacion) {
        this.protocoloComunicacion = protocoloComunicacion;
    }

    public String getCompatibilidadAsistente() {
        return compatibilidadAsistente;
    }

    public void setCompatibilidadAsistente(String compatibilidadAsistente) {
        this.compatibilidadAsistente = compatibilidadAsistente;
    }

    public boolean isTienePantalla() {
        return tienePantalla;
    }

    public void setTienePantalla(boolean tienePantalla) {
        this.tienePantalla = tienePantalla;
    }

    public String getEntradasSalidas() {
        return entradasSalidas;
    }

    public void setEntradasSalidas(String entradasSalidas) {
        this.entradasSalidas = entradasSalidas;
    }

    public boolean isEsInalambrico() {
        return esInalambrico;
    }

    public void setEsInalambrico(boolean esInalambrico) {
        this.esInalambrico = esInalambrico;
    }

    public String getRangoConexion() {
        return rangoConexion;
    }

    public void setRangoConexion(String rangoConexion) {
        this.rangoConexion = rangoConexion;
    }

    public boolean isRequiereHub() {
        return requiereHub;
    }

    public void setRequiereHub(boolean requiereHub) {
        this.requiereHub = requiereHub;
    }

    // ==================== MÉTODO toString ====================
    /**
     * Representación en string del objeto
     * @return String - Información formateada del producto
     */
    @Override
    public String toString() {
        return String.format(
            "CASA INTELIGENTE [ID: %d] %s - %s\n" +
            "Tipo: %s | Uso: %s\n" +
            "Protocolo: %s | Compatible con: %s\n" +
            "Inalámbrico: %s | Rango: %s | Requiere Hub: %s\n" +
            "Pantalla: %s | Conexiones: %s\n" +
            "Precio: $%.2f | IVA: $%.2f | Stock: %d | Garantía: %.1f años\n" +
            "Instalación: %s | Energía: %s | Disponible: %s",
            getId(), getNombre(), getMarca() + " " + getModelo(),
            tipoDispositivo, determinarUsoPrincipal(),
            protocoloComunicacion, compatibilidadAsistente,
            esInalambrico ? "Sí" : "No", rangoConexion, requiereHub ? "Sí" : "No",
            tienePantalla ? "Sí" : "No", entradasSalidas,
            getPrecio(), calcularPercioIVa(), getStock(), getGarantia(),
            esFacilInstalacion() ? "Fácil" : "Intermedia", 
            getNivelEnergia(),
            estaDisponible() ? "Sí" : "No"
        );
    }
}