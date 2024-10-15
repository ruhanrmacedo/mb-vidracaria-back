package macedos.mbvidracaria.entity.servico;

public class FotoServico {
    private Long id;
    private String caminho;
    private Servico servico;

    public FotoServico(String caminho, Servico servico) {
        this.caminho = caminho;
        this.servico = servico;
    }

    public Long getId() {
        return id;
    }

    public String getCaminho() {
        return caminho;
    }

    public Servico getServico() {
        return servico;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "FotoServico [id=" + id + ", caminho=" + caminho + ", servico=" + servico + "]";
    }
}
