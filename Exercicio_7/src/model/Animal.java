package model;

import java.io.Serializable;

public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String tipo;
    private int idade;
    
    public Animal(String nome, String tipo, int idade) {
        this.nome = nome;
        this.tipo = tipo;
        this.idade = idade;
    }
    
    // Getters
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getIdade() { return idade; }
    
    @Override
    public String toString() {
        return "Animal: " + nome + " (" + tipo + ") - " + idade + " anos";
    }
}