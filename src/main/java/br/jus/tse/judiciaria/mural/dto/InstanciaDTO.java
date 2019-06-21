package br.jus.tse.judiciaria.mural.dto;

import java.util.Set;

import org.dozer.Mapping;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;
import br.jus.tse.judiciaria.mural.entidade.Tribunal;

public class InstanciaDTO extends AbstractBaseDTO<Long> {
	

	
	@Mapping("numero")
    private Integer numero;	

	@Mapping("tribunais")
	private Set<Tribunal> tribunais;


	



}
