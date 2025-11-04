package model;

import java.io.Serializable;
import java.util.Date;

public class Aluno extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String matricula;
    
    public Aluno(String nome, Date dataNascimento, String matricula) {
        super(nome, dataNascimento);
        this.matricula = matricula;
    }
    
    // Getter e Setter
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    
    @Override
    public String toString() {
        return "Aluno: " + getNome() + " (" + getIdade() + " anos) - Mat: " + matricula;
    }
}