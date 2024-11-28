package macedos.mbvidracaria.entity.material;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "aluminio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Aluminio extends Material {
    @Column(name = "comprimento")
    private double comprimento; // Comprimento da peça inteira em metros
    @Column(name = "largura")
    private double largura;
    @Column(name = "espessura")
    private double espessura;
    @Column(name = "preco_por_peca")
    private double precoPorPeca; // Preço da peça inteira
    @Column(name = "preco_por_metro")
    private double precoPorMetro; // Preço por metro
    private boolean porMetro; // Flag para definir se o cálculo é por metro ou peça inteira

    public Aluminio(Long id, String nome, String codigo, String descricao, int quantEstoque, int quantMinEstoque, boolean ativo, double comprimento, double largura, double espessura, double precoPorPeca, double precoPorMetro, boolean porMetro) {
        super(id, nome, codigo, descricao, quantEstoque, quantMinEstoque, ativo);
        this.comprimento = comprimento;
        this.largura = largura;
        this.espessura = espessura;
        this.precoPorPeca = precoPorPeca;
        this.precoPorMetro = precoPorMetro;
        this.porMetro = porMetro;
    }

    public double calcularPreco(double comprimentoUsado) {
        if (porMetro) {
            // Se o cálculo for por metro
            if (comprimentoUsado > comprimento || (comprimento - comprimentoUsado) < 1) {
                // Se o comprimento usado excede o comprimento da peça ou sobra menos de 1 metro, cobra a peça inteira
                return precoPorPeca;
            } else {
                // Caso contrário, cobra por metro
                return precoPorMetro * comprimentoUsado;
            }
        } else {
            // Se o cálculo for por peça, cobra o preço da peça inteira
            return precoPorPeca;
        }
    }
}
