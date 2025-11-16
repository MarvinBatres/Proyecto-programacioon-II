
package com.mycompany.proyecto_firebase;


/**
 * Interface Conectable
 */
public interface Conectable {
    public void EstadoConexion(String estado);
    public boolean Conectar();
    public boolean Desconectar();

}