package br.jus.tse.judiciaria.mural.dao;

import java.util.List;

import br.jus.tse.judiciaria.mural.dto.DashboardDTO;


/**
 * Interface exemplo para a implementacao do contrato do servico de filtro.
 */
public interface IDashboardDAO  {
	
	public List<DashboardDTO> consultarDashboard(); 


}
