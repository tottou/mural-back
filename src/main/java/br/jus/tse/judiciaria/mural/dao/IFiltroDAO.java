package br.jus.tse.judiciaria.mural.dao;

import java.util.List;

import br.jus.tse.judiciaria.mural.dto.MunicipioDTO;
import br.jus.tse.judiciaria.mural.dto.TipoDocumentoDTO;
import br.jus.tse.judiciaria.mural.dto.TribunalDTO;
import br.jus.tse.judiciaria.mural.dto.UfDTO;
import br.jus.tse.judiciaria.mural.dto.UnidadeDTO;

/**
 * Interface exemplo para a implementacao do contrato do servico de filtro.
 */
public interface IFiltroDAO  {
	
	public List<TipoDocumentoDTO> getListaTipoDocumento();
	
	public List<UfDTO> getListaUF();
	
	public List<MunicipioDTO> getListaMunicipio(long sqUF);

	public List<TribunalDTO> getTribunal();

	public List<UnidadeDTO> getUnidade();

}
