package model;

import java.io.Serializable;

/**
 * Classe que representa professores do sistema acadêmico
 */
public class Professor extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String disciplina;
    private double salario;
    private String departamento;
    
    /**
     * Construtor da classe Professor
     * @param nome Nome do professor
     * @param idade Idade do professor
     * @param email Email do professor
     * @param telefone Telefone do professor
     * @param disciplina Disciplina que leciona
     * @param salario Salário do professor
     * @param departamento Departamento académico
     */
    public Professor(String nome, int idade, String email, String telefone, 
                     String disciplina, double salario, String departamento) {
        super(nome, idade, email, telefone);
        this.disciplina = disciplina;
        this.salario = salario;
        this.departamento = departamento;
    }
    
    // Getters e Setters
    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }
    
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
    
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    
    @Override
    public String getTipo() {
        return "Professor";
    }
    
    @Override
    public String toString() {
        return "Professor: " + getNome() + " - " + disciplina + 
               " - " + departamento + " - Salário: " + 
               String.format("%.2f", salario) + " MT";
    }
}