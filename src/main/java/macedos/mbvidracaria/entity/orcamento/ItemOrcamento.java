package macedos.mbvidracaria.entity.orcamento;

import macedos.mbvidracaria.entity.material.Material;

public class ItemOrcamento {
    public int id;
    private Material material;
    private int quantidade;
    private double preco;

    public void calcularPreco() {
        this.preco = material.getPrecoPorKg() * material.getPesoPorMetro() * quantidade;
    }

    public double getPreco() {
        return preco;
    }
}
