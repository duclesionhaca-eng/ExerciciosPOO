package control;

import java.util.ArrayList;
import model.Gato;

public class ControlGato {

    ArrayList<Gato> gatos = new ArrayList<>();
    

    public void cadatrarGato(Gato gato) {
        gatos.add(gato);
    }

    public boolean excluirgato(String nome) {
        for (Gato gato :gatos){
            if(gato.getNome().equalsIgnoreCase(nome)){
            gatos.remove(gato);
            return true;
            }
        }
        return false;
    }

    public ArrayList<Gato> getGatos() {
        return gatos;
    }

    public int getQuantidadeGatos() {
        return gatos.size();
    }
}
