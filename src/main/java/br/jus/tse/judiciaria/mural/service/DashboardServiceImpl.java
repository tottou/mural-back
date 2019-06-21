package br.jus.tse.judiciaria.mural.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.tse.corporativa.dto.ResultDTO;
import br.jus.tse.judiciaria.mural.dao.IDashboardDAO;
import br.jus.tse.corporativa.util.GsonUtil;

/**
 * Interface exemplo para a implementacao do contrato do servico de filtro.
 */


@Service
public class DashboardServiceImpl implements IDashboardService {

    @Autowired
    private IDashboardDAO dashboardDAO;



    @Override
    public String consultarDashboard() {  
        final ResultDTO resultado = new ResultDTO();
        resultado.setCollection(dashboardDAO.consultarDashboard());

    	return GsonUtil.toJsonSemAtributosNulos(resultado);
    	
    }


}
