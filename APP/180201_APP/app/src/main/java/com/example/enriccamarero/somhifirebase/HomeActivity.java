package com.example.enriccamarero.somhifirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void signOut(View view) {

        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);


    }
}
