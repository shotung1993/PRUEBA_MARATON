package pe.lacafetalab.pao.shared.infrastructure.helper;

import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.valueobject.ResultCSVRowType;

@Getter
public class ResultError extends ResultItem {
	private String error;

	public ResultError(Integer index, String error) {
		super(index, false, ResultCSVRowType.Type.ERROR.name());
		this.error = error;
	}

}
