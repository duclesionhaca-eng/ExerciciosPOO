package model;

import java.io.Serializable;

public class ContaCorrente implements Conta, Serializable {
    private static final long serialVersionUID = 1L;
    private String numeroConta;
    private String titular;
    private double saldo;
    private double taxaFixa = 50.0; // Taxa fixa de 50 MT
    
    public ContaCorrente(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }
    
    @Override
    public double calcularTaxa() {
        return taxaFixa; // Taxa fixa
    }
    
    @Override
    public String getNumeroConta() { return numeroConta; }
    
    @Override
    public String getTitular() { return titular; }
    
    @Override
    public double getSaldo() { return saldo; }
    
    @Override
    public String getTipo() { return "Conta Corrente"; }
    
    public String toString() {
        return "CC: " + titular + " - Saldo: " + String.format("%.2f", saldo) + " MT";
    }
}