package macedos.mbvidracaria.entity.material;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ferragens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ferragens extends Material{
    @Column(name = "preco_por_unidade")
    private double precoPorUnidade;

    public Ferragens(Long id, String nome, String codigo, String descricao, int quantEstoque, int quantMinEstoque, boolean ativo, double precoPorUnidade) {
        super(id, nome, codigo, descricao, quantEstoque, quantMinEstoque, ativo);
        this.precoPorUnidade = precoPorUnidade;
    }
}
