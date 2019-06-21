package br.jus.tse.judiciaria.mural.dao;

import java.util.List;

import br.jus.tse.corporativa.dao.IBaseDAO;
import br.jus.tse.judiciaria.mural.dto.DashboardDTO;
import br.jus.tse.judiciaria.mural.entidade.Decisao;
import br.jus.tse.judiciaria.mural.entidade.Publicacao;

/**
 * Interface exemplo para a implementacao do contrato do servico de publicacao.
 */
public interface IPublicacaoDAO extends IBaseDAO<Publicacao, Long> {
	

	Publicacao getPublicacao();

}
