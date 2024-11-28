package macedos.mbvidracaria.entity.orcamento;

import jakarta.persistence.*;
import lombok.*;
import macedos.mbvidracaria.entity.cliente.Cliente;
import macedos.mbvidracaria.entity.projeto.Projeto;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orcamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Orcamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Projeto projeto;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
    private List<ItemOrcamento> itens;
    private LocalDate dataCriacao;
    private LocalDate dataValidade;
    private double valorTotal;
    private double valorDesconto;
    private boolean aprovado;


    public void calcularValorTotal() {
        this.valorTotal = itens.stream().mapToDouble(ItemOrcamento::getPreco).sum();
    }

    private void adicionarDesconto(double valor) {
        this.valorDesconto = valor;
    }

    public boolean validarOrcamento() {
        return !itens.isEmpty() && !dataValidade.isBefore(dataCriacao);
    }
}
