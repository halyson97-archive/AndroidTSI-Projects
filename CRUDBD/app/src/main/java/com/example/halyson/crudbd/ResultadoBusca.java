package com.example.halyson.crudbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoBusca extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_busca);

        Intent it = getIntent();

        try{
            if (it != null) {

                Bundle param = it.getExtras();

                if (param != null){

                    String name = param.get("nomeUsuario").toString();

                    UsuarioDAO userDao = new UsuarioDAO(ResultadoBusca.this);
                    user = userDao.getByName(name);

                    TextView idBusca = (TextView) findViewById(R.id.idBusca);
                    EditText nomeBusca = (EditText) findViewById(R.id.nomeBusca);
                    EditText passBusca = (EditText) findViewById(R.id.passBusca);
                    EditText telefoneBusca = (EditText) findViewById(R.id.telefoneBusca);
                    EditText dataBusca = (EditText) findViewById(R.id.nascimentoBusca);
                    EditText cpfBusca = (EditText) findViewById(R.id.cpfBusca);

                    idBusca.setText(String.valueOf(user.getId()));
                    nomeBusca.setText(user.getNome());
                    passBusca.setText(user.getSenha());
                    telefoneBusca.setText(user.getTelefone());
                    dataBusca.setText(user.getDataNascimento());
                    cpfBusca.setText(user.getCpf());
                }

            }
        }catch (Exception e){
            Toast.makeText(this, "Nenhum Registro encontrado", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void deletarUsuario(View v){
        UsuarioDAO userDao = new UsuarioDAO(ResultadoBusca.this);
        int statusDeletar = userDao.deleteUser(user.getId());
        if (statusDeletar == 1){
            Toast.makeText(this, "Usuario deletado com sucesso", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(ResultadoBusca.this, MainActivity.class);
            startActivity(it);
        } else {
            Toast.makeText(this, "Deu ruim pra apagar o usuario", Toast.LENGTH_SHORT).show();
        }

    }

    public void alterarUsuario(View v){

        TextView novoNome = (TextView) findViewById(R.id.nomeBusca);
        TextView novoPass = (TextView) findViewById(R.id.passBusca);
        TextView novoCpf = (TextView) findViewById(R.id.cpfBusca);
        TextView novoTelefone = (TextView) findViewById(R.id.telefoneBusca);
        TextView novoDataNasc = (TextView) findViewById(R.id.nascimentoBusca);

        user.setNome(novoNome.getText().toString());
        user.setSenha(novoPass.getText().toString());
        user.setCpf(novoCpf.getText().toString());
        user.setTelefone(novoTelefone.getText().toString());
        user.setDataNascimento(novoDataNasc.getText().toString());

        UsuarioDAO userDao = new UsuarioDAO(ResultadoBusca.this);

        int statusAlterar = userDao.updateUser(user.getId(), user.getNome(), user.getSenha(), user.getCpf(), user.getTelefone(), user.getDataNascimento());

        if(statusAlterar == 1){
            Toast.makeText(this, "Usuario Alterado Com Sucesso", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(ResultadoBusca.this, MainActivity.class);
            startActivity(it);
        } else {
            Toast.makeText(this, "Deu ruim pra alterar", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    public void sair(View v){
        Intent it = new Intent(ResultadoBusca.this, MainActivity.class);
        startActivity(it);
    }
}