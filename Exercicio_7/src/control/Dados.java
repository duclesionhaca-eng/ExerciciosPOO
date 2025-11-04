package control;

import java.io.*;
import java.util.ArrayList;

public class Dados {
    
    public static void gravarEmArquivo(ArrayList<?> lista, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> carregarDoArquivo(String nomeArquivo) {
        if (!new java.io.File(nomeArquivo).exists()) {
            return new ArrayList<T>();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (ArrayList<T>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<T>();
        }
    }
    
    // Método para exportar texto para arquivo .txt
    public static void exportarParaTxt(String conteudo, String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo);
            System.out.println("Relatório exportado para: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao exportar: " + e.getMessage());
        }
    }
}
