package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Pessoa;
import model.Aluno;
import model.Bolseiro;
import model.NaoBolseiro;
import model.Professor;

/**
 * Controlador para geração de relatórios com recursividade
 */
public class ControlRelatorio {
    private ControlAluno controlAluno;
    private ControlProfessor controlProfessor;
    private SimpleDateFormat dateFormat;
    
    /**
     * Construtor do controlador de relatórios
     */
    public ControlRelatorio() {
        this.controlAluno = new ControlAluno();
        this.controlProfessor = new ControlProfessor();
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
    
    /**
     * Gera relatório completo usando recursividade
     * @param tipo Tipo de relatório ("Alunos", "Professores", "Todos")
     * @return String com o relatório formatado
     */
    public String gerarRelatorioRecursivo(String tipo) {
        StringBuilder relatorio = new StringBuilder();
        
        // Cabeçalho do relatório
        relatorio.append("═".repeat(70)).append("\n");
        relatorio.append("                 SISTEMA ACADÊMICO - FUNDA INC.\n");
        relatorio.append("═".repeat(70)).append("\n");
        relatorio.append("Relatório: ").append(tipo).append("\n");
        relatorio.append("Data: ").append(dateFormat.format(new Date())).append("\n");
        relatorio.append("─".repeat(70)).append("\n\n");
        
        // Conteúdo do relatório com recursividade
        switch (tipo) {
            case "Alunos":
                relatorio.append(gerarRelatorioAlunosRecursivo(0));
                break;
            case "Professores":
                relatorio.append(gerarRelatorioProfessoresRecursivo(0));
                break;
            case "Todos":
                relatorio.append(gerarRelatorioTodosRecursivo(0));
                break;
            case "Financeiro":
                relatorio.append(gerarRelatorioFinanceiro());
                break;
        }
        
        // Rodapé do relatório
        relatorio.append("\n").append("─".repeat(70)).append("\n");
        relatorio.append("Relatório gerado automaticamente com recursividade\n");
        relatorio.append("═".repeat(70));
        
        return relatorio.toString();
    }
    
    /**
     * Gera relatório de alunos usando recursividade
     * @param index Índice atual para recursão
     * @return String com relatório de alunos
     */
    private String gerarRelatorioAlunosRecursivo(int index) {
        ArrayList<Aluno> alunos = controlAluno.getAlunos();
        
        // Caso base: fim da lista
        if (index >= alunos.size()) {
            return "\n📊 ESTATÍSTICAS DOS ALUNOS:\n" +
                   "─".repeat(40) + "\n" +
                   "• Total de Alunos: " + alunos.size() + "\n" +
                   "• Bolseiros: " + controlAluno.contarBolseiros() + "\n" +
                   "• Não-Bolseiros: " + controlAluno.contarNaoBolseiros() + "\n" +
                   "• Aprovados: " + controlAluno.contarAprovados() + "\n" +
                   "• Dispensados: " + controlAluno.contarDispensados() + "\n" +
                   "• Total Mensalidades: " + String.format("%.2f", controlAluno.calcularTotalMensalidades()) + " MT\n";
        }
        
        // Caso recursivo: processa aluno atual e chama próximo
        Aluno aluno = alunos.get(index);
        String linhaAluno = String.format("• %-30s | %-15s | Nota: %-5.1f | Mensalidade: %7.2f MT | %s\n",
            aluno.getNome(),
            aluno.getTipo(),
            aluno.getNotaFinal(),
            aluno.calcularMensalidade(),
            aluno.isAprovado() ? "✅ Aprovado" : "❌ Reprovado");
        
        return linhaAluno + gerarRelatorioAlunosRecursivo(index + 1);
    }
    
    /**
     * Gera relatório de professores usando recursividade
     * @param index Índice atual para recursão
     * @return String com relatório de professores
     */
    private String gerarRelatorioProfessoresRecursivo(int index) {
        ArrayList<Professor> professores = controlProfessor.getProfessores();
        
        // Caso base: fim da lista
        if (index >= professores.size()) {
            return "\n📊 ESTATÍSTICAS DOS PROFESSORES:\n" +
                   "─".repeat(40) + "\n" +
                   "• Total de Professores: " + professores.size() + "\n" +
                   "• Total Salários: " + String.format("%.2f", controlProfessor.calcularTotalSalarios()) + " MT\n";
        }
        
        // Caso recursivo: processa professor atual e chama próximo
        Professor professor = professores.get(index);
        String linhaProfessor = String.format("• %-25s | %-20s | %-15s | Salário: %9.2f MT\n",
            professor.getNome(),
            professor.getDisciplina(),
            professor.getDepartamento(),
            professor.getSalario());
        
        return linhaProfessor + gerarRelatorioProfessoresRecursivo(index + 1);
    }
    
    /**
     * Gera relatório completo com todos os tipos usando recursividade
     * @param tipoIndex Índice do tipo atual (0=Alunos, 1=Professores)
     * @return String com relatório completo
     */
    private String gerarRelatorioTodosRecursivo(int tipoIndex) {
        // Caso base: processou todos os tipos
        if (tipoIndex >= 2) {
            return "";
        }
        
        String secao = "";
        if (tipoIndex == 0) {
            secao = "🎓 RELATÓRIO DE ALUNOS:\n" +
                    "═".repeat(70) + "\n" +
                    gerarRelatorioAlunosRecursivo(0) + "\n\n";
        } else {
            secao = "👨‍🏫 RELATÓRIO DE PROFESSORES:\n" +
                    "═".repeat(70) + "\n" +
                    gerarRelatorioProfessoresRecursivo(0) + "\n";
        }
        
        // Caso recursivo: concatena seção atual e chama próxima
        return secao + gerarRelatorioTodosRecursivo(tipoIndex + 1);
    }
    
    /**
     * Gera relatório financeiro
     * @return String com relatório financeiro
     */
    private String gerarRelatorioFinanceiro() {
        return "💰 RELATÓRIO FINANCEIRO:\n" +
               "═".repeat(70) + "\n" +
               "RECEITAS (Mensalidades):\n" +
               "─".repeat(40) + "\n" +
               "• Total de Mensalidades a Receber: " + 
               String.format("%.2f", controlAluno.calcularTotalMensalidades()) + " MT\n\n" +
               "DESPESAS (Salários):\n" +
               "─".repeat(40) + "\n" +
               "• Total de Salários a Pagar: " + 
               String.format("%.2f", controlProfessor.calcularTotalSalarios()) + " MT\n\n" +
               "BALANÇO:\n" +
               "─".repeat(40) + "\n" +
               "• Saldo: " + 
               String.format("%.2f", (controlAluno.calcularTotalMensalidades() - 
                                     controlProfessor.calcularTotalSalarios())) + " MT\n";
    }
    
    /**
     * Exporta relatório para arquivo .txt
     * @param tipo Tipo de relatório
     * @param nomeArquivo Nome do arquivo de destino
     */
    public void exportarRelatorio(String tipo, String nomeArquivo) {
        String relatorio = gerarRelatorioRecursivo(tipo);
        Dados.exportarParaTxt(relatorio, nomeArquivo);
    }
    
    // Getters para os controladores
    public ControlAluno getControlAluno() { return controlAluno; }
    public ControlProfessor getControlProfessor() { return controlProfessor; }
}
