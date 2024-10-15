package macedos.mbvidracaria.entity.material;

import jakarta.persistence.*;
import lombok.*;

@Table(name= "material")
@Entity(name = "Material")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quant_estoque")
    private int quantEstoque;
    @Column(name = "quant_min_estoque")
    private int quantMinEstoque;

    @Column(name = "ativo")
    private boolean ativo;

    public void marcarComoInativo() {
        this.ativo = false;
    }
}
