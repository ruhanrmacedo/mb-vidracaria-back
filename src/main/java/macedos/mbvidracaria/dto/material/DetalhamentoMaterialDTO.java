package macedos.mbvidracaria.dto.material;

import macedos.mbvidracaria.entity.material.Material;

public record DetalhamentoMaterialDTO(Long id,
                                      String nome,
                                      String codigo,
                                      String descricao
                                     ) {

    public DetalhamentoMaterialDTO(Material material) {
        this(material.getId(),
                material.getNome(),
                material.getCodigo(),
                material.getDescricao()
                );
    }

}
