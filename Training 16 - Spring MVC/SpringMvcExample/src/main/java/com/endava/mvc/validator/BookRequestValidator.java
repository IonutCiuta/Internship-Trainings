package com.endava.mvc.validator;

import java.text.MessageFormat;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.endava.mvc.dto.BookDTO;
import com.endava.mvc.repository.BookRepository;

/**
 * @author cudrescu
 */
@Component
public class BookRequestValidator implements Validator {

	private static final Logger LOG = LoggerFactory.getLogger(BookRequestValidator.class);

	@Resource
	private BookRepository bookRepository;

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(BookDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookDTO bookDTO = (BookDTO) target;
		if(bookRepository.findByTitle(bookDTO.getTitle()) != null) {
			String message = MessageFormat.format("A book with title {0} already exists", bookDTO.getTitle());
			LOG.error(message);
			errors.rejectValue("title", "V100", message);
		}
	}
}
