package pe.lacafetalab.pao.shared.domain.valueobject;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeEnum;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class DocumentType extends TypeEnum<DocumentType.Type> {

	private static BadRequestException INVALID_VALUE = new BadRequestException(ErrorConstantsShared.BAD_DOCUMENT_TYPE,
			"Invalid document type");

	public DocumentType(Type type) {
		super(type);
	}

	public DocumentType(String value) {
		super(DocumentType.Type.class, value, INVALID_VALUE);
	}

	public static enum Type {
		DNI, CARNET_EXT;

		public static boolean isValid(String str) {
			return valueFrom(DocumentType.Type.class, str).isPresent();
		}
	}
}