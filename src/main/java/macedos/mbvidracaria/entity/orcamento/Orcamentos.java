package macedos.mbvidracaria.entity.orcamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import macedos.mbvidracaria.entity.cliente.Cliente;
import macedos.mbvidracaria.entity.projeto.Projeto;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orcamentos")
public class Orcamentos {
    private Long id;
    private Projeto projeto;
    private Cliente cliente;
    private List<ItemOrcamento> itens;
    private LocalDate dataCriacao;
    private LocalDate dataValidade;
    private double valorTotal;
    private double valorDesconto;
    private boolean aprovado;


    public void calcularValorTotal() {
        this.valorTotal = 0;
        for (ItemOrcamento item : itens) {
            this.valorTotal += item.getPreco();
        }
    }

    private void adicionarDesconto(double valor) {
        this.valorDesconto = valor;
    }

    private boolean validadarOrçamento() {
        if (dataValidade.isBefore(dataCriacao)) {
            return false;
        }
        if (itens.isEmpty()) {
            return false;
        }
        return true;
    }



}
