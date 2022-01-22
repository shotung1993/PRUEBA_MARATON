package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeEnum;

public class UserStatus extends TypeEnum<UserStatus.Status> {

	private static BadRequestException INVALID_VALUE = new BadRequestException(400, "Invalid active value");

	public UserStatus(Status value) {
		super(value);
		verifyIsNotNull(INVALID_VALUE);
	}

	public UserStatus(String str) {
		super(UserStatus.Status.class, str, INVALID_VALUE);
	}

	public static enum Status {
		ACTIVE, INACTIVE;

		public static boolean isValid(String str) {
			return valueFrom(UserStatus.Status.class, str).isPresent();
		}
	}
}
