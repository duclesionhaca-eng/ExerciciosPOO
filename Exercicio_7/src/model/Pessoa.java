package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String email;
    private String telefone;
    
    public Pessoa(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    
    // Getters
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    
    @Override
    public String toString() {
        return "Pessoa: " + nome + " - " + email + " - " + telefone;
    }
}