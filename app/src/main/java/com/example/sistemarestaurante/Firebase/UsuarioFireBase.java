package com.example.sistemarestaurante.Firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsuarioFireBase {
    private FirebaseUser user = ConfiguracaoFirebase.getAuth().getCurrentUser();

}
