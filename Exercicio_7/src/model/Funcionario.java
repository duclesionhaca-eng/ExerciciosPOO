package model;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String cargo;
    private double salario;
    
    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }
    
    // Getters
    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public double getSalario() { return salario; }
    
    @Override
    public String toString() {
        return "Funcionário: " + nome + " - " + cargo + " - " + String.format("%.2f", salario) + " MT";
    }
}