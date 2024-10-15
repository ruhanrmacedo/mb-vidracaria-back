package macedos.mbvidracaria.entity.material;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "acessorio")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Acessorio extends Material{
    @Column(name = "preco_por_unidade")
    private double precoPorUnidade;

    public Acessorio(Long id, String nome, String codigo, String descricao, int quantEstoque, int quantMinEstoque, boolean ativo, double precoPorUnidade) {
        super(id, nome, codigo, descricao, quantEstoque, quantMinEstoque, ativo);
        this.precoPorUnidade = precoPorUnidade;
    }
}
