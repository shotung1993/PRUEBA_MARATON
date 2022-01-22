package pe.lacafetalab.pao.shared.domain.valueobject;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeString;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class DocumentNumber extends TypeString {

	public final static String ZERO_VALUE = "00000000";

	public DocumentNumber(String value) {
		super(value);
		verifyIsNotBlank(
				new BadRequestException(ErrorConstantsShared.BAD_DOCUMENTNUMBER, "Document number can not be empty"));
	}

	public static boolean isNotValidValue(String str) {
		return StringUtils.isBlank(str) || ZERO_VALUE.equals(str.trim());
	}
}