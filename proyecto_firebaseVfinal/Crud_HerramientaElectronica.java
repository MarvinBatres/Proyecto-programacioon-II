package com.mycompany.proyecto_firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 
 *  Clase CRUD para gestionar operaciones de Herramientas Electrónicas en Firebase Firestore.
 * Proporciona métodos para crear, leer, actualizar y eliminar registros de herramientas electrónicas.
 * 
 * @author Marvin Batres
 */



public class Crud_HerramientaElectronica {

    CollectionReference reference;
    static Firestore db;

    
    
    /**
     * Guarda una nueva herramienta electrónica en Firestore.
     * 
     * @param coleccion Nombre de la colección en Firestore
     * @param documento ID del documento a guardar
     * @param data_H Mapea con los datos de la herramienta electrónica
     * @return retorna un true si se guardó correctamente, false en caso de error
     */
    
    
    public static boolean guardarHer_Elect(String coleccion, String documento, Map<String, Object> data_H) {
        Firestore db = Conexion_Base.getDb();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data_H);
            System.out.println("Guardado de datos correctamente en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    
    /**
     * Actualiza los datos de una herramienta electrónica existente.
     * 
     * @param coleccion Nombre de la colección en Firestore
     * @param documento ID del documento a actualizar
     * @param data_h Mapa con los nuevos datos a actualizar
     * @return true si se actualizó correctamente, false en caso de error
     */
    public static boolean actualizarHer_Elect(String coleccion, String documento, Map<String, Object> data_h) {
        Firestore db = Conexion_Base.getDb();

        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.update(data_h);
            System.out.println("Actualización de datos correctamente en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
      /**
     * Elimina una herramienta electrónica de Firestore.
     * 
     * @param coleccion Nombre de la colección en Firestore
     * @param documento ID del documento a eliminar
     * @return retorna un true si se eliminó correctamente, false en caso de error
     */   
    

    public static boolean eliminarHer_Elect(String coleccion, String documento) {
        Firestore db = Conexion_Base.getDb();

        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.delete(Precondition.NONE);
            System.out.println("Eliminación de datos correcta en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    /**
     * Carga los datos de herramientas electrónicas en una JTable.
     * @param table Tabla donde se mostrarán los datos
     */
    
 
    public static void cargarTablaHerramienta(JTable table) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Stock");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Garantia");
        model.addColumn("tipoHerramienta");
        model.addColumn("tipoFuenteEnergia");
        model.addColumn("voltaje");
        model.addColumn("fuenteDeBateria");
        model.addColumn("IncluyeEstuche");
        model.addColumn("Material");
        model.addColumn("Aplicacion");
        model.addColumn("CantidadPiezas");

        try {

            CollectionReference herramienta = Conexion_Base.db.collection("HerramientaElectronica");
            ApiFuture<QuerySnapshot> querySnap = herramienta.get();

            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                model.addRow(new Object[]{
                    document.getId(),
                    document.getString("Nombre"),
                    document.get("Precio").toString(),
                    document.get("Stock").toString(),
                    document.getString("Marca"),
                    document.getString("Modelo"),
                    document.get("Garantia").toString(),
                    document.getString("tipoHerramienta"),
                    document.getString("tipoFuenteEnergia"),
                    document.get("voltaje").toString(),
                    document.get("fuenteDeBateria").toString(),
                    document.get("IncluyeEstuche").toString(),
                    document.getString("Material"),
                    document.getString("Aplicacion"),
                    document.get("CantidadPiezas").toString(),});
            }

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error: " + e.getMessage());
        }
        table.setModel(model);
    }

    /**
     * Busca una herramienta electrónica por su ID.
     * @param Id ID de la herramienta a buscar
     * @return Objeto HerramientaElectronica si se encuentra, null si no existe
     */
    
    public static HerramientaElectronica buscarHerramientaID(String Id) {
        try {
            Firestore db = Conexion_Base.getDb();
            DocumentReference docRef = db.collection("HerramientaElectronica").document(Id);
            ApiFuture<DocumentSnapshot> result = docRef.get();
            DocumentSnapshot document = result.get();

            if (document.exists()) {
                Map<String, Object> datos = document.getData();
                HerramientaElectronica herramienta = new HerramientaElectronica(
                        Integer.parseInt(Id),
                        (String) datos.get("Nombre"),
                        ((double) datos.get("Precio")),
                        ((Long) datos.get("Stock")).intValue(),
                        (String) datos.get("Marca"),
                        (String) datos.get("Modelo"),
                        ((double) datos.get("Garantia")),
                        (String) datos.get("tipoHerramienta"),
                        (String) datos.get("tipoFuenteEnergia"),
                        ((Long) datos.get("voltaje")).intValue(),
                        ((boolean) datos.get("fuenteDeBateria")),
                        ((boolean) datos.get("IncluyeEstuche")),
                        (String) datos.get("Material"),
                        (String) datos.get("Aplicacion"),
                        ((Long) datos.get("CantidadPiezas")).intValue()
                );

                return herramienta;
            } else {
                System.out.println("No se encontro la Herramienta Electronica. ");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error en la busquedad: " + e.getMessage());
            return null;
        }
    }

}
