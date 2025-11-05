package control;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe utilitária para operações de leitura e escrita em arquivos
 * Implementa serialização de objetos para persistência
 */
public class Dados {
    
    /**
     * Grava uma lista de objetos em arquivo binário
     * @param lista Lista de objetos a serem salvos
     * @param nomeArquivo Nome do arquivo de destino
     */
    public static void gravarEmArquivo(ArrayList<?> lista, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(lista);
            System.out.println("✅ Dados salvos em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar: " + e.getMessage());
        }
    }

    /**
     * Carrega uma lista de objetos de arquivo binário
     * @param <T> Tipo dos objetos na lista
     * @param nomeArquivo Nome do arquivo fonte
     * @return ArrayList com os objetos carregados
     */
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> carregarDoArquivo(String nomeArquivo) {
        // Se arquivo não existe, retorna lista vazia
        if (!new java.io.File(nomeArquivo).exists()) {
            System.out.println("📁 Arquivo não encontrado. Criando nova lista: " + nomeArquivo);
            return new ArrayList<T>();
        }
        
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            ArrayList<T> lista = (ArrayList<T>) inputStream.readObject();
            System.out.println("✅ Dados carregados de: " + nomeArquivo);
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Erro ao carregar: " + e.getMessage());
            return new ArrayList<T>();
        }
    }
    
    /**
     * Exporta conteúdo texto para arquivo .txt
     * @param conteudo Texto a ser exportado
     * @param nomeArquivo Nome do arquivo de destino
     */
    public static void exportarParaTxt(String conteudo, String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo);
            System.out.println("✅ Relatório exportado para: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("❌ Erro ao exportar: " + e.getMessage());
        }
    }
}