package com.example.halyson.imc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);


        Intent it = getIntent();
        String nome, telefone, email, peso, altura;

        if (it != null) {

            Bundle params = it.getExtras();
            if (params != null) {

                nome = params.getString("nome");
                telefone = params.getString("telefone");
                email = params.getString("email");
                peso = params.getString("peso");
                altura = params.getString("altura");


                TextView actNome = (TextView) findViewById(R.id.nome);
                TextView actTelefone = (TextView) findViewById(R.id.telefone);
                TextView actEmail = (TextView) findViewById(R.id.email);
                TextView actPeso = (TextView) findViewById(R.id.peso);
                TextView actAltura = (TextView) findViewById(R.id.altura);

                actNome.setText(nome);
                actTelefone.setText(telefone);
                actEmail.setText(email);
                actPeso.setText(peso);
                actAltura.setText(altura);
            }

        }
    }


    public void calcularIMC(View v){

            TextView actNome = (TextView) findViewById(R.id.nome);
            TextView actPeso = (TextView) findViewById(R.id.peso);
            TextView actAltura = (TextView) findViewById(R.id.altura);

            String nome = actNome.getText().toString();
            double peso = Double.parseDouble(actPeso.getText().toString());
            double altura = Double.parseDouble(actAltura.getText().toString());

            double imc = peso / (altura * altura);

            Intent it = new Intent();
            Bundle dados = new Bundle();

            dados.putString("imc", String.valueOf(imc));
            dados.putString("nome", String.valueOf(nome));

            it.putExtras(dados);

            setResult(1, it);
            finish();


    }


}