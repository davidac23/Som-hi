package com.example.enriccamarero.somhifirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    //Add reference to FirebaseAuth
    private FirebaseAuth mAuth;

    //Constantment mira si l'user està connectat
    private FirebaseAuth.AuthStateListener authStateListener;

    //Camps
    private EditText    emailText,
                        passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Id als camps
        emailText       = findViewById(R.id.userEmail);
        passwordText    = findViewById(R.id.userPassword);


        mAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //Start a new activity when you are logged
                if(firebaseAuth.getCurrentUser()!=null){

                    //Portar a activitat següent un cop loggejat

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);


                }

            }
        };

    }


    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(authStateListener);

    }

    public void loginButtonClicked(View view) {

        String email    = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){

            Toast.makeText(this, "Introdueix els dos valors!", Toast.LENGTH_LONG).show();

        }else{

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                //S'executa al final del procés de registre
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(!task.isSuccessful()){

                        Toast.makeText(MainActivity.this, "Valors incorrectes", Toast.LENGTH_LONG).show();

                    }

                }
            });

        }

    }

    public void socialLoginClicked(View view) {

        Intent intent = new Intent(MainActivity.this, SocialLogin.class);
        startActivity(intent);

    }

    public void signUpClicked(View view) {


        String email    = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){

            Toast.makeText(this, "Introdueix els dos valors!", Toast.LENGTH_LONG).show();

        }else{

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(!task.isSuccessful()){

                            Toast.makeText(MainActivity.this, "Valors incorrectes", Toast.LENGTH_LONG).show();

                        }else{

                            Toast.makeText(MainActivity.this, "Nou Usuari Correcte", Toast.LENGTH_LONG).show();

                        }

                }
            });

        }

    }
}
