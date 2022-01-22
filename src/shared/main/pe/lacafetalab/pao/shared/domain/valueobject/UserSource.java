package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeEnum;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class UserSource extends TypeEnum<UserSource.Source> {
	private static BadRequestException INVALID_VALUE = new BadRequestException(ErrorConstantsShared.BAD_SOURCE,
			"Invalid User Source value");

	public UserSource(Source type) {
		super(type);
	}

	public UserSource(String value) {
		super(UserSource.Source.class, value, INVALID_VALUE);
	}

	public static enum Source {
		UTP, CUSTOM;

		public static boolean isValid(String str) {
			return valueFrom(UserSource.Source.class, str).isPresent();
		}
	}
}