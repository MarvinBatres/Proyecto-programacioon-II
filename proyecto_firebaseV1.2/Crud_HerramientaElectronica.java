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

public class Crud_HerramientaElectronica {

    CollectionReference reference;
    static Firestore db;

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

     public static boolean actualizarHer_Elect(String coleccion, String documento,Map<String, Object> data_h) {
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
    
    
    
    
    
    
    
    
    
}
