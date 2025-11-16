
package com.mycompany.proyecto_firebase;


public class Telefono extends Producto {
    private int almacenamientoGB;      
    private int capacidadRam;          
    private String soOperativo;       
    private String tamanio;           


    public Telefono(int Id, String nombre, Double precio, int stock, 
                   String marca, String modelo, double garantia,
                   int almacenamientoGB, int capacidadRam, 
                   String soOperativo, String tamanio) {
        
        super(Id, nombre, precio, stock, marca, modelo, garantia);
        
        this.almacenamientoGB = almacenamientoGB;
        this.capacidadRam = capacidadRam;
        this.soOperativo = soOperativo;
        this.tamanio = tamanio;
    }

    
    @Override
    public double calcularPercioIVa() {
        double iva = 0.19;  // IVA del 19% para teléfonos
        return this.getPrecio() * (1 + iva);
    }
    
    
    @Override
    public String getTipoCategoria() {
        return "Teléfono Inteligente";
    }

    
    public String getSegmento() {
        if (this.getPrecio() >= 800 && capacidadRam >= 8 && almacenamientoGB >= 128) {
            return "Gama Alta - Premium";
        } else if (this.getPrecio() >= 400 && capacidadRam >= 6 && almacenamientoGB >= 64) {
            return "Gama Media - Balanceado";
        } else {
            return "Gama Baja - Económico";
        }
    }
    
   
    public boolean esCompatibile5G() {
        return this.getPrecio() >= 500 && 
               (soOperativo.equalsIgnoreCase("Android 12+") || 
                soOperativo.equalsIgnoreCase("iOS 15+"));
    }
    
  
    public String getRelacionCalidadPrecio() {
        double relacion = (capacidadRam + almacenamientoGB) / this.getPrecio();
        
        if (relacion > 0.5) {
            return "Excelente - Alta relación calidad-precio";
        } else if (relacion > 0.3) {
            return "Buena - Buena relación calidad-precio";
        } else {
            return "Regular - Relación calidad-precio estándar";
        }
    }
    
   
    public String getEspecificacionesTecnicas() {
        return String.format(
            "Pantalla: %s | RAM: %dGB | Almacenamiento: %dGB | SO: %s",
            tamanio, capacidadRam, almacenamientoGB, soOperativo
        );
    }
    
   
    public boolean esParaGaming() {
        return capacidadRam >= 8 && almacenamientoGB >= 128;
    }
    
    
    public boolean esEmpresarial() {
        return soOperativo.equalsIgnoreCase("iOS") || 
               (soOperativo.toLowerCase().contains("android") && capacidadRam >= 6);
    }

   
    public String getInfoCompletaTelefono() {
        return String.format(
            "%s %s - %s | %s | %s",
            this.getMarca(),
            this.getModelo(),
            this.getNombre(),
            getEspecificacionesTecnicas(),
            getSegmento()
        );
    }

    public boolean estaDisponibleParaVenta() {
        return this.getStock() > 0 && 
               this.getPrecio() > 0 && 
               this.getGarantia() >= 1.0; // Mínimo 1 año de garantía para teléfonos
    }

    public int getAlmacenamientoGB() {
        return almacenamientoGB;
    }

    public void setAlmacenamientoGB(int almacenamientoGB) {
        this.almacenamientoGB = almacenamientoGB;
    }

    public int getCapacidadRam() {
        return capacidadRam;
    }

    public void setCapacidadRam(int capacidadRam) {
        this.capacidadRam = capacidadRam;
    }

    public String getSoOperativo() {
        return soOperativo;
    }

    public void setSoOperativo(String soOperativo) {
        this.soOperativo = soOperativo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

   
    @Override
    public String toString() {
        return String.format(
            "TELÉFONO [ID: %d] %s - %s\n" +
            "Especificaciones: %s\n" +
            "Segmento: %s | 5G: %s | Gaming: %s | Empresarial: %s\n" +
            "Relación Calidad-Precio: %s\n" +
            "Precio: $%.2f | IVA: $%.2f | Stock: %d | Garantía: %.1f años\n" +
            "Disponible: %s",
            getId(), getNombre(), getMarca() + " " + getModelo(),
            getEspecificacionesTecnicas(),
            getSegmento(), esCompatibile5G() ? "Sí" : "No", 
            esParaGaming() ? "Sí" : "No", esEmpresarial() ? "Sí" : "No",
            getRelacionCalidadPrecio(),
            getPrecio(), calcularPercioIVa(), getStock(), getGarantia(),
            estaDisponibleParaVenta() ? "Sí" : "No"
        );
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}