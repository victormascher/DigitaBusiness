package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.Jogos;

public class JogosBO {
	
	private static List<Jogos> lista = new ArrayList<Jogos>();
	
	public void cadastrar(Jogos jogos) {
		
		lista.add(jogos);
		
	}
	
	public List<Jogos> listar(){
		
		return lista;
		
	}
}
