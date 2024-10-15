package macedos.mbvidracaria.entity.projeto;

import jakarta.persistence.Entity;
import macedos.mbvidracaria.entity.orcamento.ItemOrcamento;
import macedos.mbvidracaria.enums.Ambiente;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Projeto {
    private Long id;
    private String nome;
    private Ambiente ambiente;
    private Dimensoes dimensoes;
    private List<ItemOrcamento> itens;

    public Projeto(Long id, String nome, Ambiente ambiente, Dimensoes dimensoes) {
        this.id = id;
        this.nome = nome;
        this.ambiente = ambiente;
        this.dimensoes = dimensoes;
        this.itens = new ArrayList<>();
    }
    public void adicionarItem(ItemOrcamento item) {
        itens.add(item);
    }
    public void removerItem(ItemOrcamento item) {
        itens.remove(item);
    }

}
