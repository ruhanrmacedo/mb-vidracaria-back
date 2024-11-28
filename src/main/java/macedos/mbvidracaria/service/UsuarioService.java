package macedos.mbvidracaria.service;

import jakarta.validation.Valid;
import macedos.mbvidracaria.dto.usuario.*;
import macedos.mbvidracaria.entity.Usuario;
import macedos.mbvidracaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario cadastrarUsuario(@Valid Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario editarUsuario(EditarUsuarioDTO editarUsuarioDTO) {
        var usuario = usuarioRepository.getReferenceById(editarUsuarioDTO.id());
        usuario.atualizarInformacoes(editarUsuarioDTO);
        return usuario;
    }

    public Page<Usuario> listarTodosUsuarios(Pageable paginacao) {
        return usuarioRepository.findAllByOrderByNome(paginacao);
    }

    public void alterarSenha(String novaSenha, String confirmarSenha) {
        if (!novaSenha.equals(confirmarSenha)) {
            throw new IllegalStateException("As senhas não coincidem!");
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String login = userDetails.getUsername();
            Usuario usuario = usuarioRepository.findByLogin(login)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

            String senhaCriptografada = passwordEncoder.encode(novaSenha);
            usuario.setSenha(senhaCriptografada);
            usuarioRepository.save(usuario);
        } else {
            throw new IllegalStateException("Tipo de usuário principal não é suportado.");
        }
    }

    public void alterarSenhaUsuarioSelecionado(Long usuarioId, String novaSenha, String confirmarSenha) {
        if (!novaSenha.equals(confirmarSenha)) {
            throw new IllegalArgumentException("As senhas não coincidem!");
        }

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o ID: " + usuarioId));

        String senhaCriptografada = passwordEncoder.encode(novaSenha);
        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);
    }

    public Usuario desligarUsuario(DesligarUsuarioDTO dados) {
        var usuarioDesligado = usuarioRepository.getReferenceById(dados.id());
        usuarioDesligado.desligarUsuario(dados);
        return usuarioRepository.save(usuarioDesligado); // Salva o usuário modificado no banco.
    }

    public Usuario readimitirUsuario(ReadimitirUsuarioDTO readimitirUsuarioDTO) {
        Usuario usuario = usuarioRepository.findById(readimitirUsuarioDTO.id())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o ID: " + readimitirUsuarioDTO.id()));

        if (usuario.getDataInativacao() == null) {
            throw new IllegalStateException("Usuário já está ativo.");
        }

        usuario.setDataInativacao(null);
        usuario.setDataAtivacao(LocalDate.now());
        usuarioRepository.save(usuario);

        return usuario;
    }


}
