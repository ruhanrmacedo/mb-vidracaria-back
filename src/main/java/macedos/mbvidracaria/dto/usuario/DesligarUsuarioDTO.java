package macedos.mbvidracaria.dto.usuario;

import java.time.LocalDate;

public record DesligarUsuarioDTO(
        Long id,
        LocalDate dataInativacao) {
}
