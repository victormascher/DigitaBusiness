package br.com.fiap.to;

import java.util.List;

public class Filme {
	
	private String titulo;
	
	private String classificacao;
	
	private int duracao;
	
	private List<String> estudio;
	
	private boolean nacionalidade;

	
	
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public List<String> getEstudio() {
		return estudio;
	}

	public void setEstudio(List<String> estudio) {
		this.estudio = estudio;
	}

	public boolean isNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(boolean nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	
	
	
	
	
	
}
