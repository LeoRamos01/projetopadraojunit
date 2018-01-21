package br.com.lramos.projetopadraojunit.arrays;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class TesteTransformacaoArrays {

	private TransformacaoArrays transforma;
	
	@DataProvider
	public static Object [][] arraysInteiros () {
		return new Object [][] {
			{new LinkedList<>(Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10, 1, 2)), new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 2},
			{new LinkedList<>(Arrays.asList(9, 10, 1, 2, 3, 4, 5, 6, 7, 8)), new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 8},
			{new LinkedList<>(Arrays.asList(6, 7, 8, 9, 10, 1, 2, 3, 4, 5)), new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 15},
			{new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 0},
			{new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 10},
			{new LinkedList<>(Arrays.asList(4, 5, 6, 7, 8, 9, 10, 1, 2, 3)), new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 13}
		};
	}
	
	@Before
	public void init () {
		transforma = new TransformacaoArrays();
	}
	
	@Test
	@UseDataProvider("arraysInteiros")
	public void testeArrayRotation (List<Integer> esperado, List<Integer> lista, Integer deslocamento) {
		assertEquals(esperado, transforma.arrayRotation(lista, deslocamento));
	}
	
}
