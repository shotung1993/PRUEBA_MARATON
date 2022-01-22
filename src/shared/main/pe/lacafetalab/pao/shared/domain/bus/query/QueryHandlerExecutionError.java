package pe.lacafetalab.pao.shared.domain.bus.query;

public final class QueryHandlerExecutionError extends Throwable {
	private static final long serialVersionUID = 1L;

	public QueryHandlerExecutionError(Throwable cause) {
		super(cause);
	}
}
