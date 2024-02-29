package BE.code_review.common;

import lombok.Getter;

@Getter
public class EnumMapperValue {

	private final String code;
	private final String description;

	public EnumMapperValue(EnumMapperType enumMapperType) {
		this.code = enumMapperType.getCode();
		this.description = enumMapperType.getDescription();
	}
}
