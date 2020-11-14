package com.pe.qds.rotarMatriz.service.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pe.qds.rotarMatriz.model.Matriz;
import com.pe.qds.rotarMatriz.service.MatrizService;
@SpringBootTest(classes = Application.class)
class MatrizServiceImplTest {

	@Autowired
	MatrizService service;
	
	@Test
	void testRotarMatriz() {

		boolean correcto = true;
		Matriz matrizInicial = new Matriz();
		matrizInicial.setMatriz(new Integer[][]{{1,2},{3,4}});
		
		Matriz matrizRotada = null;
		try {
			matrizRotada = service.rotarMatriz(matrizInicial);
		} catch (Exception e) {
			correcto = false;
		}
		assertTrue(correcto);
		assertArrayEquals(new Integer[][]{{2,4},{1,3}}, matrizRotada.getMatriz());
	}

}
