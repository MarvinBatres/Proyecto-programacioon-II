package com.mycompany.proyecto_firebase;
import com.mycompany.proyecto_firebase.Producto;


public class AsistenteCasa extends Producto {

    private String tipoDispositivo;       
    private String protocoloComunicacion;  
    private String compatibilidadAsistente;
    private boolean tienePantalla;        
    private String entradasSalidas;        
    private boolean esInalambrico;       
    private String rangoConexion;          
    private boolean requiereHub;           

   
    public AsistenteCasa(int Id, String nombre, Double precio, int stock, 
                        String marca, String modelo, double garantia,
                        String tipoDispositivo, String protocoloComunicacion, 
                        String compatibilidadAsistente, boolean tienePantalla, 
                        String entradasSalidas, boolean esInalambrico,
                        String rangoConexion, boolean requiereHub) {
        
    
        super(Id, nombre, precio, stock, marca, modelo, garantia);
        
        this.tipoDispositivo = tipoDispositivo;
        this.protocoloComunicacion = protocoloComunicacion;
        this.compatibilidadAsistente = compatibilidadAsistente;
        this.tienePantalla = tienePantalla;
        this.entradasSalidas = entradasSalidas;
        this.esInalambrico = esInalambrico;
        this.rangoConexion = rangoConexion;
        this.requiereHub = requiereHub;
    }

    
  
    @Override
    public double calcularPercioIVa() {
        double iva = 0.19;  // IVA del 19% para productos electrónicos
        return this.getPrecio() * (1 + iva);
    }
    
   
    @Override
    public String getTipoCategoria() {
        return "Dispositivo Casa Inteligente";
    }

   
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
    
    
    public boolean esFacilInstalacion() {
        return esInalambrico && !requiereHub;
    }
    
   
    public String getNivelEnergia() {
        if (esInalambrico) {
            return "Bajo consumo - Batería/USB";
        } else {
            return "Consumo estándar - Corriente eléctrica";
        }
    }
    
    
    public String getInfoCompleta() {
        return String.format(
            "%s %s - %s | Precio: $%.2f | Stock: %d | Tipo: %s",
            this.getMarca(),       
            this.getModelo(),    
            this.getNombre(),      
            this.getPrecio(),        
            this.getStock(),         
            this.tipoDispositivo      
        );
    }
    
    
    public boolean estaDisponible() {
        return this.getStock() > 0 && this.getPrecio() > 0;
    }

   
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