package com.example.cep.som_hi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Logged extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logged);

		Intent intent = getIntent();
		String nom = intent.getStringExtra("nom");
		TextView txtNom = (TextView) findViewById(R.id.TxtNomUsuari);
		txtNom.setText(nom);
	}
}
