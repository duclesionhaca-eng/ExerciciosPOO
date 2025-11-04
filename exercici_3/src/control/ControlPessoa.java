package control;

import java.util.ArrayList;
import model.Pessoa;
import model.Aluno;

public class ControlPessoa {
    private ArrayList<Pessoa> pessoas;
    private static final String ARQUIVO_PESSOAS = "pessoas_alunos.dat";

    public ControlPessoa() {
        this.pessoas = Dados.carregarDoArquivo(ARQUIVO_PESSOAS);
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        salvarDados(); // Salva automaticamente
    }

    public void cadastrarAluno(Aluno aluno) {
        pessoas.add(aluno); // Polimorfismo: Aluno é uma Pessoa
        salvarDados(); // Salva automaticamente
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public int getQuantidadePessoas() {
        return pessoas.size();
    }

    public void salvarDados() {
        Dados.gravarEmArquivo(pessoas, ARQUIVO_PESSOAS);
    }

    public void carregarDados() {
        this.pessoas = Dados.carregarDoArquivo(ARQUIVO_PESSOAS);
    }

    public boolean removerPessoa(int index) {
        if (index >= 0 && index < pessoas.size()) {
            pessoas.remove(index);
            salvarDados(); // Salva automaticamente após remover
            return true;
        }
        return false;
    }
}