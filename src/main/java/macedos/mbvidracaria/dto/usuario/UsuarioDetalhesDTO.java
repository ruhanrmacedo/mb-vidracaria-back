package macedos.mbvidracaria.dto.usuario;

import macedos.mbvidracaria.entity.Usuario;

public record UsuarioDetalhesDTO (
        Long id,
        String nome,
        String cpf,
        String login) {

    public UsuarioDetalhesDTO(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getLogin());
    }
}
