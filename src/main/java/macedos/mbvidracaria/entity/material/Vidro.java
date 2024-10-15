package macedos.mbvidracaria.entity.material;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "vidro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Vidro extends Material{
    @Column(name = "espessura")
    private double espessura;
    @Column(name = "temperado")
    private boolean temperado;
    @Column(name = "preco_por_kg")
    private double precoPorKg;

    public Vidro(Long id, String nome, String codigo, String descricao, int quantEstoque, int quantMinEstoque, boolean ativo, double espessura, boolean temperado, double precoPorKg) {
        super(id, nome, codigo, descricao, quantEstoque, quantMinEstoque, ativo);
        this.espessura = espessura;
        this.temperado = temperado;
        this.precoPorKg = precoPorKg;
    }
}
