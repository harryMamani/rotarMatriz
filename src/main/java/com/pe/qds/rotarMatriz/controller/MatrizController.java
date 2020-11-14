package com.pe.qds.rotarMatriz.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pe.qds.rotarMatriz.exception.MatrizException;
import com.pe.qds.rotarMatriz.model.Matriz;
import com.pe.qds.rotarMatriz.service.MatrizService;

@RestController
@RequestMapping("/api/v1")
public class MatrizController {

	private static final Logger logger = LogManager.getLogger(MatrizController.class);

	@Autowired
	private MatrizService matrizService;

	@PostMapping("/rotar")
	public ResponseEntity<Matriz> rotarMatriz(@Valid @RequestBody Matriz matriz) throws MatrizException, JsonProcessingException {

		logger.info("INICIO : MatrizController.rotarMatriz");

		Matriz matrizNueva = matrizService.rotarMatriz(matriz);

		logger.info("FIN : MatrizController.rotarMatriz");
		return ResponseEntity.ok(matrizNueva);

	}

}
