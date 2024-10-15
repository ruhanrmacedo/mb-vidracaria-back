package macedos.mbvidracaria.dto.cliente;

import jakarta.validation.constraints.NotNull;

public record EditarclienteDTO (
        @NotNull Long id,
        String nome,
        String telefone,
        String email,
        String endereco
){
}
