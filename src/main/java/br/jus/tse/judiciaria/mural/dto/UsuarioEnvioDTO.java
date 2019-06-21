package br.jus.tse.judiciaria.mural.dto;

import java.util.Set;

import org.dozer.Mapping;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;

public class UsuarioEnvioDTO extends AbstractBaseDTO<Long> {
	

	
	
	@Mapping("nome")
    private String nome;
	
	@Mapping("zonas")
	private Set<InstanciaDTO> zonas;

	@Mapping("unidade")
    private String unidade;
	



}
