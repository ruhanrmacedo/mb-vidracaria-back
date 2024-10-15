package macedos.mbvidracaria.dto.material;

import jakarta.validation.constraints.NotNull;
import macedos.mbvidracaria.enums.CategoriaMaterial;

public record EditarMaterialDTO(
        @NotNull
        Long id,
        String nome,
        String codigo,
        CategoriaMaterial categoriaMaterial,
        String descricao,
        Double precoPorKg,
        Double pesoPorMetro
        ){
}
