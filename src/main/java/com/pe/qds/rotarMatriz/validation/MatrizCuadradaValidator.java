package com.pe.qds.rotarMatriz.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pe.qds.rotarMatriz.util.Constantes;

public class MatrizCuadradaValidator implements ConstraintValidator<MatrizCuadrada, Integer[][]> {

	@Override
	public void initialize(MatrizCuadrada constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Integer[][] value, ConstraintValidatorContext context) {

		boolean isValid = true;
		
		context.disableDefaultConstraintViolation();
		
		if (value == null) {
			context.buildConstraintViolationWithTemplate(Constantes.VALORES_NULOS).addConstraintViolation();
			return false;
		}

		int orden = value.length;

		if (orden < 2) {
			context.buildConstraintViolationWithTemplate(Constantes.MATRIZ_MINIMA).addConstraintViolation();
			return false;
		}

		for (Integer[] fila : value) {

			if (orden != fila.length) {
				context.buildConstraintViolationWithTemplate(Constantes.ERROR_LONGITUD_FILA).addConstraintViolation();
				return false;
			}

		}
		
		return isValid;

	}

}
