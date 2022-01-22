package pe.lacafetalab.pao.shared.usecase.get_ruc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Query;

@Getter
@AllArgsConstructor
public final class GetRucQuery implements Query {
	private final String tipo;
	private final String ruc;
}
