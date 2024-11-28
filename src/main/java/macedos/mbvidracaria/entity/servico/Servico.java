package macedos.mbvidracaria.entity.servico;

import jakarta.persistence.*;
import lombok.*;
import macedos.mbvidracaria.entity.orcamento.Orcamentos;

import java.time.LocalDate;

@Entity
@Table(name = "servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Orcamentos orcamento;

    private String descricao;
    private LocalDate dataExecucao;

    public void marcarComoExecutado() {
        this.dataExecucao = LocalDate.now();
    }
}
