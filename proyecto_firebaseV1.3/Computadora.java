package com.mycompany.proyecto_firebase;

//Clase hija de producto
public class Computadora extends Producto implements Conectable, GarantiaExtendida {

    private String procesador;
    private int AlmacenamientoGB;
    private String TarjGrafica;
    private String TipoComputadora;
    private String EstConexion;
    private boolean conectada;

    public Computadora(String procesador, int AlmacenamientoGB, String TarjGrafica, String TipoComputadora, String EstConexion, int Id, String nombre, double precio, int stock, String marca, String modelo, double garantia) {
        super(Id, nombre, precio, stock, marca, modelo, garantia);
        
        this.procesador = procesador;
        this.AlmacenamientoGB = AlmacenamientoGB;
        this.TarjGrafica = TarjGrafica;
        this.TipoComputadora = TipoComputadora;
        this.EstConexion = EstConexion;
        this.conectada = false;
    }

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

    

    @Override
    public double calcularPercioIVa() {
        return this.precio * 1.19;

    }
    
    @Override
    public String getTipoCategoria() {
        return "Computadora marca: " + super.marca + ", de sistema operativo " + this.TipoComputadora + ", tarjeta grafica" + this.TarjGrafica;

    }
    
    //Metodo para convertir el valor de IVa a dos decimales 
    public String IvaFOrmateado(){
        return String.format("$%.2f", this.calcularPercioIVa());
    }
    
    
    
    //------------------------------------------Interfaces para la clase computadora 
    @Override
    public void EstadoConexion(String estado) {
        this.EstConexion = estado;
        System.out.println("Estado de conexión: " + estado);
    }

    @Override
    public boolean Conectar(){
        if(!this.conectada){
            this.conectada = true;
            System.out.println("La computadora "+super.nombre+" conectado con exito");
            return true;
        }else{
             System.out.println("La computadora "+super.nombre+" ya estába conectada");
             return false;
        }
        
    }
    
        @Override
        public boolean Desconectar(){
        if(this.conectada){
            this.conectada = false;
            System.out.println("La computadora "+super.nombre+" Desconectado con exito");
            return true;
        }else{
             System.out.println("La computadora "+super.nombre+" ya estába Desconectada");
             return false;
        }
        
    }

    @Override
    public double calcularCostoGarantia(double precio) {
            return precio * 0.05;
   }
    
   
    

    @Override
    public boolean GarantiaElegibleExtendida() {
        return super.precio > 1000 && super.stock > 0;
    }
        
   
    //Metodo para dar formato a dos decimales 
    public String getCostoGarantiaFormato(){
        return String.format("$%.2f", this.calcularCostoGarantia(super.precio));
    } 
    
    public String FormatoPrecio(double numero){
        return String.format("%.2f", numero);
    }
    
    
    //Metodo para mostrar la informacion 
    public void mostrarInformacion(){
        
        System.out.println("---Impresion de la computadora------------");
        System.out.println("Procesador: "+ this.procesador);
        System.out.println("Tamaño de almacenamiento: "+this.AlmacenamientoGB+"GB");
        System.out.println("Tarjeta grafica: "+this.TarjGrafica);
        System.out.println("Tipo de computadora: "+ this.TipoComputadora);
        System.out.println("Estado de Conexion: "+this.EstConexion);
        System.out.println("Marca: "+super.marca);
        System.out.println("Cantidad de ingreso: "+super.stock);
        System.out.println("Modelo: "+super.modelo);
        
        
        System.out.println("Elegible para garantía extendida: " + (this.GarantiaElegibleExtendida() ? "SÍ" : "NO"));

        if (this.GarantiaElegibleExtendida()) {
            double costoGarantia = this.calcularCostoGarantia(super.precio);
            System.out.println("Costo garantía extendida: Q" + this.getCostoGarantiaFormato());
            System.out.println("Precio total con garantía: Q" + FormatoPrecio(super.precio + costoGarantia));
        }
        }
        
                
        
        
        
     

}
