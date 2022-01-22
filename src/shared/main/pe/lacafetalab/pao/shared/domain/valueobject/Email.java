package pe.lacafetalab.pao.shared.domain.valueobject;

import org.apache.commons.validator.routines.EmailValidator;

import lombok.Getter;
import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeString;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

@Getter
public class Email extends TypeString {

	public Email(String value) {
		super(value);
		verifyIsNotBlank(new BadRequestException(ErrorConstantsShared.BAD_EMAIL, "Email can not be empty"));
		if (!EmailValidator.getInstance().isValid(value())) {
			throw new BadRequestException(ErrorConstantsShared.BAD_EMAIL, "The email is not valid");
		}
	}
}