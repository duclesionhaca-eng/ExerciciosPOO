
package model;


public class Bicicleta extends Veiculo{
    private String Modelo;
    private String Marca;
    private int numDaBicicleta;

    public Bicicleta(String Modelo, String Marca, int numDaBicicleta) {
        this.Modelo = Modelo;
        this.Marca = Marca;
        this.numDaBicicleta = numDaBicicleta;
    }

    @Override
    public void mover() {
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getNumDaBicicleta() {
        return numDaBicicleta;
    }

    public void setNumDaBicicleta(int numDaBicicleta) {
        this.numDaBicicleta = numDaBicicleta;
    }
    
}
