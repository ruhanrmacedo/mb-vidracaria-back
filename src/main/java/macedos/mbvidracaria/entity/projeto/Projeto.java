package macedos.mbvidracaria.entity.projeto;

import jakarta.persistence.*;
import lombok.*;
import macedos.mbvidracaria.entity.orcamento.ItemOrcamento;
import macedos.mbvidracaria.enums.Ambiente;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projeto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Ambiente ambiente;
    @Embedded
    private Dimensoes dimensoes;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projeto_id")
    private List<ItemOrcamento> itens = new ArrayList<>();

    public Projeto(Long id, String nome, Ambiente ambiente, Dimensoes dimensoes) {
        this.id = id;
        this.nome = nome;
        this.ambiente = ambiente;
        this.dimensoes = dimensoes;
    }

    public void adicionarItem(ItemOrcamento item) {
        itens.add(item);
    }
    public void removerItem(ItemOrcamento item) {
        itens.remove(item);
    }

}
