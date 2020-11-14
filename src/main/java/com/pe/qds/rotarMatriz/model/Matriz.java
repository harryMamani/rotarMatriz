package com.pe.qds.rotarMatriz.model;

import java.io.Serializable;

import com.pe.qds.rotarMatriz.validation.MatrizCuadrada;

public class Matriz implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@MatrizCuadrada
	private Integer[][] matriz;
	public Integer[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(Integer[][] matriz) {
		this.matriz = matriz;
	}
	
	
}
