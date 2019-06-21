package br.jus.tse.judiciaria.mural.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.tse.corporativa.dao.IBaseDAO;
import br.jus.tse.judiciaria.mural.dao.IDecisaoDAO;
import br.jus.tse.judiciaria.mural.entidade.Decisao;
import br.jus.tse.corporativa.exception.ServiceException;
import br.jus.tse.corporativa.service.AbstractBaseService;
import br.jus.tse.corporativa.util.Precondition;

/**
 * Interface exemplo para a implementacao do contrato do servico de decisao.
 */


@Service
public class DecisaoServiceImpl extends AbstractBaseService<Decisao, Long> implements IDecisaoService {

    @Autowired
    private IDecisaoDAO decisaoDAO;

    @Override
    public void salvar(final Decisao entity) throws ServiceException {
        this.validarCampos(entity);
        super.salvar(entity);
    }

    /**
     * Responsável por validar os campos obrigatórios do usuário.
     *
     * @param entity usuário.
     * @throws ServiceException exceção de pre condição.
     */
    private void validarCampos(final Decisao entity) throws ServiceException {
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
    public Decisao atualizar(final Decisao entity) throws ServiceException {
        this.validarCampos(entity);
        return super.atualizar(entity);
    }

    @Override
    public IBaseDAO getDAO() {
        return this.decisaoDAO;
    }
}
