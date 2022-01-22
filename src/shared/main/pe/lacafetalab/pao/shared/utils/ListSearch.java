package pe.lacafetalab.pao.shared.utils;

import pe.lacafetalab.pao.shared.domain.bus.query.Response;

import java.util.List;

public final class ListSearch implements Response {
	private final List<? extends Response> list;

	public ListSearch(List<? extends Response> list) {
		this.list = list;
	}

	public List<? extends Response> list() {
		return list;
	}
}
