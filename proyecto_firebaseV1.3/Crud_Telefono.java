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

public class Crud_Telefono {

    CollectionReference reference;
    static Firestore db;

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
