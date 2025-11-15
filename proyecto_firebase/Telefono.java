/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_firebase;

/**
 *
 * @author Marvin Batres
 */
public class Telefono extends Producto{
    private int Almacenamiento;
    private int CapacidadRam;
    private String Sist_op;
    private int tamanio;

    public Telefono(int Almacenamiento, int CapacidadRam, String Sist_op, int tamanio, int Id, String nombre, Double precio, int stock, String marca, String modelo, double garantia) {
        super(Id, nombre, precio, stock, marca, modelo, garantia);
        this.Almacenamiento = Almacenamiento;
        this.CapacidadRam = CapacidadRam;
        this.Sist_op = Sist_op;
        this.tamanio = tamanio;
    }

    public int getAlmacenamiento() {
        return Almacenamiento;
    }

    public void setAlmacenamiento(int Almacenamiento) {
        this.Almacenamiento = Almacenamiento;
    }

    public int getCapacidadRam() {
        return CapacidadRam;
    }

    public void setCapacidadRam(int CapacidadRam) {
        this.CapacidadRam = CapacidadRam;
    }

    public String getSist_op() {
        return Sist_op;
    }

    public void setSist_op(String Sist_op) {
        this.Sist_op = Sist_op;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    
    
    @Override
    public double calcularPercioIVa() {
        return this.precio * 1.16;
    }

    @Override
    public String getTipoCategoria() {
        return  "Telefono marca: "+super.marca+", de sistema operativo "+ this.Sist_op+" y un tamaño de "+this.tamanio;
    }
    
    
    
}
