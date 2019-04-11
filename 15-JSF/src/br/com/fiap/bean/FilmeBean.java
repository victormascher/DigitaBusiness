package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.FilmeBO;
import br.com.fiap.to.Filme;


@ManagedBean
public class FilmeBean {
	
	
	private Filme filme;
	
	private FilmeBO bo;
	
	
	@PostConstruct
	public void start() {
		setFilme(new Filme());
		bo = new FilmeBO();
	
}
	
	public void listar() {
		bo.mostrar();
	}
	
	public void cadastrarFilme() {
		
		bo.cadastrar(getFilme());
		FacesMessage msg = new FacesMessage("Filme Cadastrado com Sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cadastrado!");
	}
	
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	
	
	
	
	
	
}
