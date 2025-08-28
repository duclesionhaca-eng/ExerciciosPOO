package model;


public class Cachorro extends Animal {
  private String cor;
  private String raca;
    public Cachorro(String nome, int idade, String raca, String cor) {
        super(nome, idade);
        this.cor=cor;
        this.raca=raca;
        
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
  
    
}
