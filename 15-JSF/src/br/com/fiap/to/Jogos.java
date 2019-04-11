package br.com.fiap.to;

import java.util.List;

public class Jogos {
	
	private String nome;
	
	private String genero;
	
	private List<String> plataforma;
	
	private boolean demo;
	
	private int jogadores;
	
	private float preco;
	
	
	


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<String> getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(List<String> plataforma) {
		this.plataforma = plataforma;
	}

	public boolean isDemo() {
		return demo;
	}

	public void setDemo(boolean demo) {
		this.demo = demo;
	}

	public int getJogadores() {
		return jogadores;
	}

	public void setJogadores(int jogadores) {
		this.jogadores = jogadores;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
}
