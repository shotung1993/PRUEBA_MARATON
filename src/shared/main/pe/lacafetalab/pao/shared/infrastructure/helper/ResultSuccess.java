package pe.lacafetalab.pao.shared.infrastructure.helper;

public class ResultSuccess extends ResultItem {
	public ResultSuccess(Integer index, String status) {
		super(index, true, status);
	}
}
