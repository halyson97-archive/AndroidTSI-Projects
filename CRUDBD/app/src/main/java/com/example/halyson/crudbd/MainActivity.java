package com.example.halyson.crudbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickListView();
        mostarTodosUsuarios();
    }

    public void chamarCadastro(View v){
        Intent it = new Intent(MainActivity.this, Cadastro.class);
        startActivity(it);
    }

    public void buscarPorNome(View v){
        EditText edtUserBusca = (EditText) findViewById(R.id.nameBuscar);
        String nomeBusca = edtUserBusca.getText().toString();

            UsuarioDAO userDao = new UsuarioDAO(MainActivity.this);

            Usuario user = userDao.getByName(nomeBusca);

            if (user != null) {

                ArrayList<Usuario> nomeUsuarios = new ArrayList<>();

                nomeUsuarios.add(user);
                ArrayAdapter<Usuario> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomeUsuarios);

                ListView lv = (ListView) findViewById(R.id.listaUsuario);
                lv.setAdapter(adapter);
            } else {
                Toast.makeText(this, "Nenhum Registro encontrado!", Toast.LENGTH_SHORT).show();
            }
    }

    public void onClickListView(){
        final ListView list = (ListView) findViewById(R.id.listaUsuario);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Usuario itemValue = (Usuario) list.getItemAtPosition(position);

                Bundle nomeUser = new Bundle();

                nomeUser.putString("nomeUsuario", itemValue.getNome());
                Intent it = new Intent(MainActivity.this, ResultadoBusca.class);
                it.putExtras(nomeUser);
                startActivity(it);

            }
        });
    }

    public void mostarTodosUsuarios() {
        UsuarioDAO daoUsuario = new UsuarioDAO(MainActivity.this);

        ArrayList<Usuario> listUser = (ArrayList<Usuario>) daoUsuario.getAllUsers();

        ArrayAdapter<Usuario> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listUser);

        ListView lv = (ListView) findViewById(R.id.listaUsuario);
        lv.setAdapter(adapter);

    }
}