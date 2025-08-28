
package model;

public class Gato extends Animal {
    private String raca;
    private String cor;
    public Gato(String nome, int idade,String raca,String cor) {
        super(nome, idade);
        this.raca=raca;
        this.cor = cor;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return nome + " - " + idade + " anos - " + raca + " - " + cor; 
    }
    
    
}
