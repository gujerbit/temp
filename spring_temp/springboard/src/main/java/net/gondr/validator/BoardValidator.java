package net.gondr.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.gondr.domain.BoardVO;

public class BoardValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return BoardVO.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "required", "글의 제목은 필수 값입니다.");
		ValidationUtils.rejectIfEmpty(errors, "content", "required", "글의 내용은 필수 값입니다.");
	}
	
}
