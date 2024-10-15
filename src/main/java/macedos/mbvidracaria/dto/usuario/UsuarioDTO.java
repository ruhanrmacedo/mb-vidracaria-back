package macedos.mbvidracaria.dto.usuario;

import macedos.mbvidracaria.entity.Usuario;

public record UsuarioDTO (

        Long id,
        String nome,
        String cpf,
        String login){

    public UsuarioDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getLogin());
    }
}
