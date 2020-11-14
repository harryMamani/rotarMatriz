package com.pe.qds.rotarMatriz.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = MatrizCuadradaValidator.class)
@Target( { ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MatrizCuadrada {

	String message() default "La matriz no es cuadrada";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
	
}
