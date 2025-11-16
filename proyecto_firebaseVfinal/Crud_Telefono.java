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
 * Clase utilizado para operaciones CRUD de teléfonos en Firebase Firestore
 * Proporciona métodos para guardar, actualizar, eliminar y consultar teléfonos
 */
public class Crud_Telefono {

    CollectionReference reference;
    static Firestore db;
    /**
     * Guarda un nuevo teléfono en Firestore
     * @param coleccion Nombre de la colección
     * @param documento ID del documento
     * @param datos_t Datos del teléfono para su guardado en Firebase
     * @return retorna un true si se guardó correctamente o false en caso de error
     */
    
    
    public static boolean guardarTelefono(String coleccion, String documento, Map<String, Object> datos_t) {
        Firestore db = Conexion_Base.getDb();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(datos_t);
            System.out.println("Guardado de datos de Telefono correctamente en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;

    }

    
     /**
     * Actualiza un teléfono existente en Firestore
     * @param coleccion Nombre de la colección
     * @param documento ID del documento
     * @param datos_t Datos del teléfono a actualizar
     * @return retorna un true si se actualizó correctamente o false en caso de error
     */
    public static boolean actualizarTelefono(String coleccion, String documento, Map<String, Object> datos_t) {
        Firestore db = Conexion_Base.getDb();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.update(datos_t);
            System.out.println("Actualización de datos de Telefono correctamente en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;

    }
    
    /**
     * Elimina un teléfono de Firestore
     * @param coleccion Nombre de la colección
     * @param documento ID del documento a eliminar
     * @return retorna un true si se actualizó correctamente o false en caso de error
     */

    public static boolean eliminarTelefono(String coleccion, String documento) {
        Firestore db = Conexion_Base.getDb();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.delete(Precondition.NONE);
            System.out.println("Eliminación de datos de Telefono correctamente en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;

    }
    
     /**
     * Carga todos los teléfonos en una tabla en formulario
     * @param table JTable donde se mostrarán los datos 
     */

    public static void cargaTablaTelefono(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Stock");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Garantia");
        model.addColumn("AlmacenamientoGB");
        model.addColumn("CapacdidadRam");
        model.addColumn("soOperativo");
        model.addColumn("Tamaño");

        try {
            CollectionReference compus = Conexion_Base.db.collection("Telefono");
            ApiFuture<QuerySnapshot> querySnap = compus.get();

            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                model.addRow(new Object[]{
                    document.getId(),
                    document.getString("Nombre"),
                    document.get("Precio").toString(),
                    document.get("Stock").toString(),
                    document.getString("Marca"),
                    document.getString("Modelo"),
                    document.get("Garantia").toString(),
                    document.get("AlmacenamientoGB").toString(),
                    document.get("CapacdidadRam").toString(),
                    document.getString("soOperativo"),
                    document.getString("Tamaño")

                });

            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error: " + e.getMessage());
        }

        table.setModel(model);

    }
    
    /**
     * Busca un teléfono por su ID en Firestore
     * @param Id ID del teléfono a buscar
     * @return retorna un Objeto Telefono si se encuentra, null si no existe o hay error
     */
    
    public static Telefono buscarTelefonoID(String Id) {

        try {
            Firestore db = Conexion_Base.getDb();
            DocumentReference docRef = db.collection("Telefono").document(Id);
            ApiFuture<DocumentSnapshot> result = docRef.get();
            DocumentSnapshot document = result.get();

            if (document.exists()) {
                Map<String, Object> datos = document.getData();
                Telefono telefono = new Telefono(
                    Integer.parseInt(Id),
                    (String)datos.get("Nombre"),
                    ((double)datos.get("Precio")),
                    ((Long)datos.get("Stock")).intValue(),
                    (String)datos.get("Marca"),
                    (String)datos.get("Modelo"),
                    ((double)datos.get("Garantia")),
                    ((Long)datos.get("AlmacenamientoGB")).intValue(),
                    ((Long)datos.get("CapacdidadRam")).intValue(),
                    (String)datos.get("soOperativo"),
                    (String)datos.get("Tamaño")            
        
                );
                
                return telefono;
            }else{
                System.out.println("No se encontro la computadora. ");
            return null; 
            }
            
             
        }catch(Exception e){
            System.out.println("Error en la busquedad: " + e.getMessage());
            return null;  
        }
        
        
        
    }
    
    
    
}
