
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



public class Crud_computadora {
    CollectionReference reference;
    static Firestore db;
    
    public static boolean guardarPersona(String coleccion, String documento, Map<String, Object> data){
        db = FirestoreClient.getFirestore();
        try{
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Guardado de datos correctamente en Firebase");
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return false;
    }
    
    
}
