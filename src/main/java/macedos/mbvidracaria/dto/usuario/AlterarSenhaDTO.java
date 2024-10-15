package macedos.mbvidracaria.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record AlterarSenhaDTO(
        @NotBlank
        String novaSenha,
        @NotBlank
        String confirmarSenha) {
}
