package br.jus.tse.judiciaria.mural.service;

/**
 * Interface exemplo para a implementacao do contrato do servico de filtro.
 */
public interface IFiltroService {

	 public String getListaTipoDocumento(); 
	
	 public String getListaUf();
	 
	 public String getListaMunicipio(long sqUf);

	 public String getListaTribunal();

	 public String getListaUnidade();
}
