package br.jus.tse.judiciaria.mural.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.tse.corporativa.dao.IBaseDAO;
import br.jus.tse.corporativa.dto.ResultDTO;
import br.jus.tse.judiciaria.mural.dao.IPublicacaoDAO;
import br.jus.tse.judiciaria.mural.entidade.Publicacao;
import br.jus.tse.corporativa.exception.ServiceException;
import br.jus.tse.corporativa.service.AbstractBaseService;
import br.jus.tse.corporativa.util.GsonUtil;

/**
 * Interface exemplo para a implementacao do contrato do servico de publicacao.
 */


@Service
public class PublicacaoServiceImpl extends AbstractBaseService<Publicacao, Long> implements IPublicacaoService {

    @Autowired
    private IPublicacaoDAO publicacaoDAO;

    @Override
    public void salvar(final Publicacao entity) throws ServiceException {
        this.validarCampos(entity);
        super.salvar(entity);
    }

    /**
     * Responsável por validar os campos obrigatórios do usuário.
     *
     * @param entity usuário.
     * @throws ServiceException exceção de pre condição.
     */
    private void validarCampos(final Publicacao entity) throws ServiceException {
/*        Precondition.checkStringVazia(entity.getNome(), "Campo obrigatorio: Nome.");
        Precondition.checkNotNull(entity.getNascimento(), "Campo obrigatorio: Nascimento.");
        Precondition.checkStringVazia(entity.getEmail(), "Campo obrigatorio: Email.");
        Precondition.checkStringVazia(entity.getSenha(), "Campo obrigatorio: Senha.");*/
    }

    /**
     *
     * @param entity
     * @return
     * @throws ServiceException
     */
    @Override
    public Publicacao atualizar(final Publicacao entity) throws ServiceException {
        this.validarCampos(entity);
        return super.atualizar(entity);
    }
       
    
    @Override
    public String getPublicacao(){
        final ResultDTO resultado = new ResultDTO();
        publicacaoDAO.getPublicacao();

    	return "oi";
    }

    @SuppressWarnings("rawtypes")
	@Override
    public IBaseDAO getDAO() {
        return this.publicacaoDAO;
    }
}
