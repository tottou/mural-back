package br.jus.tse.judiciaria.mural.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.jus.tse.judiciaria.mural.service.IFiltroService;



/**
 * Classe resposnavel por expor o servico da funcionalidade de publicacao.
 * 
 * @author arthur.souza
 * @since 1.1.1.1
 */
@Path("/filtro")
@Component
public class FiltroRest {
	
	
	 @Autowired
	 private IFiltroService filtroService;
	 
	 
	
    @GET    
    @Path("/documento")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
	public Response documento() {
	        
	        final String result = filtroService.getListaTipoDocumento();	        
	        
	        	return Response.ok().entity(result).build();    	
	    	
	    }
    
    @GET    
    @Path("/uf")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
	public Response uf() {
	        
	        final String result = filtroService.getListaUf();	        
	        
	        	return Response.ok().entity(result).build();    	
	    	
	    }
    @GET    
    @Path("/municipio/{id: \\d+}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
	public Response municipio(@PathParam("id") final Long id) {
	        
	        final String result = filtroService.getListaMunicipio(id);	        
	        
	        	return Response.ok().entity(result).build();    	
	    	
	    }
    
    @GET    
    @Path("/tribunal")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
	public Response tribunal() {
	        
	        final String result = filtroService.getListaTribunal();	        
	        
	        	return Response.ok().entity(result).build();    	
	    	
	    }
    
    @GET    
    @Path("/unidade")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
	public Response unidade() {
	        
	        final String result = filtroService.getListaUnidade();	        
	        
	        	return Response.ok().entity(result).build();    	
	    	
	    }
	
	

}
