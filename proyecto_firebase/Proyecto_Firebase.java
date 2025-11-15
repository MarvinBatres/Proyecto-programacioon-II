

package com.mycompany.proyecto_firebase;

/**
 *
 * @author Marvin Batres
 */
public class Proyecto_Firebase {

    public static void main(String[] args) {
        //Conexion_Base.conectarFirebase();
        
        Computadora compu = new Computadora("Core I7",256,"RTX2060","Laptop","Inahlambrica",01,"ZORT",2500.95,45,"HP","Pavillon",0.15);
        
        System.out.println("Precio con IVA: Q"+compu.calcularPercioIVa());
        System.out.println("Categoria: "+compu.getTipoComputadora());
        compu.EstadoConexion("Inahlambrico");
        
        
        System.out.println("--------Prueba de conexion------------");
 
        compu.Conectar();
        compu.EstadoConexion("Ethernet");
        compu.Desconectar();
        
        
        
        System.out.println("----Prueba de garantía---------");
        compu.mostrarInformacion();
        
    }
}
