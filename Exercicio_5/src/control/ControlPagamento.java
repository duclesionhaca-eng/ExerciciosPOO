package control;

import java.util.ArrayList;
import model.Pagavel;

public class ControlPagamento {
    private ArrayList<Pagavel> pagaveis;
    private static final String ARQUIVO_PAGAMENTOS = "pagamentos.dat";

    public ControlPagamento() {
        this.pagaveis = Dados.carregarDoArquivo(ARQUIVO_PAGAMENTOS);
    }

    public void cadastrarPagavel(Pagavel pagavel) {
        pagaveis.add(pagavel);
        salvarDados();
    }

    public ArrayList<Pagavel> getPagaveis() {
        return pagaveis;
    }

    public int getQuantidadePagaveis() {
        return pagaveis.size();
    }

    public void salvarDados() {
        Dados.gravarEmArquivo(pagaveis, ARQUIVO_PAGAMENTOS);
    }

    public void carregarDados() {
        this.pagaveis = Dados.carregarDoArquivo(ARQUIVO_PAGAMENTOS);
    }

    // Método que usa POLIMORFISMO para calcular todos os pagamentos
    public double calcularTotalPagamentos() {
        double total = 0.0;
        for (Pagavel pagavel : pagaveis) {
            total += pagavel.calcularPagamento(); // Polimorfismo!
        }
        return total;
    }

    // Método recursivo para calcular total
    public double calcularTotalRecursivo(int index) {
        if (index >= pagaveis.size()) {
            return 0.0;
        }
        
        double pagamentoAtual = pagaveis.get(index).calcularPagamento();
        return pagamentoAtual + calcularTotalRecursivo(index + 1);
    }

    // Contar por tipo usando polimorfismo
    public int contarPorTipo(String tipo) {
        int count = 0;
        for (Pagavel pagavel : pagaveis) {
            if (pagavel.getTipo().equals(tipo)) {
                count++;
            }
        }
        return count;
    }
}