package control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Gato;

public class Dados {
    // Grava uma ArrayList em arquivo

    public static void gravarEmArquivo(ArrayList<Gato> lista, String listaGatos) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(listaGatos))) {
            outputStream.writeObject(lista);
            System.out.println("ArrayList gravada em arquivo: " + listaGatos);
        } catch (IOException e) {
            System.out.println("Erro ao gravar em arquivo: " + e);
        }

    }

    // Carrega uma ArrayList de um arquivo
    @SuppressWarnings("unchecked")
    public static <Gatos> ArrayList<Gatos> carregarDoArquivo(String listaGatos) {
        // Verifica se o arquivo existe
        if (!new java.io.File(listaGatos).exists()) {
            System.out.println("Arquivo não encontrado: " + listaGatos);
            return (ArrayList<Gatos>) new ArrayList<Gato>();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(listaGatos))) {
            ArrayList<Gatos> lista = (ArrayList<Gatos>) inputStream.readObject();
            System.out.println("ArrayList carregada do arquivo: " + listaGatos);
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar do arquivo: " + e);
            return (ArrayList<Gatos>) new ArrayList<Gato>();
        }
    }

}
