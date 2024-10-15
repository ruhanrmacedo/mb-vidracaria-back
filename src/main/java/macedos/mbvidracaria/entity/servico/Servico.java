package macedos.mbvidracaria.entity.servico;

import macedos.mbvidracaria.entity.orcamento.Orcamentos;

import java.time.LocalDate;

public class Servico {
    private Long id;
    private Orcamentos orcamento;
    private String descricao;
    private LocalDate dataExecucao;

    public void marcarComoExecutado() {
        this.dataExecucao = LocalDate.now();
    }

}
