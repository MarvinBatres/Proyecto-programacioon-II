package com.mycompany.proyecto_firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Maneja la conexión a Firebase Firestore usando el patrón Singleton.
 * Es encargada de inicializar la aplicación Firebase y proporcionar acceso a Firestore.  
 * 
 */
public class Conexion_Base {

    
    private static boolean conectado = false;
    public static Firestore db;

    /**
     *conectado: Indica si ya se estableció conexión con Firebase
     *db: Instancia de Firestore para operaciones con la base de datos

     */
   
    
    
    public static void conectarFirebase() {
        
        if(conectado){
            System.out.println("Firebase ya está Conectado.");
            return;
        }
            
        try {
            FileInputStream services = new FileInputStream("proyecto-progra.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(services))
                    .build();

            if(FirebaseApp.getApps().isEmpty()){
                FirebaseApp.initializeApp(options);
            }
            
            db = FirestoreClient.getFirestore();
            System.out.println("Conexión a Firebase exitosa. ");

        } catch (IOException e) {
           System.out.println("Error: " + e.getMessage());

        }

    }
     /**
     * Obtiene la instancia de Firestore.
     * Si no está conectado, establece la conexión primero.
     * 
     * @return Instancia de Firestore para operaciones con la base de datos
     */
    
    
    public static Firestore getDb(){
        if(!conectado){
            conectarFirebase();
        }
        return db;
    }
    
    
    
}
