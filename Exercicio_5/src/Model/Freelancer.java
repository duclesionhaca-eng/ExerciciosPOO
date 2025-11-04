package model;

import java.io.Serializable;

public class Freelancer implements Pagavel, Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private double valorHora;
    private int horasTrabalhadas;
    
    public Freelancer(String nome, double valorHora, int horasTrabalhadas) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    @Override
    public double calcularPagamento() {
        return valorHora * horasTrabalhadas; // Pagamento em MT
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public String getTipo() {
        return "Freelancer";
    }
    
    // Getters e Setters
    public double getValorHora() { return valorHora; }
    public void setValorHora(double valorHora) { this.valorHora = valorHora; }
    
    public int getHorasTrabalhadas() { return horasTrabalhadas; }
    public void setHorasTrabalhadas(int horasTrabalhadas) { this.horasTrabalhadas = horasTrabalhadas; }
    
    @Override
    public String toString() {
        return "Freelancer: " + nome + " - " + horasTrabalhadas + "h @ " + 
               String.format("%.2f", valorHora) + " MT/h = " + 
               String.format("%.2f", calcularPagamento()) + " MT";
    }
}