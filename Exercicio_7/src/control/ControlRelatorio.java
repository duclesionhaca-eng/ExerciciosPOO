package control;

import java.util.ArrayList;
import model.Animal;
import model.Pessoa;
import model.Funcionario;

public class ControlRelatorio {
    private ArrayList<Animal> animais;
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Funcionario> funcionarios;
    
    public ControlRelatorio() {
        // Carrega os dados dos arquivos
        this.animais = Dados.carregarDoArquivo("animais.dat");
        this.pessoas = Dados.carregarDoArquivo("pessoas.dat");
        this.funcionarios = Dados.carregarDoArquivo("funcionarios.dat");
    }
    
    // Método recursivo para gerar relatório por tipo
    public String gerarRelatorioRecursivo(String tipo, int index) {
        StringBuilder relatorio = new StringBuilder();
        
        switch (tipo) {
            case "Animais":
                if (index >= animais.size()) return "";
                Animal animal = animais.get(index);
                relatorio.append("• ").append(animal.toString()).append("\n");
                relatorio.append(gerarRelatorioRecursivo(tipo, index + 1));
                break;
                
            case "Pessoas":
                if (index >= pessoas.size()) return "";
                Pessoa pessoa = pessoas.get(index);
                relatorio.append("• ").append(pessoa.toString()).append("\n");
                relatorio.append(gerarRelatorioRecursivo(tipo, index + 1));
                break;
                
            case "Funcionários":
                if (index >= funcionarios.size()) return "";
                Funcionario func = funcionarios.get(index);
                relatorio.append("• ").append(func.toString()).append("\n");
                relatorio.append(gerarRelatorioRecursivo(tipo, index + 1));
                break;
                
            case "Todos":
                relatorio.append(gerarRelatorioTodos(0));
                break;
        }
        
        return relatorio.toString();
    }
    
    // Recursividade para listar todos os tipos
    private String gerarRelatorioTodos(int tipoIndex) {
        if (tipoIndex >= 3) return ""; // 3 tipos: Animais, Pessoas, Funcionários
        
        String tipo = "";
        int quantidade = 0;
        String conteudo = "";
        
        switch (tipoIndex) {
            case 0:
                tipo = "ANIMAIS";
                quantidade = animais.size();
                conteudo = gerarRelatorioRecursivo("Animais", 0);
                break;
            case 1:
                tipo = "PESSOAS";
                quantidade = pessoas.size();
                conteudo = gerarRelatorioRecursivo("Pessoas", 0);
                break;
            case 2:
                tipo = "FUNCIONÁRIOS";
                quantidade = funcionarios.size();
                conteudo = gerarRelatorioRecursivo("Funcionários", 0);
                break;
        }
        
        String secao = "=== " + tipo + " (" + quantidade + " registros) ===\n" + 
                      conteudo + "\n";
        
        return secao + gerarRelatorioTodos(tipoIndex + 1);
    }
    
    // Métodos para adicionar dados de exemplo
    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
        Dados.gravarEmArquivo(animais, "animais.dat");
    }
    
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        Dados.gravarEmArquivo(pessoas, "pessoas.dat");
    }
    
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        Dados.gravarEmArquivo(funcionarios, "funcionarios.dat");
    }
    
    // Método para exportar relatório
    public void exportarRelatorio(String conteudo, String nomeArquivo) {
        Dados.exportarParaTxt(conteudo, nomeArquivo);
    }
    
    // Getters para quantidade
    public int getQuantidadeAnimais() { return animais.size(); }
    public int getQuantidadePessoas() { return pessoas.size(); }
    public int getQuantidadeFuncionarios() { return funcionarios.size(); }
    public int getQuantidadeTotal() { 
        return animais.size() + pessoas.size() + funcionarios.size(); 
    }
}