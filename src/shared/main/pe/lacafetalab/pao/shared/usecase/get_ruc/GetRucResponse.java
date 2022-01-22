package pe.lacafetalab.pao.shared.usecase.get_ruc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Getter
@AllArgsConstructor
public class GetRucResponse implements Response {
	private final String ruc;
	private final String razon_social;
	private final String estado;
	private final String direccion;
	private final String ubigeo;
	private final String departamento;
	private final String provincia;
	private final String distrito;

}
