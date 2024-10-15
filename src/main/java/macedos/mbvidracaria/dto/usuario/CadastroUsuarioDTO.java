package macedos.mbvidracaria.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastroUsuarioDTO(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String login,
        @NotNull
        String senha,
        LocalDate dataAtivacao,
        LocalDate dataInativacao) {
}
