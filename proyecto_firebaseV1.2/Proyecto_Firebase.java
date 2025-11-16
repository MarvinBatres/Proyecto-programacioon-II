package com.mycompany.proyecto_firebase;

import javax.swing.*;

public class Proyecto_Firebase {

    public static void main(String[] args) {
      
/*
        // ==================== CREACIÓN DE UNA HERRAMIENTA ELECTRÓNICA ====================
        
        HerramientaElectronica multimetro = new HerramientaElectronica(
            1001,                                    // ID
            "Multímetro Digital Profesional",        // Nombre
            89.99,                                   // Precio
            15,                                      // Stock
            "Fluke",                                 // Marca
            "117 Electricians",                      // Modelo
            3.0,                                     // Garantía (años)
            "Multímetro",                            // Tipo herramienta
            "Batería",                               // Fuente energía
            9.0,                                     // Voltaje
            true,                                    // Fuente batería
            true,                                    // Incluye estuche
            "Plástico industrial",                   // Material
            "Medición eléctrica",                    // Aplicación
            1                                        // Cantidad piezas
        );

        // ==================== DEMOSTRACIÓN DE FUNCIONALIDADES ====================
        
        System.out.println("=== INFORMACIÓN COMPLETA DE LA HERRAMIENTA ===\n");
        
        // Mostrar información completa usando toString()
        System.out.println(multimetro.toString());
        
        System.out.println("\n=== INFORMACIÓN ESPECÍFICA ===\n");
        
        // Usar métodos específicos de la clase
        System.out.println("Categoría: " + multimetro.getTipoCategoria());
        System.out.println("Nivel profesional: " + multimetro.getNivelProfesional());
        System.out.println("¿Es de precisión?: " + (multimetro.esDePrecision() ? "Sí" : "No"));
        System.out.println("Precio con IVA: $" + multimetro.calcularPercioIVa());
        System.out.println("Recomendaciones seguridad: " + multimetro.getRecomendacionesSeguridad());
        System.out.println("Mantenimiento requerido: " + multimetro.getMantenimientoRequerido());
        System.out.println("¿Adecuado para principiantes?: " + (multimetro.esParaPrincipiantes() ? "Sí" : "No"));
        System.out.println("¿Disponible para venta?: " + (multimetro.estaDisponibleParaVenta() ? "Sí" : "No"));
        System.out.println("Información completa: " + multimetro.getInfoCompletaHerramienta());
        
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        LlamarVentana();

    }

    public static void LlamarVentana() {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Menu_Principal ventanaprincipal = new Menu_Principal();
                ventanaprincipal.setVisible(true);
            }

        });
    }

}




        /*
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
         */


/*
        AsistenteCasa asistenteCasa = new AsistenteCasa(10,"Small DPF",800.00,20,"LG","ApliAdvancs",2,"Camara seguridad","Wifi","Bluetoo",true,"USB",true,"todo el hogar",false);  
       System.out.println(asistenteCasa.toString()); 
       System.out.println("Precio con IVA: Q"+asistenteCasa.calcularPercioIVa());
      System.out.println("Categoria: "+asistenteCasa.getTipoCategoria());
      
//        
//     */