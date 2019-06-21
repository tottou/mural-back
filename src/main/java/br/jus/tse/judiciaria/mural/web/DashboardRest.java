package br.jus.tse.judiciaria.mural.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.jus.tse.judiciaria.mural.service.IDashboardService;



/**
 * Classe resposnavel por expor o servico da funcionalidade de dashboard.
 * 
 * @author arthur.souza
 * @since 1.1.1.1
 */
@Path("/dashboard")
@Component
public class DashboardRest {
	
	
	 @Autowired
	 private IDashboardService dashboardService;
	 
	 
	
    @GET
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
	public Response dashboard() {
	        
	        final String result = dashboardService.consultarDashboard();	        
	        
	        	return Response.ok().entity(result).build();    	
	    	
	    }
	
	

}
