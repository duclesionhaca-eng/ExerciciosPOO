package model;

import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private Date dataNascimento;
    
    public Pessoa(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    // Calcula idade baseada na data de nascimento
    public int getIdade() {
        if (dataNascimento == null) return 0;
        
        Date hoje = new Date();
        long diff = hoje.getTime() - dataNascimento.getTime();
        return (int) (diff / (1000L * 60 * 60 * 24 * 365));
    }
    
    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public Date getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }
    
    @Override
    public String toString() {
        return "Pessoa: " + nome + " (" + getIdade() + " anos)";
    }
}