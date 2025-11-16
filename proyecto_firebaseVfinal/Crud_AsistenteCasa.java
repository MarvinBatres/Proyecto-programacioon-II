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
 * Clase para operaciones CRUD de asistentes de casa en Firebase Firestore.
 * Proporciona métodos para guardar, actualizar, eliminar, buscar y cargar en tabla.
 * 
 */



public class Crud_AsistenteCasa {

    CollectionReference reference;
    static Firestore db;

    
    
    /**
     * Guarda un nuevo asistente de casa en Firestore.
     *
     * @param coleccion  Nombre de la colección Firestore
     * @param documento  ID o identificador del documento
     * @param dat_Asist  mapa con los datos del asistente
     * @return true si se guardó correctamente, false en caso de error
     */
    
    
    public static boolean guardarAsistenteCasa(String coleccion, String documento, Map<String, Object> dat_Asist) {
        Firestore db = Conexion_Base.getDb();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(dat_Asist);
            System.out.println("Guardado de datos correctamente en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    
    
      /**
     * Actualiza un asistente de casa existente en Firestore.
     *
     * @param coleccion  Nombre de la colección Firestore
     * @param documento  ID del documento a actualizar
     * @param dat_Asist  mapa con los campos a actualizar
     * @return retorno un true si se actualizó correctamente, false en caso de error
     */
    public static boolean actualizarAsistenteCasa(String coleccion, String documento, Map<String, Object> dat_Asist) {
        Firestore db = Conexion_Base.getDb();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.update(dat_Asist);
            System.out.println("Actualización de datos de asistente de Casa correctamente en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    
    
    
     /**
     * Elimina un asistente de casa de Firestore.
     * @param coleccion  Nombre de la colección Firestore
     * @param documento  ID del documento a eliminar
     * @return retorna un true si se eliminó correctamente, false en caso de error
     */
    public static boolean eliminarAsistenteCasa(String coleccion, String documento) {
        Firestore db = Conexion_Base.getDb();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.delete(Precondition.NONE);
            System.out.println("Eliminación de datos de asistente de Casa correctamente en Firebase");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    
    /**
     * Carga todos los asistentes de casa en una JTable.
     * @param table  JTable donde se mostrarán los datos
     */

    public static void cargarTablaAsistenteCasa(JTable table) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("stock");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Garantía");
        model.addColumn("TipoDispositivo");
        model.addColumn("protocoloComunicacion");
        model.addColumn("CompatibilidadAsistente");
        model.addColumn("TienePantalla");
        model.addColumn("EntradaSalida");
        model.addColumn("esInalambrico");
        model.addColumn("RangoConexion");
        model.addColumn("RequiereHub");

        try {
            CollectionReference ias = Conexion_Base.db.collection("AsistenteCasa");
            ApiFuture<QuerySnapshot> querySnap = ias.get();

            for (DocumentSnapshot document : querySnap.get().getDocuments()) {

                model.addRow(new Object[]{
                    document.getId(),
                    document.getString("Nombre"),
                    document.get("Precio").toString(),
                    document.get("stock").toString(),
                    document.getString("Marca"),
                    document.getString("Modelo"),
                    document.get("Garantía").toString(),
                    document.getString("TipoDispositivo"),
                    document.getString("protocoloComunicacion"),
                    document.getString("compatibilidadAsistente"),
                    document.getBoolean("TienePantalla").toString(),
                    document.getString("EntradaSalida"),
                    document.getBoolean("esInalambrico").toString(),
                    document.getString("RangoConexion"),
                    document.getBoolean("RequiereHub").toString()
                });
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());

        }

        table.setModel(model);
    }

      /**
     * Busca un asistente de casa por su ID.
     * @param Id  ID del asistente a buscar
     * @return objeto AsistenteCasa si se encuentra, null si no existe o hay error
     */
    
    public static AsistenteCasa buscarAsistenteCasa(String Id) {
        //
        try {
            Firestore db = Conexion_Base.getDb();
            DocumentReference docRef = db.collection("AsistenteCasa").document(Id);
            ApiFuture<DocumentSnapshot> result = docRef.get();
            DocumentSnapshot document = result.get();

            if (document.exists()) {
                Map<String, Object> datos = document.getData();
                AsistenteCasa ia;
                ia = new AsistenteCasa(
                       
                        Integer.parseInt(Id),
                        (String) datos.get("Nombre"),
                        ((Double) datos.get("Precio")),
                        ((Long) datos.get("stock")).intValue(),
                        (String) datos.get("Marca"),
                        (String) datos.get("Modelo"),
                        ((double) datos.get("Garantía")),
                        (String) datos.get("TipoDispositivo"),
                        (String) datos.get("protocoloComunicacion"),
                        (String) datos.get("compatibilidadAsistente"),
                        ((boolean) datos.get("TienePantalla")),
                        (String) datos.get("EntradaSalida"),
                        ((boolean) datos.get("esInalambrico")),
                        (String) datos.get("RangoConexion"),
                        ((boolean) datos.get("RequiereHub"))
                );
                return ia;
            } else {
                System.out.println("No se encontro el Asistente de casa.");
                return null;
            }

        } catch (Exception e) {
            System.err.println("Error en la busqueda: " + e.getMessage());
            return null;

        }
    }

}
