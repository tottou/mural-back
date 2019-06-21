package br.jus.tse.judiciaria.mural.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.jus.tse.judiciaria.mural.dto.PublicacaoDTO;
import br.jus.tse.judiciaria.mural.entidade.Publicacao;
import br.jus.tse.judiciaria.mural.parser.PublicacaoParser;
import br.jus.tse.judiciaria.mural.service.IPublicacaoService;
import br.jus.tse.corporativa.web.AbstractBaseRest;
import br.jus.tse.corporativa.parser.AbstractBaseParser;
import br.jus.tse.corporativa.service.IBaseService;

/**
 * Classe resposnavel por expor o servico da funcionalidade de publicacao.
 * 
 * @author arthur.souza
 * @since 1.1.1.1
 */
@Path("/publicacao")
@Component
public class PublicacaoRest extends AbstractBaseRest<Publicacao, PublicacaoDTO> {

    @Autowired
    private IPublicacaoService publicacaoService;

    /**
     * Metodo responsavel por realizar a lista de todos os publicacoes.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @return resposta com a lista de publicacoes, ou falha, utilizando o objeto ResultDTO.
     */
    @GET
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findBy() {
        return super.buscarTodos(this.getClass());
    }

    /**
     * Metodo responsavel por realizar a listagem dos publicacoes com paginacao em banco.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @param paginaAtual pagina atual da paginacao no fron-end
     * @param limiteRegistroPorPagina quantidade de registros apresentados por pagina.
     * @return resposta com a lista de publicacoes, ou falha, utilizando o objeto ResultDTO.
     */
    @GET
    @Path("/{paginaAtual: \\d+}/{limiteRegistroPorPagina: \\d+}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findBy(@PathParam("paginaAtual") final Integer paginaAtual, 
            @PathParam("limiteRegistroPorPagina") final Integer limiteRegistroPorPagina) {
        return super.listaPaginada(paginaAtual, limiteRegistroPorPagina, this.getClass());
    }

    /**
     * Metodo responsavel por recuperar o publicacao pelo id.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @param id identificador do publicacao.
     * @return resposta da requisicao com sucesso ou falha, utilizando o objeto ResultDTO.
     */
    @GET
    @Path("/{id: \\d+}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") final Long id) {
        return super.buscarPeloId(id, this.getClass());
    }
    
    @GET    
    @Path("/oi")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
	public Response documento() {
	        
	        final String result = publicacaoService.getPublicacao();	        
	        
	        	return Response.ok().entity(result).build();    	
	    	
	    }
    


    /**
     * Metodo responsavel por incluir um novo publicacao
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @param publicacaoDTO dto do publicacao
     * @return resposta da requisicao com sucesso ou falha, utilizando o objeto ResultDTO.
     */
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response insert(final PublicacaoDTO publicacaoDTO) {
        return super.salvar(publicacaoDTO, "Publicação criado com sucesso.", this.getClass());
    }

    /**
     * Metodo responsavel por atualizar o publicacao.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @param publicacaoDTO dto do publicacao
     * @return resposta da requisicao com sucesso ou falha, utilizando o objeto ResultDTO.
     */
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response update(final PublicacaoDTO publicacaoDTO) {
        return super.atualizar(publicacaoDTO, "Publicação atualizado com sucesso.", this.getClass());
    }

    /**
     * Metodo responsavel por excluir um publicacao.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * 
     * @param id identificador do publicacao
     * @return resposta da requisicao com sucesso o falha, utilizando o objeto ResultDTO.
     */
    @DELETE
    @Path("/{id: \\d+}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") final Long id) {
        final Publicacao publicacao = new Publicacao();
        publicacao.setId(id);
        return super.excluir(publicacao, "Publicação excluido com sucesso.", this.getClass());
    }
    
    

    /**
     * Metodo responsavel por retornar a instancia do service da funcionalidade.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @return publicacao service
     */
    @Override
    protected IBaseService getService() {
        return this.publicacaoService;
    }

    /**
     * Metodo responsavel por retornar a instancia da classe de parser da funcionalidade.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @return publicacao parser
     */
    @Override
    protected AbstractBaseParser getParser() {
        return new PublicacaoParser();
    }
}
