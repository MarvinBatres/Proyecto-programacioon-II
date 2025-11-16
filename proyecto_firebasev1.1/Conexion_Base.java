package com.mycompany.proyecto_firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


//Patron Singleton
public class Conexion_Base {
    
    private static boolean conectado = false;
    public static Firestore db;

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
    public static Firestore getDb(){
        if(!conectado){
            conectarFirebase();
        }
        return db;
    }
    
    
    
}
