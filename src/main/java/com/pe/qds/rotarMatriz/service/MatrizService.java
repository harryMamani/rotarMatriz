package com.pe.qds.rotarMatriz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pe.qds.rotarMatriz.exception.MatrizException;
import com.pe.qds.rotarMatriz.model.Matriz;

public interface MatrizService {

	public Matriz rotarMatriz(Matriz matriz) throws MatrizException, JsonProcessingException;
	
}
