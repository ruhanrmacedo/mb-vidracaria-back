package macedos.mbvidracaria.repository;

import macedos.mbvidracaria.entity.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
