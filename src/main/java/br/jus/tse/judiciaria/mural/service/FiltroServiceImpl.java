package br.jus.tse.judiciaria.mural.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.tse.corporativa.dto.ResultDTO;
import br.jus.tse.judiciaria.mural.dao.IFiltroDAO;
import br.jus.tse.corporativa.util.GsonUtil;

/**
 * Interface exemplo para a implementacao do contrato do servico de filtro.
 */


@Service
public class FiltroServiceImpl implements IFiltroService {

    @Autowired
    private IFiltroDAO filtroDAO;



    @Override
    public String getListaTipoDocumento() {  
        final ResultDTO resultado = new ResultDTO();
        resultado.setCollection(filtroDAO.getListaTipoDocumento());

    	return GsonUtil.toJsonSemAtributosNulos(resultado);
    	
    }
    
    @Override
    public String getListaUf() {  
        final ResultDTO resultado = new ResultDTO();
        resultado.setCollection(filtroDAO.getListaUF());

    	return GsonUtil.toJsonSemAtributosNulos(resultado);
    	
    }
    
    @Override
    public String getListaMunicipio(long sqUf) {  
        final ResultDTO resultado = new ResultDTO();
        resultado.setCollection(filtroDAO.getListaMunicipio(sqUf));

    	return GsonUtil.toJsonSemAtributosNulos(resultado);
    	
    }
    
    @Override
    public String getListaTribunal() {  
        final ResultDTO resultado = new ResultDTO();
        resultado.setCollection(filtroDAO.getTribunal());

    	return GsonUtil.toJsonSemAtributosNulos(resultado);
    	
    }
    
    @Override
    public String getListaUnidade() {  
        final ResultDTO resultado = new ResultDTO();
        resultado.setCollection(filtroDAO.getUnidade());

    	return GsonUtil.toJsonSemAtributosNulos(resultado);
    	
    }


}
