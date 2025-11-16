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

        try {
            CollectionReference personas = Conexion_Base.db.collection("Computadora");
            ApiFuture<QuerySnapshot> querySnap = personas.get();

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
                    document.get("Garantia").toString(),});

            }

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error: " + e.getMessage());
        }
        table.setModel(model);

    }

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
