package pe.lacafetalab.pao.shared.infrastructure.bus.query;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import pe.lacafetalab.pao.shared.domain.bus.query.Query;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandler;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryNotRegisteredError;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Service
@SuppressWarnings({ "rawtypes", "unchecked" })

public final class InMemoryQueryBus implements QueryBus {
	private final QueryHandlersInformation information;
	private final ApplicationContext context;

	public InMemoryQueryBus(QueryHandlersInformation information, ApplicationContext context) {
		this.information = information;
		this.context = context;
	}

	@Override
	public Response ask(Query query) throws QueryNotRegisteredError, QueryHandlerExecutionError {
		Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());

		QueryHandler handler = context.getBean(queryHandlerClass);

		return handler.handle(query);
	}
}
