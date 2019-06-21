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

import br.jus.tse.judiciaria.mural.dto.DecisaoDTO;
import br.jus.tse.judiciaria.mural.entidade.Decisao;
import br.jus.tse.judiciaria.mural.parser.DecisaoParser;
import br.jus.tse.judiciaria.mural.service.IDecisaoService;
import br.jus.tse.corporativa.web.AbstractBaseRest;
import br.jus.tse.corporativa.parser.AbstractBaseParser;
import br.jus.tse.corporativa.service.IBaseService;

/**
 * Classe resposnavel por expor o servico da funcionalidade de decisao.
 * 
 * @author arthur.souza
 * @since 1.1.1.1
 */
@Path("/decisao")
@Component
public class DecisaoRest extends AbstractBaseRest<Decisao, DecisaoDTO> {

    @Autowired
    private IDecisaoService decisaoService;

    /**
     * Metodo responsavel por realizar a lista de todos os decisoes.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @return resposta com a lista de decisoes, ou falha, utilizando o objeto ResultDTO.
     */
    @GET
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findBy() {
        return super.buscarTodos(this.getClass());
    }

    /**
     * Metodo responsavel por realizar a listagem dos decisoes com paginacao em banco.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @param paginaAtual pagina atual da paginacao no fron-end
     * @param limiteRegistroPorPagina quantidade de registros apresentados por pagina.
     * @return resposta com a lista de decisoes, ou falha, utilizando o objeto ResultDTO.
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
     * Metodo responsavel por recuperar o decisao pelo id.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @param id identificador do decisao.
     * @return resposta da requisicao com sucesso ou falha, utilizando o objeto ResultDTO.
     */
    @GET
    @Path("/{id: \\d+}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") final Long id) {
        return super.buscarPeloId(id, this.getClass());
    }

    /**
     * Metodo responsavel por incluir um novo decisao
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @param decisaoDTO dto do decisao
     * @return resposta da requisicao com sucesso ou falha, utilizando o objeto ResultDTO.
     */
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response insert(final DecisaoDTO decisaoDTO) {
        return super.salvar(decisaoDTO, "Decisão criado com sucesso.", this.getClass());
    }

    /**
     * Metodo responsavel por atualizar o decisao.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @param decisaoDTO dto do decisao
     * @return resposta da requisicao com sucesso ou falha, utilizando o objeto ResultDTO.
     */
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response update(final DecisaoDTO decisaoDTO) {
        return super.atualizar(decisaoDTO, "Decisão atualizado com sucesso.", this.getClass());
    }

    /**
     * Metodo responsavel por excluir um decisao.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * 
     * @param id identificador do decisao
     * @return resposta da requisicao com sucesso o falha, utilizando o objeto ResultDTO.
     */
    @DELETE
    @Path("/{id: \\d+}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") final Long id) {
        final Decisao decisao = new Decisao();
        decisao.setId(id);
        return super.excluir(decisao, "Decisão excluido com sucesso.", this.getClass());
    }

    /**
     * Metodo responsavel por retornar a instancia do service da funcionalidade.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @return decisao service
     */
    @Override
    protected IBaseService getService() {
        return this.decisaoService;
    }

    /**
     * Metodo responsavel por retornar a instancia da classe de parser da funcionalidade.
     * 
     * @author arthur.souza
     * @since 1.1.1.1
     * @return decisao parser
     */
    @Override
    protected AbstractBaseParser getParser() {
        return new DecisaoParser();
    }
}
