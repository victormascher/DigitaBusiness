package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.response.exception.ResponseException;
import br.com.fiap.to.Empresa;

public class View {
	
	
	private static EmpresaRepository  rep = new EmpresaRepository();
	
	public static void main(String[] args) throws ResponseException{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("1 - Listar");
		System.out.println("2 - Pesquisar");
		System.out.println("3 - Cadastrar");
		System.out.println("4- Atualizar");
		System.out.println("5- Deletar");
		System.out.println("0 - Sair");
		
		int op = sc.nextInt();
		
		switch (op) {
		
		case 1:
			listar();
			break;
			
		case 2:
			System.out.println("digite o codigo");
			int codigo = sc.nextInt();
			pesquisa(codigo);
			break;
			
		case 3:
			Empresa empresa = new Empresa();
			System.out.println("Digite o nome: ");
			empresa.setNome( sc.next() + sc.nextLine());
			System.out.println("Digite o faturamento:");
			empresa.setFaturamento(sc.nextDouble());
			System.out.println("Multinacional?");
			empresa.setMultinacional(sc.nextBoolean());
			cadastrar(empresa);
			break;
			
		case 4:
			empresa = new Empresa();
			atualizar(sc);
			break;
			
		default:
			System.out.println("Opção Inválida");
			break;
		}
		
	}

	private static void atualizar(Scanner sc) throws ResponseException{
		Empresa empresa = new Empresa();
		
		System.out.println("Digete o código: ");
		empresa.setCodigo(sc.nextInt());
		
		System.out.println("Digite o nome: ");
		empresa.setNome( sc.next() + sc.nextLine());
		
		System.out.println("Digite o faturamento:");
		empresa.setFaturamento(sc.nextDouble());
		
		System.out.println("Multinacional?");
		empresa.setMultinacional(sc.nextBoolean());
	
		try {
			rep.atualizar(empresa);
			System.out.println("Atualizado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void cadastrar(Empresa empresa) throws ResponseException {
		try {
			rep.cadastrar(empresa);
			System.out.println("Cadastrado com sucesso!");
		} catch (ResponseException e) {
			e.printStackTrace();
		}
		
	}

	public static void listar() {
		
		try {
			List<Empresa> lista = rep.listar();
			
			for (Empresa empresa : lista) {
				System.out.println("Nome da empresa: " + empresa.getNome());
				System.out.println("Faturamento da empresa: " + empresa.getFaturamento());
				System.out.println("Multinacional: " + empresa.isMultinacional());
				System.out.println("_________________________________________");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void pesquisa(int codigo) throws ResponseException {
		Empresa empresa =rep.pesquisa(codigo);		
		
		try {
			System.out.println(empresa.getNome());
			System.out.println(empresa.getFaturamento());
			System.out.println(empresa.isMultinacional());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void delete(Scanner sc) throws ResponseException{
		
		System.out.println("Digite o codigo:");
		int codigo = sc.nextInt();
		
		try {
			rep.delete(codigo);
			System.out.println("Deletado com sucesso!");
		} catch (ResponseException e) {
			e.printStackTrace();
		}
	}
	
	
}
