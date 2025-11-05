package model;

import java.io.Serializable;

/**
 * Classe que representa alunos não-bolseiros
 * Tem regras específicas para dispensa e mensalidade
 */
public class NaoBolseiro extends Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Construtor do aluno não-bolseiro
     */
    public NaoBolseiro(String nome, int idade, String email, String telefone, 
                       String matricula, String curso, double mensalidade) {
        super(nome, idade, email, telefone, matricula, curso, mensalidade);
    }
    
    /**
     * Não-bolseiro é dispensado academicamente se nota final >= 14
     * @return true se nota >= 14, false caso contrário
     */
    @Override
    public boolean isDispensado() {
        return getNotaFinal() >= 14;
    }
    
    /**
     * Não-bolseiros pagam mensalidade completa sempre
     * Mesmo que estejam academicamente dispensados
     * @return Valor completo da mensalidade
     */
    @Override
    public double calcularMensalidade() {
        return getMensalidade(); // Sempre paga completo
    }
    
    @Override
    public String getTipo() {
        return "Aluno Não-Bolseiro";
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Não-Bolseiro] - Nota: " + getNotaFinal() + 
               " - Dispensado: " + (isDispensado() ? "Sim" : "Não") +
               " - Mensalidade: " + String.format("%.2f", calcularMensalidade()) + " MT";
    }
}