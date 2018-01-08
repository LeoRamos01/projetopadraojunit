package br.com.lramos.projetopadraojunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * Classe que implementa diversas formas de se ordenar uma lista de strings.
 * 
 * @author ramos
 *
 */
public class OrdenaStrings {

	/**
	 * 
	 * Retorna lista em ordem alfabética ascendente.
	 * 
	 * @param Lista de palavras
	 * @return Lista de palavras ordenada alfabeticamente
	 */
	public List<String> alfabetica(List<String> strings) {
		return strings.stream().filter(s -> s != null).sorted().collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * 
	 * Retorna lista em ordem alfabética descendente.
	 * 
	 * @param Lista de palavras
	 * @return Lista de palavras ordenada em ordem alfabética reversa
	 */
	public List<String> alfabeticaDesc(List<String> strings) {
		return strings.stream().filter(s -> s != null).sorted(Comparator.reverseOrder())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * 
	 * Retorna lista em ordem de tamanho ascendente.
	 * 
	 * @param Lista de palavras
	 * @return Lista de palavras ordenada pelo tamanho da palavra crescente
	 */
	public List<String> tamanho(List<String> strings) {
		return strings.stream().filter(s -> s != null).sorted(Comparator.comparing(String::length))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * 
	 * Retorna lista em ordem de tamanho descendente.
	 * 
	 * @param Lista de palavras
	 * @return Lista de palavras pelo tamanho da palavra decrescente
	 */
	public List<String> tamanhoDesc(List<String> strings) {
		return strings.stream().filter(s -> s != null).sorted(Comparator.comparing(String::length).reversed())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * 
	 * Retorna lista em ordem alfabética pelos últimos sobrenomes.
	 * 
	 * Uma lista contendo: Albert Einstein, Johannes Sebastian Bach
	 * 
	 * Deverá retornar: Bach J. S., Einsten A.
	 * 
	 * @param Lista de nomes
	 * @return Lista de nomes ordenada alfabéticamente pelo último sobrenome
	 */
	public List<String> pessoasOrdenadasPorSobrenome(List<String> nomes) {

		List<String> novosNomes = new ArrayList<>();

		nomes.stream().filter(n -> n != null && !n.isEmpty()).forEach(nome -> {

			String[] split = nome.split(" ");
			List<String> sobrenomes = Arrays.asList(split);

			validaNomes(sobrenomes, nome);
			
			nome = sobrenomes.get(sobrenomes.size() - 1);

			for (int i = 0; i < sobrenomes.size() - 1; i++) {
				nome += " " + sobrenomes.get(i).substring(0, 1).toUpperCase() + ".";
			}

			
			novosNomes.add(nome);

		});

		return alfabetica(novosNomes);
	}

	public void validaNomes(List<String> sobrenomes, String nome) {

		Boolean temEspacosDuplicados = sobrenomes.stream().filter(s -> s.equals("")).findFirst().isPresent();

		// O Regex s.matches("[a-zA-Z]+") devolve true caso todos os caracteres seja letras
		Boolean temCaracteresEspeciais = sobrenomes.stream().filter(s -> !s.matches("[a-zA-Z|ãÃáÁçÇéÉôÔúÚ]+")).findFirst()
				.isPresent();

		if (temEspacosDuplicados) {
			throw new RuntimeException(MensagemDeErro.CARACTERES_DUPLICADOS.getMensagem() + " - " + nome);
		}

		if (temCaracteresEspeciais) {
			throw new RuntimeException(MensagemDeErro.CARACTERES_ESPECIAIS.getMensagem() + " - " + nome);
		}

	}

}
