package macedos.mbvidracaria.entity.projeto;

import macedos.mbvidracaria.enums.Ambiente;
import macedos.mbvidracaria.enums.TipoProjetoEngenharia;

public class Engenharia extends Projeto{
    private TipoProjetoEngenharia tipoProjetoEngenharia;

    public Engenharia(Long id, String nome, Ambiente ambiente, Dimensoes dimensoes, TipoProjetoEngenharia tipoProjetoEngenharia) {
        super(id, nome, ambiente, dimensoes);
        this.tipoProjetoEngenharia = tipoProjetoEngenharia;
    }
}
