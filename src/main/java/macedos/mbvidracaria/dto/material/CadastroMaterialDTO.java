package macedos.mbvidracaria.dto.material;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import macedos.mbvidracaria.enums.CategoriaMaterial;

public record CadastroMaterialDTO(
        @NotBlank String nome,
        @NotBlank String codigo,
        @NotBlank String descricao,
        @NotNull int quantEstoque,
        @NotNull int quantMinEstoque,
        Double espessura,
        Boolean temperado,
        Double precoPorKg,
        Double comprimento,
        Double largura,
        Double precoPorPeca,
        Double precoPorUnidade,
        Double precoPorMetro, // Novo atributo para preço por metro
        Boolean porMetro // Novo atributo para indicar cálculo por metro ou peça
) {
}
