package control;

import java.io.*;
import java.util.ArrayList;

public class Dados {
    
    public static void gravarEmArquivo(ArrayList<?> lista, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(lista);
            System.out.println("Dados salvos em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> carregarDoArquivo(String nomeArquivo) {
        if (!new java.io.File(nomeArquivo).exists()) {
            System.out.println("Arquivo não encontrado. Criando nova lista.");
            return new ArrayList<T>();
        }
        
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            ArrayList<T> lista = (ArrayList<T>) inputStream.readObject();
            System.out.println("Dados carregados de: " + nomeArquivo);
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
            return new ArrayList<T>();
        }
    }
}