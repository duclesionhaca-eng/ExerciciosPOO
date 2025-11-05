package model;

import java.io.Serializable;

/**
 * Classe base para todas as pessoas do sistema acadêmico
 * Contém informações básicas comuns a alunos e professores
 */
public abstract class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;
    private String email;
    private String telefone;
    
    /**
     * Construtor da classe Pessoa
     * @param nome Nome completo da pessoa
     * @param idade Idade da pessoa
     * @param email Email de contacto
     * @param telefone Número de telefone
     */
    public Pessoa(String nome, int idade, String email, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
    }
    
    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    
    /**
     * Método abstrato para obter o tipo de pessoa
     * @return String com o tipo (Aluno, Professor, etc.)
     */
    public abstract String getTipo();
    
    @Override
    public String toString() {
        return nome + " (" + idade + " anos) - " + email;
    }
}