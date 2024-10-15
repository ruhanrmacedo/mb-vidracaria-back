package macedos.mbvidracaria.repository;

import macedos.mbvidracaria.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //UserDetails findByLogin(String login);

    Optional<Usuario> findByLogin(String login);

    Page<Usuario> findAllByOrderByNome(Pageable paginacao);
}
