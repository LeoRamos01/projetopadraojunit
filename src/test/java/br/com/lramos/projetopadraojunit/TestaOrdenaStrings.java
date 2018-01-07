package br.com.lramos.projetopadraojunit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class TestaOrdenaStrings {

	private OrdenaStrings ordenaStrings;

	@Before
	public void init() {
		this.ordenaStrings = new OrdenaStrings();
	}

	@DataProvider
	public static Object [][] dataArrayStrings () {
		return new Object [][] {
			{Arrays.asList("Nivaldo Ramos", "Fernanda Ramos", "Thiago da Silva"), Arrays.asList("Ramos F.", "Ramos N.", "Silva T. D.")},
			{Arrays.asList("Carlos Magno Augusto", "Robson Fernandes", "Leonardo Ramos"), Arrays.asList("Augusto C. M.", "Fernandes R.", "Ramos L.")},
			{Arrays.asList("Thor Ramos", "Thor Ramos", "Lindenberg"), Arrays.asList("Lindenberg", "Ramos T.", "Ramos T.")}
		};
	}
	
	@DataProvider
	public static Object [][] listaNomeSobrenome () {
		return new Object [][] {
			{Arrays.asList("Fernanda", "","Ramos"), "Fernanda  Ramos"},
			{Arrays.asList("Fernanda", "...Ramos"), "Fernanda ...Ramos"}
		};
	}
	
	@Test
	public void testaAlfabetica() {
		List<String> strings = Arrays.asList("abobora", "pessego", "maçã", "chinelo");

		strings = ordenaStrings.alfabetica(strings);

		List<String> esperada = Arrays.asList("abobora", "chinelo", "maçã", "pessego");

		assertEquals(esperada, strings);

	}

	@Test
	public void testaAlfabeticaDesc() {
		List<String> strings = Arrays.asList("abobora", "pessego", "maçã", "chinelo", null);

		strings = ordenaStrings.alfabeticaDesc(strings);

		List<String> esperada = Arrays.asList("pessego", "maçã", "chinelo", "abobora");

		assertEquals(esperada, strings);

	}

	@Test
	public void testaTamanho() {
		List<String> strings = Arrays.asList("12", "1", "123", null, "");

		strings = ordenaStrings.tamanho(strings);

		List<String> esperada = Arrays.asList("", "1", "12", "123");

		assertEquals(esperada, strings);

	}

	@Test
	public void testaTamanhoDesc() {
		List<String> strings = Arrays.asList("12", "1", "123", null, "");

		strings = ordenaStrings.tamanhoDesc(strings);

		List<String> esperada = Arrays.asList("123", "12", "1", "");

		assertEquals(esperada, strings);

	}

	@Test
	@UseDataProvider("dataArrayStrings")
	public void testaAlfabeticaSobrenomes(List<String> recebido, List<String> esperado) {

		List<String> resultado = ordenaStrings.pessoasOrdenadasPorSobrenome(recebido);

		assertEquals(esperado, resultado);
	}
	
	@Test(expected = RuntimeException.class)
	@UseDataProvider("listaNomeSobrenome")
	public void testaValidaNomes (List<String> split, String nome) {
		ordenaStrings.validaNomes(split, nome);
	}
	
}
