package macedos.mbvidracaria.repository;

import macedos.mbvidracaria.entity.material.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    Page<Material> findByAtivoTrue(Pageable paginacao);

    Page<Material> findAllByOrderByIdDesc(Pageable paginacao);
}
