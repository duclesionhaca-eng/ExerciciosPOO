package control;

import java.util.ArrayList;
import model.Conta;

public class ControlBanco {
    private ArrayList<Conta> contas;
    private static final String ARQUIVO_CONTAS = "contas.dat";

    public ControlBanco() {
        this.contas = Dados.carregarDoArquivo(ARQUIVO_CONTAS);
    }

    // Método simples para adicionar conta
    public void adicionarConta(Conta conta) {
        contas.add(conta);
        salvarDados();
    }

    // Método simples para obter contas
    public ArrayList<Conta> getContas() {
        return contas;
    }

    // Método simples para contar contas
    public int getTotalContas() {
        return contas.size();
    }

    // Método simples para salvar
    public void salvarDados() {
        Dados.gravarEmArquivo(contas, ARQUIVO_CONTAS);
    }

    // Método simples para carregar
    public void carregarDados() {
        this.contas = Dados.carregarDoArquivo(ARQUIVO_CONTAS);
    }

    // RECURSIVIDADE: Calcular taxas totais
    public double calcularTaxasTotaisRecursivo(int index) {
        // Caso base: quando chegamos ao final
        if (index >= contas.size()) {
            return 0.0;
        }
        
        // Caso recursivo: taxa atual + resto da lista
        double taxaAtual = contas.get(index).calcularTaxa();
        return taxaAtual + calcularTaxasTotaisRecursivo(index + 1);
    }

    // Método simples para remover conta
    public boolean removerConta(int index) {
        if (index >= 0 && index < contas.size()) {
            contas.remove(index);
            salvarDados();
            return true;
        }
        return false;
    }
}