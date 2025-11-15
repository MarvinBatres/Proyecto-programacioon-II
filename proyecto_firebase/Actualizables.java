
package com.mycompany.proyecto_firebase;




public interface Actualizables {
    public boolean hayActualizacion();
    public void InstalarActualizacion(String version);
    public String getVersionActualible();
}
