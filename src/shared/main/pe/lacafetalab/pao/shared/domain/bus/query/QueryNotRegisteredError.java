package pe.lacafetalab.pao.shared.domain.bus.query;

public final class QueryNotRegisteredError extends Exception {
	private static final long serialVersionUID = 1L;

	public QueryNotRegisteredError(Class<? extends Query> query) {
		super(String.format("The query <%s> hasn't a query handler associated", query.toString()));
	}
}
