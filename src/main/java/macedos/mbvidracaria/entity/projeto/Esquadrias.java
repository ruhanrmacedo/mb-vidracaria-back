package macedos.mbvidracaria.entity.projeto;

import macedos.mbvidracaria.enums.Ambiente;
import macedos.mbvidracaria.enums.TipoProjetoEsquadria;

public class Esquadrias extends Projeto{
    private TipoProjetoEsquadria tipoProjetoEsquadria;

    public Esquadrias(Long id, String nome, Ambiente ambiente, Dimensoes dimensoes, TipoProjetoEsquadria tipoProjetoEsquadria) {
        super(id, nome, ambiente, dimensoes);
        this.tipoProjetoEsquadria = tipoProjetoEsquadria;
    }

}
