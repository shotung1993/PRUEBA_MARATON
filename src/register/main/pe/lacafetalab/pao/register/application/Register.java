package pe.lacafetalab.pao.register.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.register.domain.RegisterModel;
import pe.lacafetalab.pao.register.domain.RegisterRepository;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryNotRegisteredError;
import pe.lacafetalab.pao.shared.usecase.get_ruc.GetRucQuery;
import pe.lacafetalab.pao.shared.usecase.get_ruc.GetRucResponse;

@Service
public final class Register {
	static Logger logger = LoggerFactory.getLogger(Register.class);
	private final RegisterRepository repository;
	private final QueryBus queryBus;

	public Register(RegisterRepository repository, QueryBus eventBus) {
		this.repository = repository;
		this.queryBus = eventBus;
	}

	public void execute(String tipo, String ruc) {

		GetRucResponse getRucResponse = null;
		try {
			getRucResponse = queryBus.ask(new GetRucQuery(tipo, ruc));
		} catch (QueryNotRegisteredError | QueryHandlerExecutionError e) {
			logger.info("Error getRuc");
		}

		var register = new RegisterModel(
				getRucResponse.getRuc(),
				getRucResponse.getRazon_social(),
				getRucResponse.getEstado(),
				getRucResponse.getDireccion(),
				getRucResponse.getUbigeo(),
				getRucResponse.getDepartamento(),
				getRucResponse.getProvincia(),
				getRucResponse.getDistrito());

		repository.save(register);
	}



}
