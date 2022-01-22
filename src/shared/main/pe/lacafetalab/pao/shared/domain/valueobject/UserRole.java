package pe.lacafetalab.pao.shared.domain.valueobject;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeEnum;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class UserRole extends TypeEnum<UserRole.Type> {

	public UserRole() {
		super(null);
	}

	public UserRole(String str) {
		super(UserRole.Type.class, StringUtils.isNotBlank(str) ? str : Type.ANY.name(),
				new BadRequestException(ErrorConstantsShared.BAD_USER_ROLE, "Invalid User-Role value"));
	}

	public static UserRole fromAny(String str) {
		return Type.isValid(str) ? new UserRole(str) : new UserRole();
	}

	public static enum Type {
		STUDENT, TEACHER, DESIGNER, ADMIN, ANY;

		public static boolean isValid(String str) {
			return valueFrom(UserRole.Type.class, str).isPresent();
		}

	}

	public String getNullableName() {
		return isNull() ? null : name();
	}
}
