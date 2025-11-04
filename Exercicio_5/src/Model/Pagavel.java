package model;

import java.io.Serializable;

public interface Pagavel extends Serializable {
    double calcularPagamento();
    String getNome();
    String getTipo();
}
