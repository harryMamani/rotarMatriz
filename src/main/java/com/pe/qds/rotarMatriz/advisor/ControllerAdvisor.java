package com.pe.qds.rotarMatriz.advisor;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pe.qds.rotarMatriz.bean.ErrorValidation;
import com.pe.qds.rotarMatriz.bean.Status;
import com.pe.qds.rotarMatriz.bean.StatusValidation;
import com.pe.qds.rotarMatriz.enumeration.ErrorCodeEnum;

@RestControllerAdvice
public class ControllerAdvisor {

	private static final Logger log = LogManager.getLogger(ControllerAdvisor.class);

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Status> handlerException(Exception ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ErrorCodeEnum.FAIL.status(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Status> handlerException(ConstraintViolationException ex) {
		Status status = ErrorCodeEnum.VALIDACION.status();
		status.setMessage(ex.getMessage());
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ MethodArgumentNotValidException.class})
	public ResponseEntity<StatusValidation> handlerException(MethodArgumentNotValidException ex) {
		StatusValidation status = new StatusValidation();
		status.setCode("4");
		List<ErrorValidation> errors = status.getErrors();
		for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(new ErrorValidation(error.getField(), error.getDefaultMessage()));
		}
		for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(new ErrorValidation(error.getObjectName(), error.getDefaultMessage()));
		}
		
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
	}

}
