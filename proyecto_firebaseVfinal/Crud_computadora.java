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
 * Clase CRUD para operaciones con computadoras en Firebase Firestore
 * Proporciona métodos para crear, leer, actualizar y eliminar registros de computadoras
 */

public class Crud_computadora {

    CollectionReference reference;
    static Firestore db;
    
    
     /**
     * Guarda una nueva computadora en Firestore
     * @param coleccion Nombre de la colección
     * @param documento ID del documento
     * @param data Datos de la computadora
     * @return retorna un true si se guardó correctamente la información o false en caso de un error
     */

    public static boolean guardarComputadora(String coleccion, String documento, Map<String, Object> data) {
        Firestore db = Conexion_Base.getDb();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Guardado de datos correctamente en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    /**
     * Actualiza los datos de una computadora existente
     * @param coleccion Nombre de la colección
     * @param documento ID del documento
     * @param data Datos para  actualizarlos
     * @return retorna un true si se actualizo correctamente la información o false en caso de un error
     */
    

    public static boolean actualizarComputadora(String coleccion, String documento, Map<String, Object> data) {
        Firestore db = Conexion_Base.getDb();

        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.update(data);
            System.out.println("Actualización de datos correctamente en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    
    
    /**
     * Elimina una computadora de Firestore
     * @param coleccion Nombre de la colección
     * @param documento ID del documento en eliminar
     * @return retorna un true si se elimino correctamente la información o false en caso de un error
     */
    

    public static boolean eliminarComputadora(String coleccion, String documento) {
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
     * Carga los datos de computadoras en una tabla Swing
     * @param table JTable donde se mostrarán los datos
     */
    
    public static void cargarTablaComputadora(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("procesador");
        model.addColumn("tamañoGb");
        model.addColumn("TarjetaGr");
        model.addColumn("TipoComputadora");
        model.addColumn("EstadoConexion");
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Stock");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Garantia");
       //model.addColumn("IVA");
       //model.addColumn("Categoría");

        try {
            CollectionReference compus = Conexion_Base.db.collection("Computadora");
            ApiFuture<QuerySnapshot> querySnap = compus.get();

            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                
                model.addRow(new Object[]{
                    document.getString("procesador"),
                    document.get("tamañoGb").toString(),
                    document.getString("TarjetaGr"),
                    document.getString("TipoComputadora"),
                    document.getString("EstadoConexion"),
                    document.getId(),
                    document.getString("Nombre"),
                    document.get("Precio").toString(),
                    document.get("Stock").toString(),
                    document.getString("Marca"),
                    document.get("Modelo").toString(),
                    document.get("Garantia").toString(),
                 //   document.get("IVA").toString(),
                   // document.getString("Categoria"),
                    
                });
                    
            }

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error: " + e.getMessage());
        }
        table.setModel(model);

    }
    
      /**
     * Busca una computadora por su ID
     * @param Id ID de la computadora a buscar
     * @return retorna un Objeto Computadora si se encuentra el Id de la información, null si no existe
     */

    public static Computadora buscarComputadoraID(String Id) {

        try{
            Firestore db = Conexion_Base.getDb();
            DocumentReference docRef = db.collection("Computadora").document(Id);
            ApiFuture<DocumentSnapshot> result = docRef.get();
            DocumentSnapshot document = result.get();

            if (document.exists()) {
                Map<String, Object> datos = document.getData();
                Computadora computadora;
                computadora = new Computadora(
                        (String)datos.get("procesador"),
                        ((Long)datos.get("tamañoGb")).intValue(),
                        (String)datos.get("TarjetaGr"),
                        (String)datos.get("TipoComputadora"),
                        (String)datos.get("EstadoConexion"),
                        Integer.parseInt(Id),
                        (String)datos.get("Nombre"),
                        ((double)datos.get("Precio")),
                        ((Long)datos.get("Stock")).intValue(),
                        (String)datos.get("Marca"),
                        (String)datos.get("Modelo"),
                        ((double)datos.get("Garantia"))                    
                );
                
                return computadora;
                
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
