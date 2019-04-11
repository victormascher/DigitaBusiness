package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.Filme;

public class FilmeBO {
	
	private static List<Filme> lista = new ArrayList<Filme>();
	
	public void cadastrar(Filme filme) {
		
		lista.add(filme);
	}
	
	public List<Filme> mostrar() {
		return lista;
		
	}
}
