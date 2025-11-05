package control;

import java.util.ArrayList;
import model.Pessoa;
import model.Professor;

/**
 * Controlador específico para operações com professores
 */
public class ControlProfessor extends ControlPessoa {
    
    /**
     * Construtor do controlador de professores
     */
    public ControlProfessor() {
        super("professores.dat");
    }
    
    /**
     * Adiciona um professor
     * @param nome Nome do professor
     * @param idade Idade do professor
     * @param email Email do professor
     * @param telefone Telefone do professor
     * @param disciplina Disciplina que leciona
     * @param salario Salário do professor
     * @param departamento Departamento académico
     */
    public void adicionarProfessor(String nome, int idade, String email, String telefone,
                                   String disciplina, double salario, String departamento) {
        Professor professor = new Professor(nome, idade, email, telefone, disciplina, salario, departamento);
        adicionarPessoa(professor);
    }
    
    /**
     * Retorna apenas os professores (filtra da lista de pessoas)
     * @return ArrayList apenas com professores
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Professor> getProfessores() {
        ArrayList<Professor> professores = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Professor) {
                professores.add((Professor) pessoa);
            }
        }
        return professores;
    }
    
    /**
     * Calcula o total de salários a pagar
     * @return Soma de todos os salários
     */
    public double calcularTotalSalarios() {
        double total = 0;
        for (Professor professor : getProfessores()) {
            total += professor.getSalario();
        }
        return total;
    }
    
    /**
     * Busca professores por disciplina
     * @param disciplina Disciplina a buscar
     * @return Lista de professores da disciplina
     */
    public ArrayList<Professor> buscarPorDisciplina(String disciplina) {
        ArrayList<Professor> resultado = new ArrayList<>();
        for (Professor professor : getProfessores()) {
            if (professor.getDisciplina().equalsIgnoreCase(disciplina)) {
                resultado.add(professor);
            }
        }
        return resultado;
    }
    
    /**
     * Busca professores por departamento
     * @param departamento Departamento a buscar
     * @return Lista de professores do departamento
     */
    public ArrayList<Professor> buscarPorDepartamento(String departamento) {
        ArrayList<Professor> resultado = new ArrayList<>();
        for (Professor professor : getProfessores()) {
            if (professor.getDepartamento().equalsIgnoreCase(departamento)) {
                resultado.add(professor);
            }
        }
        return resultado;
    }
}