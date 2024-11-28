package macedos.mbvidracaria.entity.projeto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import macedos.mbvidracaria.enums.Ambiente;
import macedos.mbvidracaria.enums.TipoProjetoEngenharia;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Engenharia extends Projeto{
    private TipoProjetoEngenharia tipoProjetoEngenharia;

    public Engenharia(Long id, String nome, Ambiente ambiente, Dimensoes dimensoes, TipoProjetoEngenharia tipoProjetoEngenharia) {
        super(id, nome, ambiente, dimensoes);
        this.tipoProjetoEngenharia = tipoProjetoEngenharia;
    }
}
