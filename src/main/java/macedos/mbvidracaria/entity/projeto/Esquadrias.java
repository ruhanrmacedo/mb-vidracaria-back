package macedos.mbvidracaria.entity.projeto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import macedos.mbvidracaria.enums.Ambiente;
import macedos.mbvidracaria.enums.TipoProjetoEsquadria;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Esquadrias extends Projeto{
    private TipoProjetoEsquadria tipoProjetoEsquadria;

    public Esquadrias(Long id, String nome, Ambiente ambiente, Dimensoes dimensoes, TipoProjetoEsquadria tipoProjetoEsquadria) {
        super(id, nome, ambiente, dimensoes);
        this.tipoProjetoEsquadria = tipoProjetoEsquadria;
    }

}
