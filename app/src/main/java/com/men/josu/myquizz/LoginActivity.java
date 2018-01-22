package com.men.josu.myquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void enviarDatos(View view){
        EditText edtNombre = (EditText) findViewById(R.id.username);
        String nombre = edtNombre.getText().toString();

        Toast.makeText(getBaseContext(), "Bien venido: " + nombre, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);

    }
}
