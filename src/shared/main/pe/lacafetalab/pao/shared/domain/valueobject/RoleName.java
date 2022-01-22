package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeString;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class RoleName extends TypeString {

	public RoleName(String value) {
		super(value.trim().toUpperCase());
		verifyIsNotBlank(new BadRequestException(ErrorConstantsShared.EMPTY_VALUE, "RoleName can not be empty"));
	}
}