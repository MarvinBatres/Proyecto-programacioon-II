
package com.mycompany.proyecto_firebase;

/**
 * Clase que representa un teléfono inteligente como producto.
 * Extiende de la clase Producto y añade características específicas de smartphones.
 */

public class Telefono extends Producto {
    private int almacenamientoGB;      
    private int capacidadRam;          
    private String soOperativo;       
    private String tamanio;           

    /**
     *  * Constructor para crear un objeto Telefono.
     * @param Id ID único del teléfono
     * @param nombre Nombre del teléfono
     * @param precio Precio base del teléfono
     * @param stock Cantidad disponible en inventario
     * @param marca Marca del teléfono
     * @param modelo Modelo específico del teléfono
     * @param garantia Años de garantía del producto
     * @param almacenamientoGB Capacidad de almacenamiento en GB
     * @param capacidadRam Memoria RAM en GB
     * @param soOperativo Sistema operativo del teléfono
     * @param tamanio Tamaño de la pantalla
     
     * 
     */

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

      /**
     * Calcula el precio del teléfono incluyendo el IVA del 19%.
     * @return Precio con IVA incluido
     */
    
    @Override
    public double calcularPercioIVa() {
        double iva = 0.19;  // IVA del 19% para teléfonos
        return this.getPrecio() * (1 + iva);
    }
    
     /**
     * Obtiene la categoría del producto.
     * @return String "Teléfono Inteligente"
     */
    
    @Override
    public String getTipoCategoria() {
        return "Teléfono Inteligente";
    }

    

    
   
    public String getEspecificacionesTecnicas() {
        return String.format(
            "Pantalla: %s | RAM: %dGB | Almacenamiento: %dGB | SO: %s",
            tamanio, capacidadRam, almacenamientoGB, soOperativo
        );
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
            getEspecificacionesTecnicas()
        );
    }

    //Getter y Setters

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

      /**
     * Representación en String del objeto Telefono.
     * 
     * @return String con toda la información del teléfono formateada
     */
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
            getEspecificacionesTecnicas()
        );
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}