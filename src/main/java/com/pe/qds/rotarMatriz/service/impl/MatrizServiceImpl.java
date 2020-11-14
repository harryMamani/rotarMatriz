package com.pe.qds.rotarMatriz.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.qds.rotarMatriz.exception.MatrizException;
import com.pe.qds.rotarMatriz.model.Matriz;
import com.pe.qds.rotarMatriz.service.MatrizService;

@Service
public class MatrizServiceImpl implements MatrizService {

	private static final Logger logger = LogManager.getLogger(MatrizServiceImpl.class);

	@Override
	public Matriz rotarMatriz(Matriz matriz) throws MatrizException, JsonProcessingException {

		logger.info("INICIO : MatrizServiceImpl.rotarMatriz");
		ObjectMapper mapper = new ObjectMapper();
		logger.info("Request : " + mapper.writeValueAsString(matriz));

		Matriz nuevaMatriz = null;
		Integer orden = matriz.getMatriz().length;

		Integer[][] matrizActual = matriz.getMatriz();
		Integer[][] matrizRotada = new Integer[orden][orden];

		int fila = 0;
		int columna = 0;
		for (int j = orden - 1; j >= 0; j--) {
			columna = 0;
			for (int i = 0; i < orden; i++) {
				matrizRotada[fila][columna++] = matrizActual[i][j];
			}
			fila++;
		}

		nuevaMatriz = new Matriz();
		nuevaMatriz.setMatriz(matrizRotada);

		logger.info("FIN : MatrizServiceImpl.rotarMatriz");
		return nuevaMatriz;
	}

}
