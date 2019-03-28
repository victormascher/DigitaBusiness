package br.com.fiap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.impl.PedidoDAOImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/empresa")
public class PedidoResource {
	
	private PedidoDAO dao;
	
	public PedidoResource() {
		
		dao = new PedidoDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public procurar() {
		
		
	}
	
	
	
	
}
