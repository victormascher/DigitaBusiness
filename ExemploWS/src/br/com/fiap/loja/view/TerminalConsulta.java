package br.com.fiap.loja.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		
		//Instanciar a classe que chama o web service (stub)
		try {
			EstoqueBOStub stub = new EstoqueBOStub();

			//Ler o codigo 
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o codigo do produto: ");
			int cod = sc.nextInt();
			sc.close();
			
			//Instanciar a classe que armazena o codigo que sera enviado
			ConsultarProduto param = new ConsultarProduto();
			param.setCodigo(cod);
			
			//chamar o webservice e recupera o objeto que possui  resposta 
			ConsultarProdutoResponse resp = stub.consultarProduto(param);
			
			//recupera e exibe os dados retornados pelo web service 
			ProdutoTO produto = resp.get_return();
			System.out.println(produto.getDescricao());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Qtd: " + produto.getQuantidade());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
}
