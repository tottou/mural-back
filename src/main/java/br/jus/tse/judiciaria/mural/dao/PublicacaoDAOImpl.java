package br.jus.tse.judiciaria.mural.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.jus.tse.corporativa.dao.AbstractBaseDAO;
import br.jus.tse.judiciaria.mural.entidade.Publicacao;

/**
 * Classe exemplo para a implementacao da classe de dao do publicacao.
 */
@Repository
public class PublicacaoDAOImpl extends AbstractBaseDAO<Publicacao, Long> implements IPublicacaoDAO {
	
	
	  @PersistenceContext
	    private EntityManager entityManager;

	

	
	@Override
	public Publicacao getPublicacao(){
		Publicacao pub = this.entityManager.find(Publicacao.class, 52635L);	
		
	
		
		return pub;
	}


}
