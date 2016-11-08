package com.example.halyson.crudbd;

public class Usuario {

    private int id;
    private String nome;
    private String senha;
    private String cpf;
    private String telefone;
    private String dataNascimento;

    public Usuario(int id, String nome, String senha, String cpf, String telefone, String dataNascimento){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(String nome, String senha, String cpf, String telefone,String dataNascimento){
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public String toString(){
        return "\nNome: " + this.getNome() + "\nCpf: " + this.getCpf() + "\n";
    }
}
