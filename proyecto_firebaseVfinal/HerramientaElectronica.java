
package com.mycompany.proyecto_firebase;


import com.mycompany.proyecto_firebase.Producto;


public class HerramientaElectronica extends Producto {
    private String tipoHerramienta;        
    private String tipoFuenteEnergia;     
    private double voltaje;               
    private boolean fuenteDeBateria;     
    private boolean incluyeEstuche;       
    private String material;               
    private String aplicacion;             
    private int cantidadPiezas;            

    
    public HerramientaElectronica(int Id, String nombre, Double precio, int stock, 
                                 String marca, String modelo, double garantia,
                                 String tipoHerramienta, String tipoFuenteEnergia, 
                                 double voltaje, boolean fuenteDeBateria, 
                                 boolean incluyeEstuche, String material,
                                 String aplicacion, int cantidadPiezas) {
        
        super(Id, nombre, precio, stock, marca, modelo, garantia);
       
        this.tipoHerramienta = tipoHerramienta;
        this.tipoFuenteEnergia = tipoFuenteEnergia;
        this.voltaje = voltaje;
        this.fuenteDeBateria = fuenteDeBateria;
        this.incluyeEstuche = incluyeEstuche;
        this.material = material;
        this.aplicacion = aplicacion;
        this.cantidadPiezas = cantidadPiezas;
    }

   
    @Override
    public double calcularPercioIVa() {
        double iva = 0.19;  // IVA del 19% para herramientas
        return this.getPrecio() * (1 + iva);
    }
    
    @Override
    public String getTipoCategoria() {
        return "Herramienta Electrónica";
    }

    public String getNivelProfesional() {
        switch(tipoHerramienta.toLowerCase()) {
            case "desarmador de precisión":
            case "pinza de corte":
            case "sopladora":
                return "Profesional - Técnico Especializado";
            case "multímetro":
            case "osciloscopio":
            case "fuente de poder":
                return "Avanzado - Ingeniería/Reparación";
            case "kit de desarmadores":
            case "soldador básico":
                return "Intermedio - Aficionado/Estudiante";
            default:
                return "Básico - Hogar/Principiante";
        }
    }
    
    
    public boolean esDePrecision() {
        String[] herramientasPrecision = {
            "desarmador de precisión", "pinza", "tweezers", 
            "sonda", "microscopio", "lupa"
        };
        
        for (String herramienta : herramientasPrecision) {
            if (tipoHerramienta.toLowerCase().contains(herramienta)) {
                return true;
            }
        }
        return false;
    }
    
    
    public String getRecomendacionesSeguridad() {
        StringBuilder seguridad = new StringBuilder();
        
        if (voltaje > 50) {
            seguridad.append("• Usar guantes aislantes • ");
        }
        if (tipoHerramienta.toLowerCase().contains("soldador")) {
            seguridad.append("• Usar careta y guantes • ");
        }
        if (esDePrecision()) {
            seguridad.append("• Manipular con cuidado • ");
        }
        if (tipoFuenteEnergia.equals("Eléctrica")) {
            seguridad.append("• Verificar conexión a tierra • ");
        }
        
        return seguridad.length() > 0 ? seguridad.toString() : "Uso general seguro";
    }
    
   
    public String getMantenimientoRequerido() {
        if (tipoHerramienta.toLowerCase().contains("soldador")) {
            return "Mensual - Limpieza de puntas";
        } else if (tipoFuenteEnergia.equals("Batería")) {
            return "Trimestral - Recarga/Cambio de baterías";
        } else if (esDePrecision()) {
            return "Semestral - Calibración y limpieza";
        } else {
            return "Anual - Revisión general";
        }
    }
    
    public double calcularPrecioPorPieza() {
        if (cantidadPiezas > 0) {
            return this.getPrecio() / cantidadPiezas;
        }
        return this.getPrecio();
    }
    
    public boolean esParaPrincipiantes() {
        return !esDePrecision() && 
               !tipoHerramienta.toLowerCase().contains("soldador") &&
               voltaje <= 24;
    }

    public String getInfoCompletaHerramienta() {
        return String.format(
            "%s %s - %s | Aplicación: %s | %d piezas | Nivel: %s",
            this.getMarca(),
            this.getModelo(),
            this.tipoHerramienta,
            this.aplicacion,
            this.cantidadPiezas,
            this.getNivelProfesional()
        );
    }
    
    public boolean estaDisponibleParaVenta() {
        return this.getStock() > 0 && 
               this.getPrecio() > 0 && 
               this.getGarantia() >= 0.5; // Mínimo 6 meses de garantía
    }

    public String getTipoHerramienta() {
        return tipoHerramienta;
    }

    public void setTipoHerramienta(String tipoHerramienta) {
        this.tipoHerramienta = tipoHerramienta;
    }

    public String getTipoFuenteEnergia() {
        return tipoFuenteEnergia;
    }

    public void setTipoFuenteEnergia(String tipoFuenteEnergia) {
        this.tipoFuenteEnergia = tipoFuenteEnergia;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public boolean isFuenteDeBateria() {
        return fuenteDeBateria;
    }

    public void setFuenteDeBateria(boolean fuenteDeBateria) {
        this.fuenteDeBateria = fuenteDeBateria;
    }

    public boolean isIncluyeEstuche() {
        return incluyeEstuche;
    }

    public void setIncluyeEstuche(boolean incluyeEstuche) {
        this.incluyeEstuche = incluyeEstuche;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public int getCantidadPiezas() {
        return cantidadPiezas;
    }

    public void setCantidadPiezas(int cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }

    @Override
    public String toString() {
        return String.format(
            "HERRAMIENTA ELECTRÓNICA [ID: %d] %s - %s\n" +
            "Tipo: %s | Aplicación: %s | Material: %s\n" +
            "Fuente: %s | Voltaje: %.1fV | Batería: %s | Estuche: %s\n" +
            "Piezas: %d | Nivel: %s | Precisión: %s\n" +
            "Precio: $%.2f | IVA: $%.2f | Stock: %d | Garantía: %.1f años\n" +
            "Mantenimiento: %s | Para principiantes: %s\n" +
            "Seguridad: %s",
            getId(), getNombre(), getMarca() + " " + getModelo(),
            tipoHerramienta, aplicacion, material,
            tipoFuenteEnergia, voltaje, fuenteDeBateria ? "Sí" : "No", 
            incluyeEstuche ? "Sí" : "No",
            cantidadPiezas, getNivelProfesional(), esDePrecision() ? "Alta" : "Estándar",
            getPrecio(), calcularPercioIVa(), getStock(), getGarantia(),
            getMantenimientoRequerido(), esParaPrincipiantes() ? "Sí" : "No",
            getRecomendacionesSeguridad()
        );
    }
}