package com.example.halyson.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TerceiraTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_tela);

        Intent it = getIntent();
        String imc, categoria;

        if (it != null) {
            Bundle params = it.getExtras();
            if (params != null) {

                imc = params.getString("imc").toString();
                categoria = params.getString("categoria").toString();

                TextView textImc = (TextView) findViewById(R.id.resultadoImc);
                TextView textCategoria = (TextView) findViewById(R.id.resultadoCategoria);

                textImc.setText("Seu imc: " + imc);
                textCategoria.setText(categoria);

            }
        }

    }

    public void calcularNovamente(View view){
        Intent it = new Intent(TerceiraTela.this, MainActivity.class);
        startActivity(it);
    }



}