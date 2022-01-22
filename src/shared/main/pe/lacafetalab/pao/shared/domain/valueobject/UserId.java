package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.base.ddd.domain.types.TypeId;
import pe.lacafetalab.pao.shared.model.util.UUIDUtils;

public class UserId extends TypeId {

	public UserId(String userId) {
		super(userId.trim());
	}

	public UserId(Email email) {
		this(UUIDUtils.generateUUID(email.value().trim().toUpperCase()).toString());
	}
}