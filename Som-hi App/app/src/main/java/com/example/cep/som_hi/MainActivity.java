package com.example.cep.som_hi;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);



		Button btnMain = (Button) findViewById(R.id.btnMain);
		final EditText editNom = (EditText) findViewById(R.id.EditNomUsuari);

		//String password = "";


		btnMain.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String nom = editNom.getText().toString();
				Intent intent =
						new Intent(MainActivity.this, Logged.class);
				intent.putExtra("nom", nom);
				startActivity(intent);
			}
		});
	}
}
