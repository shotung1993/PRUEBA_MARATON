package pe.lacafetalab.pao.shared.usecase.get_ruc;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryHandler;

@Service
public final class GetRucQueryHandler
        implements QueryHandler<GetRucQuery, GetRucResponse> {
    private final GetRuc service;

    public GetRucQueryHandler(GetRuc service) {
        this.service = service;
    }

    @Override
    public GetRucResponse handle(GetRucQuery query) {
        return this.service.execute(query.getTipo(), query.getRuc());
    }
}
