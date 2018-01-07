package br.com.lramos.projetopadraojunit;

public enum MensagemDeErro {
	
	CARACTERES_DUPLICADOS("O nome dado contém espaços duplicados."),
	CARACTERES_ESPECIAIS("O nome dado contém caracteres especiais.");
	
	private String mensagemDeErro;
	
	MensagemDeErro (String mensagemDeErro){
		this.mensagemDeErro = mensagemDeErro;
	}
	
	public String getMensagem () {
		return mensagemDeErro;
	}
}
