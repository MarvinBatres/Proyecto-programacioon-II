package com.mycompany.proyecto_firebase;

//Clase hija de producto
public class Computadora extends Producto implements Conectable, GarantiaExtendida {

    private String procesador;
    private int AlmacenamientoGB;
    private String TarjGrafica;
    private String TipoComputadora;
    private String EstConexion;
    private boolean conectada;

    /**
     * Constructor completo para crear una instancia de Computadora.
     * 
     * @param procesador El procesador que lleva el dispositivo
     * @param AlmacenamientoGB Tamaño de almacenamiento del dispositivo en Gigabytes
     * @param TarjGrafica La tarjeta gráfica del dispositivo
     * @param TipoComputadora El tipo de computadora que se está ingresando
     * @param EstConexion El estado de conexión inicial del dispositivo
     * @param Id Número de identificación del producto
     * @param nombre Nombre del dispositivo
     * @param precio Precio de venta del dispositivo
     * @param stock Cantidad de unidades disponibles del producto
     * @param marca Marca del producto
     * @param modelo Tipo de modelo del producto
     * @param garantia Garantía en años que tiene el producto
     */
    public Computadora(String procesador, int AlmacenamientoGB, String TarjGrafica, String TipoComputadora, String EstConexion, int Id, String nombre, double precio, int stock, String marca, String modelo, double garantia) {
        super(Id, nombre, precio, stock, marca, modelo, garantia);

        this.procesador = procesador;
        this.AlmacenamientoGB = AlmacenamientoGB;
        this.TarjGrafica = TarjGrafica;
        this.TipoComputadora = TipoComputadora;
        this.EstConexion = EstConexion;
        this.conectada = false;
    }

    
    /**
     * Obtiene el procesador de la computadora.
     * @return El procesador de la computadora
     */
    
    public String getProcesador() {
        return procesador;
    }

    
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getAlmacenamientoGB() {
        return AlmacenamientoGB;
    }

    public void setAlmacenamientoGB(int AlmacenamientoGB) {
        this.AlmacenamientoGB = AlmacenamientoGB;
    }

    public String getTarjGrafica() {
        return TarjGrafica;
    }

    public void setTarjGrafica(String TarjGrafica) {
        this.TarjGrafica = TarjGrafica;
    }

    public String getTipoComputadora() {
        return TipoComputadora;
    }

    public void setTipoComputadora(String TipoComputadora) {
        this.TipoComputadora = TipoComputadora;
    }

    public String getEstConexion() {
        return EstConexion;
    }

    public void setEstConexion(String EstConexion) {
        this.EstConexion = EstConexion;
    }

    /**
     * Calcula el precio del producto con IVA incluido.
     * El IVA aplicado es del 19%.
     * 
     * @return El precio del producto con IVA incluido
     */
    @Override
    public double calcularPercioIVa() {
        return this.precio * 1.19;

    }

     /**
     * Obtiene la categoría específica del producto computadora.
     * 
     * @return Una cadena que describe la categoría de la computadora,
     *         incluyendo marca, tipo de sistema operativo y tarjeta gráfica
     */
    @Override
    public String getTipoCategoria() {
        return "Computadora marca: " + super.marca + ", de sistema operativo " + this.TipoComputadora + ", tarjeta grafica" + this.TarjGrafica;

    }


/**
     * Formatea el valor del IVA a dos decimales con símbolo de dólar.
     * 
     * @return El valor del IVA formateado como cadena (ej: "$123.45")
     */

    public String IvaFOrmateado() {
        return String.format("$%.2f", this.calcularPercioIVa());
    }

    
 /**
     * Establece el estado de conexión de la computadora.
     * 
     * @param estado El nuevo estado de conexión a establecer
     */


    @Override
    public void EstadoConexion(String estado) {
        this.EstConexion = estado;
        System.out.println("Estado de conexión: " + estado);
    }
    
    
    /**
     * Conecta la computadora si no está ya conectada.
     * 
     * @return true si la computadora fue conectada exitosamente,
     *         false si ya estaba conectada
     */
    
    
    

    @Override
    public boolean Conectar() {
        if (!this.conectada) {
            this.conectada = true;
            System.out.println("La computadora " + super.nombre + " conectado con exito");
            return true;
        } else {
            System.out.println("La computadora " + super.nombre + " ya estába conectada");
            return false;
        }

    }
    
    
    /**
     * Desconecta la computadora si está conectada.
     *
     * @return true si la computadora fue desconectada exitosamente, false si ya
     * estaba desconectada
     */
    @Override
    public boolean Desconectar() {
        if (this.conectada) {
            this.conectada = false;
            System.out.println("La computadora " + super.nombre + " Desconectado con exito");
            return true;
        } else {
            System.out.println("La computadora " + super.nombre + " ya estába Desconectada");
            return false;
        }

    }
    
      /**
     * Calcula el costo de la garantía extendida para la computadora.
     * El costo es el 5% del precio del producto.
     * 
     * @param precio El precio base del producto
     * @return El costo de la garantía extendida
     */
    @Override
    public double calcularCostoGarantia(double precio) {
        return precio * 0.05;
    }

    
     /**
     * Verifica si la computadora es elegible para garantía extendida.
     * Los criterios son: precio mayor a 1000 y stock disponible.
     * 
     * @return true si es elegible para garantía extendida, false en caso contrario
     */
    
    @Override
    public boolean GarantiaElegibleExtendida() {
        return super.precio > 1000 && super.stock > 0;
    }

    
    /**
     * Formatea el costo de la garantía extendida a dos decimales con símbolo de dólar.
     * @return El costo de garantía formateado como cadena      */
    
    
    public String getCostoGarantiaFormato() {
        return String.format("$%.2f", this.calcularCostoGarantia(super.precio));
    }

    
    
    
    public String FormatoPrecio(double numero) {
        return String.format("%.2f", numero);
    }

    
     /**
     * Despliega toda la información de la computadora en la consola.
     * Incluye características técnicas, información de precio, IVA,
     * y detalles de garantía extendida si es aplicable.
     */
    
    public void mostrarInformacion() {

        System.out.println("---Impresion de la computadora------------");
        System.out.println("Procesador: " + this.procesador);
        System.out.println("Tamaño de almacenamiento: " + this.AlmacenamientoGB + "GB");
        System.out.println("Tarjeta grafica: " + this.TarjGrafica);
        System.out.println("Tipo de computadora: " + this.TipoComputadora);
        System.out.println("Estado de Conexion: " + this.EstConexion);
        System.out.println("Marca: " + super.marca);
        System.out.println("Cantidad de ingreso: " + super.stock);
        System.out.println("Modelo: " + super.modelo);

        System.out.println("Elegible para garantía extendida: " + (this.GarantiaElegibleExtendida() ? "SÍ" : "NO"));

        if (this.GarantiaElegibleExtendida()) {
            double costoGarantia = this.calcularCostoGarantia(super.precio);
            System.out.println("Costo garantía extendida: Q" + this.getCostoGarantiaFormato());
            System.out.println("Precio total con garantía: Q" + FormatoPrecio(super.precio + costoGarantia));
        }
    }

}
