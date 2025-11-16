
package com.mycompany.proyecto_firebase;


import com.mycompany.proyecto_firebase.Producto;


/**
 * La clase representa una herramienta electrónica como producto especializado.
 * Extendido de la clase Producto con atributos específicos de herramientas electrónicas.
 */
public class HerramientaElectronica extends Producto {
    private String tipoHerramienta;        
    private String tipoFuenteEnergia;     
    private double voltaje;               
    private boolean fuenteDeBateria;     
    private boolean incluyeEstuche;       
    private String material;               
    private String aplicacion;             
    private int cantidadPiezas;            

    /**
     * Constructor para crear una herramienta electrónica.
     * 
     * @param Id ID del producto
     * @param nombre Nombre de la herramienta
     * @param precio Precio base
     * @param stock Cantidad disponible
     * @param marca Marca fabricante
     * @param modelo Modelo específico
     * @param garantia Años de garantía
     * @param tipoHerramienta Tipo de herramienta
     * @param tipoFuenteEnergia Fuente de energía
     * @param voltaje Voltaje de operación
     * @param fuenteDeBateria Si usa batería
     * @param incluyeEstuche Si incluye estuche
     * @param material Material de construcción
     * @param aplicacion Aplicación principal
     * @param cantidadPiezas Número de piezas incluidas
     */

    
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

   
    /**
     * Calcula el precio con IVA del 19%.
     * @return Precio con IVA incluido
     */
    
    @Override
    public double calcularPercioIVa() {
        double iva = 0.19;  // IVA del 19% para herramientas
        return this.getPrecio() * (1 + iva);
    }
    
    /**
     * Obtiene el tipo de categoría del producto.
     * @return "Herramienta Electrónica"
     */
    
    @Override
    public String getTipoCategoria() {
        return "Herramienta Electrónica";
    }
    
    
    /**
     * Determina el nivel profesional según el tipo de herramienta.
     * 
     * @return Nivel de profesionalidad requerido
     */

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
    
      /**
     * Obtiene información resumida de la herramienta.
     * @return String con información básica formateada
     */

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
    
   
    // GETTERS Y SETTERS

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

    /**
     * Representación en String de la herramienta electrónica. 
     * @return String con todos los detalles formateados
     *
    */
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
            cantidadPiezas, getNivelProfesional()
        );
    }
}