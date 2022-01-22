package pe.lacafetalab.pao.shared.domain.valueobject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeString;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class ContactEmail extends TypeString {

	public ContactEmail(String contactEmail) {
		super(contactEmail);
		if (StringUtils.isNotEmpty(contactEmail) && !EmailValidator.getInstance().isValid(value())) {
			throw new BadRequestException(ErrorConstantsShared.BAD_CONTACT_EMAIL, "The contact email is not valid");
		}
	}
}