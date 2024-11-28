package macedos.mbvidracaria.entity.projeto;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Dimensoes {
    private double altura;
    private double largura;
    private double profundidade;

    public double calcularArea() {
        return altura * largura;
    }

    public void validarDimensoes() {
        if (altura <= 0 || largura <= 0 || profundidade <= 0) {
            throw new IllegalArgumentException("As dimensões devem ser maiores que zero.");
        }
    }
}
