package macedos.mbvidracaria.entity.servico;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "foto_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class FotoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caminho;
    @ManyToOne
    private Servico servico;

}
