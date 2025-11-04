package model;

import java.io.Serializable;

public class Funcionario implements Pagavel, Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private double salarioFixo;
    
    public Funcionario(String nome, double salarioFixo) {
        this.nome = nome;
        this.salarioFixo = salarioFixo;
    }
    
    @Override
    public double calcularPagamento() {
        return salarioFixo; // Salário fixo em MT
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public String getTipo() {
        return "Funcionário";
    }
    
    // Getters e Setters
    public double getSalarioFixo() { return salarioFixo; }
    public void setSalarioFixo(double salarioFixo) { this.salarioFixo = salarioFixo; }
    
    @Override
    public String toString() {
        return "Funcionário: " + nome + " - Salário Fixo: " + String.format("%.2f", salarioFixo) + " MT";
    }
}