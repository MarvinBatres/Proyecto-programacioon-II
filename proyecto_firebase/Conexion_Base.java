package com.mycompany.proyecto_firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Conexion_Base {

    public static Firestore db;

    public static void conectarFirebase() {
        try {
            FileInputStream services = new FileInputStream("proyecto-progra.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(services))
                    .build();

            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
            System.out.println("Conexión a Firebase exitosa. ");

        } catch (IOException e) {
                            System.out.println("Error: " + e.getMessage());

        }

    }
}
