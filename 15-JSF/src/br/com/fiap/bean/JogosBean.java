package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.JogosBO;
import br.com.fiap.to.Jogos;

@ManagedBean
public class JogosBean {
	
	private Jogos jogos;
	
	private JogosBO bo;
	
	@PostConstruct
	public void iniciar() {
		bo = new JogosBO();
		jogos = new Jogos();
		
	}
	
	public void cadastrarJogos() {
		
		bo.cadastrar(getJogos());
		FacesMessage msg = new FacesMessage("Cadastrado!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		System.out.println("CADASTRADO " + jogos.getNome() + "COM SUCESSO!");
		
	}
	
	public List<Jogos> listar(){
		return bo.listar();
		
	}
	
	
	
	
	

	public Jogos getJogos() {
		return jogos;
	}

	public void setJogos(Jogos jogos) {
		this.jogos = jogos;
	}
	
	
	
}
