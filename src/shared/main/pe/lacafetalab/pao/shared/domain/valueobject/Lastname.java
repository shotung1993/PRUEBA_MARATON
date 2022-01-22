package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeString;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class Lastname extends TypeString {

	public Lastname(String value) {
		super(value);
		verifyIsNotBlank(new BadRequestException(ErrorConstantsShared.BAD_LASTNAME, "Last name can not be empty"));
	}
}