package br.com.lramos.projetopadraojunit.arrays;

import java.util.ArrayList;
import java.util.List;

public class TransformacaoArrays {
	
	public List<Integer> arrayRotation(List<Integer> lista, Integer deslocamento) {
		int size = lista.size();
		List<Integer> inteiros = new ArrayList<Integer>();

		if (deslocamento >= size) {
			deslocamento = deslocamento % size;
		}
		
		Integer blocoInicial = size - deslocamento;
		Integer blocoFinal = size - blocoInicial;

		inteiros = lista.subList(size - blocoInicial, size);

		inteiros.addAll(lista.subList(0, blocoFinal));

		return inteiros;
	}
	
}
