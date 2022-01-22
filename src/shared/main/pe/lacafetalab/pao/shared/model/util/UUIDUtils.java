package pe.lacafetalab.pao.shared.model.util;

import java.util.UUID;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.libraries.UUID5;

public class UUIDUtils {

	public static UUID generateUUID(String str) {
		if (str == null) {
			throw new BadRequestException(400, "String to generate uuid can not be null");
		}
		return UUID5.fromUTF8(UUID5.POLYGENEA_NAMESPACE, str);
	}
}
