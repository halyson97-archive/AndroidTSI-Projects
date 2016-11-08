package com.example.halyson.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviardados(View v){

        EditText nome = (EditText) findViewById(R.id.nome);
        EditText telefone = (EditText) findViewById(R.id.telefone);
        EditText email = (EditText) findViewById(R.id.email);
        EditText peso = (EditText) findViewById(R.id.peso);
        EditText altura = (EditText) findViewById(R.id.altura);

        int COD_ACTIVITY_1 = 1;
        Intent it = new Intent(MainActivity.this, SegundaTela.class);

        Bundle dados = new Bundle();

        dados.putString("nome", nome.getText().toString());
        dados.putString("telefone", telefone.getText().toString());
        dados.putString("email", email.getText().toString());
        dados.putString("peso", peso.getText().toString());
        dados.putString("altura", altura.getText().toString());

        it.putExtras(dados);


        startActivityForResult(it, COD_ACTIVITY_1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == 1) {

            Bundle params = data.getExtras();
            if (params != null) {

                String imc = params.getString("imc");
                String nome = params.getString("nome");
                String categoria = calcularCategoria(Double.parseDouble(imc), nome);

                Bundle dados = new Bundle();

                dados.putString("imc", imc.toString());
                dados.putString("categoria", categoria.toString());

                Intent it = new Intent(MainActivity.this, TerceiraTela.class);

                it.putExtras(dados);
                startActivity(it);

            }

        }

    }

    public String calcularCategoria(Double imc, String nome){

        if (imc < 16){
            return "O(A) senhor(a) " + nome + " esta no estado de magreza grave! Vai comer caralho!";
        }else if(imc >=16 && imc < 17){
            return "O(A) senhor(a) " + nome + " esta no estado de magreza moderada! Da uma reforçada na alimentação ai pohh!";
        }else if(imc >= 17 && imc < 18.5){
            return "O(A) senhor(a) " + nome + " esta no estado de magreza leve! Cuide-se um poco melhor!";
        }else if(imc >=18.5 && imc < 25){
            return "O(A) senhor(a) " + nome + " esta no estado saudavel! Congrulations! Continue assim!";
        }else if(imc >=25 && imc < 30){
            return "O(A) senhor(a) " + nome + " esta no estado de sobrepeso! Cuide-se um pouco melhor!";
        }else if(imc >=30 && imc < 35){
            return "O(A) senhor(a) " + nome + " esta no estado de obesidade grau I! Come um pouco menos!";
        }else if(imc >=35 && imc < 40){
            return "O(A) senhor(a) " + nome + " esta no estado de obesidade grau II (severa)! Que tal fazer uma dieta? :D!";
        }else if(imc > 40){
            return "O(A) senhor(a) " + nome + " esta no estado de obesidade grau III (morbida)! Melhor procurar um nutricionista :)!";
        }else{
            return "Erro";
        }

    }


}