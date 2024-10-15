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
public class Aluminio extends Material{
    @Column(name = "comprimento")
    private double comprimento;
    @Column(name = "largura")
    private double largura;
    @Column(name = "espessura")
    private double espessura;
    @Column(name = "preco_por_peca")
    private double precoPorPeca;

    public Aluminio(Long id, String nome, String codigo, String descricao, int quantEstoque, int quantMinEstoque, boolean ativo, double comprimento, double largura, double espessura, double precoPorPeca) {
        super(id, nome, codigo, descricao, quantEstoque, quantMinEstoque, ativo);
        this.comprimento = comprimento;
        this.largura = largura;
        this.espessura = espessura;
        this.precoPorPeca = precoPorPeca;
    }
}
