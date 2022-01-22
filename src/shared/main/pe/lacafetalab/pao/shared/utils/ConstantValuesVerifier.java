package pe.lacafetalab.pao.shared.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public class ConstantValuesVerifier {

	public static void verifierNoDuplicatedValues(Class<?> clazz) {
		Map<Integer, String> list = new HashMap<>();
		Field fields[] = clazz.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			Class<?> t = field.getType();
			if (t == int.class) {
				try {
					Integer intObj = Integer.valueOf(field.getInt(null));
					String fieldNameOriginal = list.get(intObj);
					if (list.containsKey(intObj)) {
						throw new BadRequestException(400,
								String.format("The value [%d] is configured in these both constants variables [%s, %s]",
										intObj, field.getName(), fieldNameOriginal));
					}
					list.put(intObj, field.getName());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
