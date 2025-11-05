package control;

import java.util.ArrayList;
import model.Aluno;
import model.Bolseiro;
import model.NaoBolseiro;
import model.Pessoa;

/**
 * Controlador específico para operações com alunos
 * Gerencia alunos bolseiros e não-bolseiros
 */
public class ControlAluno extends ControlPessoa {
    
    /**
     * Construtor do controlador de alunos
     */
    public ControlAluno() {
        super("alunos.dat");
    }
    
    /**
     * Adiciona um aluno bolseiro
     * @param nome Nome do aluno
     * @param idade Idade do aluno
     * @param email Email do aluno
     * @param telefone Telefone do aluno
     * @param matricula Número de matrícula
     * @param curso Curso do aluno
     * @param mensalidade Valor da mensalidade
     */
    public void adicionarBolseiro(String nome, int idade, String email, String telefone,
                                  String matricula, String curso, double mensalidade) {
        Bolseiro bolseiro = new Bolseiro(nome, idade, email, telefone, matricula, curso, mensalidade);
        adicionarPessoa(bolseiro);
    }
    
    /**
     * Adiciona um aluno não-bolseiro
     * @param nome Nome do aluno
     * @param idade Idade do aluno
     * @param email Email do aluno
     * @param telefone Telefone do aluno
     * @param matricula Número de matrícula
     * @param curso Curso do aluno
     * @param mensalidade Valor da mensalidade
     */
    public void adicionarNaoBolseiro(String nome, int idade, String email, String telefone,
                                     String matricula, String curso, double mensalidade) {
        NaoBolseiro naoBolseiro = new NaoBolseiro(nome, idade, email, telefone, matricula, curso, mensalidade);
        adicionarPessoa(naoBolseiro);
    }
    
    /**
     * Retorna apenas os alunos (filtra da lista de pessoas)
     * @return ArrayList apenas com alunos
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Aluno> getAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Aluno) {
                alunos.add((Aluno) pessoa);
            }
        }
        return alunos;
    }
    
    /**
     * Atualiza a nota final de um aluno
     * @param index Índice do aluno
     * @param nota Nova nota final
     * @return true se atualizado com sucesso, false caso contrário
     */
    public boolean atualizarNota(int index, double nota) {
        ArrayList<Aluno> alunos = getAlunos();
        if (index >= 0 && index < alunos.size()) {
            alunos.get(index).setNotaFinal(nota);
            salvarDados();
            return true;
        }
        return false;
    }
    
    /**
     * Calcula o total de mensalidades a receber
     * @return Soma de todas as mensalidades
     */
    public double calcularTotalMensalidades() {
        double total = 0;
        for (Aluno aluno : getAlunos()) {
            total += aluno.calcularMensalidade();
        }
        return total;
    }
    
    /**
     * Conta alunos aprovados
     * @return Número de alunos aprovados
     */
    public int contarAprovados() {
        int count = 0;
        for (Aluno aluno : getAlunos()) {
            if (aluno.isAprovado()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Conta alunos dispensados
     * @return Número de alunos dispensados
     */
    public int contarDispensados() {
        int count = 0;
        for (Aluno aluno : getAlunos()) {
            if (aluno.isDispensado()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Conta alunos bolseiros
     * @return Número de alunos bolseiros
     */
    public int contarBolseiros() {
        int count = 0;
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Bolseiro) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Conta alunos não-bolseiros
     */
    public int contarNaoBolseiros() {
        int count = 0;
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof NaoBolseiro) {
                count++;
            }
        }
        return count;
    }
}