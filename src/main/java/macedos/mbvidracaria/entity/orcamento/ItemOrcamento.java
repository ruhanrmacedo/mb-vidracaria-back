package macedos.mbvidracaria.entity.orcamento;

import jakarta.persistence.*;
import lombok.*;
import macedos.mbvidracaria.entity.material.Material;
import macedos.mbvidracaria.entity.material.Vidro;
import macedos.mbvidracaria.entity.material.Aluminio;
import macedos.mbvidracaria.entity.material.Ferragens;
import macedos.mbvidracaria.entity.material.Acessorio;

@Entity
@Table(name = "item_orcamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemOrcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false) // Nome da coluna para chave estrangeira em item_orcamento
    private Material material;

    private int quantidade;
    private double preco;

    public void calcularPreco() {
        if (material instanceof Vidro vidro) {
            this.preco = vidro.getPrecoPorKg() * quantidade; // Cálculo baseado em peso para Vidro
        } else if (material instanceof Aluminio aluminio) {
            // Adicionar uma verificação para o tipo de cálculo desejado (por peça ou metro)
            this.preco = aluminio.getPrecoPorPeca() * quantidade; // Exemplo de cálculo por peça
        } else if (material instanceof Ferragens ferragens) {
            this.preco = ferragens.getPrecoPorUnidade() * quantidade; // Cálculo por unidade para Ferragens
        } else if (material instanceof Acessorio acessorio) {
            this.preco = acessorio.getPrecoPorUnidade() * quantidade; // Cálculo por unidade para Acessório
        } else {
            throw new UnsupportedOperationException("Cálculo de preço não suportado para o tipo de material fornecido.");
        }
    }
}
