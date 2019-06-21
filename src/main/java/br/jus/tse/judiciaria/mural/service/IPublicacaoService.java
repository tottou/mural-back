package br.jus.tse.judiciaria.mural.service;

import java.util.List;

import br.jus.tse.corporativa.service.IBaseService;
import br.jus.tse.judiciaria.mural.dto.DashboardDTO;
import br.jus.tse.judiciaria.mural.entidade.Publicacao;

/**
 * Interface exemplo para a implementacao do contrato do servico de decisao.
 */
public interface IPublicacaoService extends IBaseService<Publicacao, Long> {

	public String consultarDashboard();

	public String getPublicacao();
}
