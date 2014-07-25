/**
 * 
 */
package com.netsol.api.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.netsol.api.pojo.ErrorResource;
import com.netsol.api.pojo.FieldErrorResource;

/**
 * @author Harmeet Singh(Taara)
 *
 */

@ControllerAdvice
public class RestApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({InvalidRequestException.class})
	protected ResponseEntity<Object> handleInvalidRequest(
			RuntimeException runtimeException, WebRequest webRequest) {
		InvalidRequestException invalidRequestException = (InvalidRequestException) runtimeException;

		List<FieldError> fieldErrors = invalidRequestException.getErrors()
				.getFieldErrors();

		List<FieldErrorResource> errorResources = IntStream
				.range(0, fieldErrors.size())
				.<FieldErrorResource> mapToObj(
						i -> {
							FieldErrorResource resource = new FieldErrorResource();
							resource.setCode(fieldErrors.get(i).getCode());
							resource.setField(fieldErrors.get(i).getField());
							resource.setMessage(fieldErrors.get(i)
									.getDefaultMessage());
							resource.setResource(fieldErrors.get(i)
									.getObjectName());
							return resource;
						}).collect(Collectors.toList());

		ErrorResource errorResource = new ErrorResource("InvalidRequest",
				invalidRequestException.getMessage());
		errorResource.setErrorResources(errorResources);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return handleExceptionInternal(runtimeException, errorResource,
				headers, HttpStatus.UNPROCESSABLE_ENTITY, webRequest);
	}
}
