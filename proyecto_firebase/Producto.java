package com.mycompany.proyecto_firebase;
//Clase padre de productos electronicos

public abstract class Producto {

    protected int Id;
    protected String nombre;
    protected Double precio;
    protected int stock;
    protected String marca;
    protected String modelo;
    protected double garantia;

    public Producto(int Id, String nombre, Double precio, int stock, String marca, String modelo, double garantia) {
        this.Id = Id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.marca = marca;
        this.modelo = modelo;
        this.garantia = garantia;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getGarantia() {
        return garantia;
    }

    public void setGarantia(double garantia) {
        this.garantia = garantia;
    }
    //Metodos abstracto de herencias para las clases hijas
    public abstract double calcularPercioIVa();
    public abstract String getTipoCategoria();

}
