package br.jus.tse.judiciaria.mural.dao;

import org.springframework.stereotype.Repository;

import br.jus.tse.corporativa.dao.AbstractBaseDAO;
import br.jus.tse.judiciaria.mural.entidade.Decisao;

/**
 * Classe exemplo para a implementacao da classe de dao do decisao.
 */
@Repository
public class DecisaoDAOImpl extends AbstractBaseDAO<Decisao, Long> implements IDecisaoDAO {

}
