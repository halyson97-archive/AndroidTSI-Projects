package com.example.halyson.crudbd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private OpenDB conexao;

    public UsuarioDAO(Context ctx) {

        this.conexao = new OpenDB(ctx);
    }

    public int inserirUser(Usuario usuario){

        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nome", usuario.getNome());
            valores.put("senha", usuario.getSenha());
            valores.put("cpf", usuario.getCpf());
            valores.put("telefone", usuario.getTelefone());
            valores.put("dataNascimento", usuario.getDataNascimento());

            db.insert("users", null, valores);
            db.close();

            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    public List<Usuario> getAllUsers(){
        SQLiteDatabase db = conexao.getReadableDatabase();
        Cursor cursor = db.query("users", new String[]{}, null, null, null, null, null);

        String nome, senha, cpf, telefone, dataNascimento;
        int id;

        List<Usuario> listaUsuario = new ArrayList<Usuario>();

        while (cursor.moveToNext()) {

            id = cursor.getInt(cursor.getColumnIndex("id"));
            nome = cursor.getString(cursor.getColumnIndex("nome"));
            senha = cursor.getString(cursor.getColumnIndex("senha"));
            cpf = cursor.getString(cursor.getColumnIndex("cpf"));
            telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            dataNascimento = cursor.getString(cursor.getColumnIndex("dataNascimento"));

            Usuario user = new Usuario(id, nome, senha, cpf, telefone, dataNascimento);

            listaUsuario.add(user);
        }

        db.close();

        return listaUsuario;

    }

    public Usuario getByName(String dnome){
        SQLiteDatabase db = conexao.getReadableDatabase();
        String whereClause = "nome = ?";
        String[] whereArgs = new String[] {dnome};
        Cursor cursor = db.query("users", new String[]{}, whereClause, whereArgs, null, null, null);
        String nome, senha, cpf, telefone, dataNascimento;
        int id;
        Usuario user = null;
        try {
            while (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));
                nome = cursor.getString(cursor.getColumnIndex("nome"));
                senha = cursor.getString(cursor.getColumnIndex("senha"));
                cpf = cursor.getString(cursor.getColumnIndex("cpf"));
                telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                dataNascimento = cursor.getString(cursor.getColumnIndex("dataNascimento"));

                user = new Usuario(id, nome, senha, cpf, telefone, dataNascimento);
                db.close();

                return user;
            }
        }catch (Exception e ){

        }
        return user;

    }

    public Usuario getByID(String did){
        SQLiteDatabase db = conexao.getReadableDatabase();
        String whereClause = "id = ?";
        String[] whereArgs = new String[] {did};
        Cursor cursor = db.query("users", new String[]{}, whereClause, whereArgs, null, null, null);
        String nome, senha, cpf, telefone, dataNascimento;
        int id;
        Usuario user = null;
        try {
            while (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));
                nome = cursor.getString(cursor.getColumnIndex("nome"));
                senha = cursor.getString(cursor.getColumnIndex("senha"));
                cpf = cursor.getString(cursor.getColumnIndex("cpf"));
                telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                dataNascimento = cursor.getString(cursor.getColumnIndex("dataNascimento"));

                user = new Usuario(id, nome, senha, cpf, telefone, dataNascimento);
                db.close();

                return user;
            }
        }catch (Exception e ){

        }
        return user;

    }

    public int updateUser(int idUser, String newName, String newSenha, String newCpf, String newDataNasc, String newTelefone){

        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            ContentValues valores = new ContentValues();

            valores.put("nome", newName);
            valores.put("senha", newSenha);
            valores.put("cpf", newCpf);
            valores.put("telefone", newTelefone);
            valores.put("dataNascimento", newDataNasc);

            db.update("users", valores, "id=?", new String[]{String.valueOf(idUser)});
            db.close();
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    public int deleteUser(int idUser){

        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            db.delete("users", "id=?", new String[]{String.valueOf(idUser)});
            db.close();
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

}