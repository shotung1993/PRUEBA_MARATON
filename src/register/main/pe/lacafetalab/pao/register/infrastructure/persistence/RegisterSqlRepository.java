package pe.lacafetalab.pao.register.infrastructure.persistence;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.register.domain.RegisterModel;
import pe.lacafetalab.pao.register.domain.RegisterRepository;


@Service
public final class RegisterSqlRepository implements RegisterRepository {
    private final RegisterJpaRepository crudRepository;

    public RegisterSqlRepository(RegisterJpaRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public void save(RegisterModel registerModel) {
        crudRepository.save(new RegisterDao(registerModel));
    }

}
