package model;

import java.io.Serializable;

/**
 * Classe que representa alunos bolseiros
 * Tem regras específicas para dispensa e mensalidade
 */
public class Bolseiro extends Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Construtor do aluno bolseiro
     */
    public Bolseiro(String nome, int idade, String email, String telefone, 
                    String matricula, String curso, double mensalidade) {
        super(nome, idade, email, telefone, matricula, curso, mensalidade);
    }
    
    /**
     * Bolseiro é dispensado apenas se nota final >= 16
     * @return true se nota >= 16, false caso contrário
     */
    @Override
    public boolean isDispensado() {
        return getNotaFinal() >= 16;
    }
    
    /**
     * Calcula mensalidade para bolseiros:
     * - Dispensa total se nota >= 16
     * - Metade da mensalidade se nota < 16
     * @return Valor da mensalidade a pagar
     */
    @Override
    public double calcularMensalidade() {
        if (getNotaFinal() >= 16) {
            return 0.0; // Dispensa total
        } else {
            return getMensalidade() / 2; // Paga metade
        }
    }
    
    @Override
    public String getTipo() {
        return "Aluno Bolseiro";
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Bolseiro] - Nota: " + getNotaFinal() + 
               " - Dispensado: " + (isDispensado() ? "Sim" : "Não") +
               " - Mensalidade: " + String.format("%.2f", calcularMensalidade()) + " MT";
    }
}