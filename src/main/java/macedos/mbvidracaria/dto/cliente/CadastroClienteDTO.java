package macedos.mbvidracaria.dto.cliente;

import jakarta.validation.constraints.NotBlank;

public record CadastroClienteDTO (
        @NotBlank String nome,
        @NotBlank String telefone,
        @NotBlank String email,
        @NotBlank String endereco
){
}
