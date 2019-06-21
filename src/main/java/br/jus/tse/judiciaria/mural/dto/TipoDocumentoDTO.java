package br.jus.tse.judiciaria.mural.dto;

import org.dozer.Mapping;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;

public class TipoDocumentoDTO extends AbstractBaseDTO<Long> {
	
	public TipoDocumentoDTO(long id, String nome) {
		setId(id);
		this.nome=nome;
	}
	

	
	@Mapping("nome")
    private String nome;





}
