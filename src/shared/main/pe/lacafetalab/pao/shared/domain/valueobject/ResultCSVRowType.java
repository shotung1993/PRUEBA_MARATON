package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeEnum;

public class ResultCSVRowType extends TypeEnum<ResultCSVRowType.Type> {

	private static BadRequestException INVALID_VALUE = new BadRequestException(400, "Invalid result type");

	public ResultCSVRowType(Type value) {
		super(value);
		verifyIsNotNull(INVALID_VALUE);
	}

	public ResultCSVRowType(String str) {
		super(ResultCSVRowType.Type.class, str, INVALID_VALUE);
	}

	public static enum Type {
		INSERTED, UPDATED, DELETED, ERROR;

		public static boolean isValid(String str) {
			return valueFrom(ResultCSVRowType.Type.class, str).isPresent();
		}
	}
}
