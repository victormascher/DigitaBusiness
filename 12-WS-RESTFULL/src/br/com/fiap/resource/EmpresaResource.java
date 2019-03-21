package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/empresa") // denota a url de acesso
public class EmpresaResource {
	
	private EmpresaDAO dao;
	
	
	public EmpresaResource() {
		dao = new EmpresaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Empresa> buscar() {
		
		return dao.listar();
	}	
	
	//PUT REST/EMPRESA/CODIGO
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response att (Empresa empresa, @PathParam("id") int codigo) {
		
		
		try {
			empresa.setCodigo(codigo);
			dao.alterar(empresa);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		return Response.ok().build(); // 200 OK
	}
	
	//DELETE REST/EMPRESA
	
	@DELETE
	@Path("{id}")
	public void remover(@PathParam("id") int codigo) {
		
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (Exception e) {
		e.printStackTrace();
		throw new InternalServerErrorException();
		
		}
		
	}
	
	
	
	
	
	
	//GET REST/EMPRESA/CODIGO
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Empresa buscar(@PathParam("id") int codigo) {
		
		try {
			return dao.buscar(codigo);
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@POST // POST REST/EMPRESA
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Empresa empresa, @Context UriInfo url) {
		
		
		try {
			dao.cadastrar(empresa);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		//criar a URL para acessar a empresa cadastrada
		
		UriBuilder builder = url.getAbsolutePathBuilder();
		builder.path(empresa.getCodigo()+ "");

		//HTTP Status code : 201 CREATED
		return Response.created(builder.build()).build();
		
	}
	
	
	
	
	
}
