package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeString;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class Role extends TypeString {

	public Role(String value) {
		super(value);
		verifyIsNotBlank(new BadRequestException(ErrorConstantsShared.BAD_ROLE, "The role must not be empty"));
	}

	@Override
	public String toString() {
		return "Role [value()=" + value() + "]";
	}

}
