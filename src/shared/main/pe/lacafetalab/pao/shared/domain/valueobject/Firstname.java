package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeString;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class Firstname extends TypeString {

	public Firstname(String value) {
		super(value);
		verifyIsNotBlank(new BadRequestException(ErrorConstantsShared.BAD_FIRSTNAME, "First name can not be empty"));
	}
}