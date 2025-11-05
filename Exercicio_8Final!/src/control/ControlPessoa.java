package control;

import java.util.ArrayList;
import model.Pessoa;

/**
 * Controlador base para operações com pessoas
 * Contém métodos comuns a alunos e professores
 */
public class ControlPessoa {
    protected ArrayList<Pessoa> pessoas;
    private String arquivoDados;
    
    /**
     * Construtor do controlador
     * @param arquivoDados Nome do arquivo para persistência
     */
    public ControlPessoa(String arquivoDados) {
        this.arquivoDados = arquivoDados;
        this.pessoas = Dados.carregarDoArquivo(arquivoDados);
    }
    
    /**
     * Adiciona uma pessoa à lista e salva automaticamente
     * @param pessoa Pessoa a ser adicionada
     */
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        salvarDados();
        System.out.println("✅ " + pessoa.getTipo() + " adicionado: " + pessoa.getNome());
    }
    
    /**
     * Remove uma pessoa da lista pelo índice
     * @param index Índice da pessoa a remover
     * @return true se removido com sucesso, false caso contrário
     */
    public boolean removerPessoa(int index) {
        if (index >= 0 && index < pessoas.size()) {
            Pessoa removida = pessoas.remove(index);
            salvarDados();
            System.out.println("✅ Pessoa removida: " + removida.getNome());
            return true;
        }
        return false;
    }
    
    /**
     * Retorna todas as pessoas
     * @return ArrayList com todas as pessoas
     */
    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
    
    /**
     * Retorna o número total de pessoas
     * @return Quantidade de pessoas
     */
    public int getQuantidadePessoas() {
        return pessoas.size();
    }
    
    /**
     * Salva os dados no arquivo
     */
    public void salvarDados() {
        Dados.gravarEmArquivo(pessoas, arquivoDados);
    }
    
    /**
     * Recarrega os dados do arquivo
     */
    public void carregarDados() {
        this.pessoas = Dados.carregarDoArquivo(arquivoDados);
    }
    
    /**
     * Busca pessoa pelo nome
     * @param nome Nome a buscar
     * @return Pessoa encontrada ou null se não encontrar
     */
    public Pessoa buscarPorNome(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                return pessoa;
            }
        }
        return null;
    }
}