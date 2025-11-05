package model;

import java.io.Serializable;

/**
 * Classe abstrata para representar alunos do sistema
 * Define comportamentos comuns a todos os tipos de alunos
 */
public abstract class Aluno extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String matricula;
    private String curso;
    private double notaFinal;
    private double mensalidade;
    
    /**
     * Construtor da classe Aluno
     * @param nome Nome do aluno
     * @param idade Idade do aluno
     * @param email Email do aluno
     * @param telefone Telefone do aluno
     * @param matricula Número de matrícula
     * @param curso Curso do aluno
     * @param mensalidade Valor da mensalidade
     */
    public Aluno(String nome, int idade, String email, String telefone, 
                 String matricula, String curso, double mensalidade) {
        super(nome, idade, email, telefone);
        this.matricula = matricula;
        this.curso = curso;
        this.mensalidade = mensalidade;
        this.notaFinal = 0.0; // Nota inicial zero
    }
    
    // Getters e Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    
    public double getNotaFinal() { return notaFinal; }
    public void setNotaFinal(double notaFinal) { this.notaFinal = notaFinal; }
    
    public double getMensalidade() { return mensalidade; }
    public void setMensalidade(double mensalidade) { this.mensalidade = mensalidade; }
    
    /**
     * Verifica se o aluno está academicamente dispensado
     * @return true se está dispensado, false caso contrário
     */
    public abstract boolean isDispensado();
    
    /**
     * Calcula o valor da mensalidade a pagar
     * @return Valor da mensalidade após descontos
     */
    public abstract double calcularMensalidade();
    
    /**
     * Verifica se o aluno está aprovado
     * @return true se nota >= 10, false caso contrário
     */
    public boolean isAprovado() {
        return notaFinal >= 10;
    }
    
    @Override
    public String getTipo() {
        return "Aluno";
    }
    
    @Override
    public String toString() {
        return getTipo() + ": " + getNome() + " - " + curso + " - Mat: " + matricula;
    }
}