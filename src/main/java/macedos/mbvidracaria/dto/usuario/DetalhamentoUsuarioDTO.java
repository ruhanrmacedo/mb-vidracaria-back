package macedos.mbvidracaria.dto.usuario;

import macedos.mbvidracaria.entity.Usuario;

import java.time.LocalDate;

public record DetalhamentoUsuarioDTO(
    Long id,
    String nome,
    String cpf,
    String login,
    String senha,
    LocalDate dataAtivacao,
    LocalDate dataInativacao) {

    public DetalhamentoUsuarioDTO(Usuario usuario) {
        this (
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getLogin(),
                usuario.getSenha(),
                usuario.getDataAtivacao(),
                usuario.getDataInativacao()
        );
    }
}
