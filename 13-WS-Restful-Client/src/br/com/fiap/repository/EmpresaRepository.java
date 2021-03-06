package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.response.exception.ResponseException;
import br.com.fiap.to.Empresa;

public class EmpresaRepository {
	
	private static Client cliente = Client.create();
	
	private static final String URL = "http://localhost:8080/12-WS-RESTFULL/rest/empresa/";
	
	public Empresa pesquisa(int codigo) throws ResponseException{
		
		WebResource resource = cliente.resource(URL +  codigo);
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(resp.getStatus() != 200) {
			throw new ResponseException();
			
		}
		return resp.getEntity(Empresa.class);
	}

	
	public List<Empresa> listar() throws ResponseException{
		
		
		WebResource resource = cliente.resource(URL);
		
		//CHAMAR WEBSERVICE
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		//Valida se deu certo
		if(resp.getStatus() != 200) {
			throw new ResponseException();
		}
		
		//RECUPERA AS EMPRESAS DO WEBSERVICE
		Empresa[] vetor = resp.getEntity(Empresa[].class);
		return Arrays.asList(vetor); //transforma o vetor em lista
	}
	
	public void cadastrar(Empresa empresa) throws ResponseException{
		
		WebResource resource = cliente.resource(URL);
		
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, empresa);
		
		if(resp.getStatus() != 201) {
			throw new ResponseException();
			
		}
		
	 
	}
	
	public void atualizar(Empresa empresa)throws ResponseException {
		
		WebResource resource = cliente.resource(URL + empresa.getCodigo());
		
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, empresa);
		
		if(resp.getStatus() != 200) {
			throw new ResponseException();
		}
		
	}
	
	
	public void delete(int codigo) throws ResponseException{
		
		WebResource resource = cliente.resource(URL + codigo);
		
		ClientResponse resp = resource.delete(ClientResponse.class);
		
		if(resp.getStatus() != 204) {
			throw new ResponseException();
		
		}
				
	}
	
	
}
