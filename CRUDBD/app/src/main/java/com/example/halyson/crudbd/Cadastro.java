package com.example.halyson.crudbd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrar(View v) {

        EditText etName = (EditText) findViewById(R.id.nameBuscar);
        EditText etSenha = (EditText) findViewById(R.id.pass);
        EditText etTelefone = (EditText) findViewById(R.id.telefone);
        EditText etDataNascimento = (EditText) findViewById(R.id.dataNasc);
        EditText etCPF = (EditText) findViewById(R.id.cpf);

        String nome = etName.getText().toString();
        String senha = etSenha.getText().toString();
        String telefone = etTelefone.getText().toString();
        String cpf = etCPF.getText().toString();
        String dataNascimento = etDataNascimento.getText().toString();

        Usuario usuario = new Usuario(nome, senha, cpf, telefone, dataNascimento);

        UsuarioDAO daoUsuario = new UsuarioDAO(Cadastro.this);

        int cadastro = daoUsuario.inserirUser(usuario);

        Context contexto = getApplicationContext();

        int duracao = Toast.LENGTH_SHORT;

        if (cadastro == 1) {
            String texto = "Deu bão o cadastro";
            Toast.makeText(contexto, texto, duracao).show();
            Intent it = new Intent(Cadastro.this, MainActivity.class);
            startActivity(it);
        } else {
            String texto = "Deu ruim o cadastro";
            Toast.makeText(contexto, texto, duracao).show();
        }
    }
    }
