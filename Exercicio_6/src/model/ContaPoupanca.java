package model;

import java.io.Serializable;

public class ContaPoupanca implements Conta, Serializable {
    private static final long serialVersionUID = 1L;
    private String numeroConta;
    private String titular;
    private double saldo;
    private double taxaPercentual = 0.02; // 2% sobre saldo
    
    public ContaPoupanca(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }
    
    @Override
    public double calcularTaxa() {
        return saldo * taxaPercentual; // 2% do saldo
    }
    
    @Override
    public String getNumeroConta() { return numeroConta; }
    
    @Override
    public String getTitular() { return titular; }
    
    @Override
    public double getSaldo() { return saldo; }
    
    @Override
    public String getTipo() { return "Conta Poupança"; }
    
    public String toString() {
        return "CP: " + titular + " - Saldo: " + String.format("%.2f", saldo) + " MT";
    }
}