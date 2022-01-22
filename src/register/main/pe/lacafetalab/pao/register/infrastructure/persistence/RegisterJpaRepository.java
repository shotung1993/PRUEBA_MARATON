package pe.lacafetalab.pao.register.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterJpaRepository extends JpaRepository<RegisterDao, String> {

}
