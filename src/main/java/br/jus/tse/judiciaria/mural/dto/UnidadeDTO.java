package br.jus.tse.judiciaria.mural.dto;

import org.dozer.Mapping;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;

public class UnidadeDTO extends AbstractBaseDTO<Long> {
	
	public UnidadeDTO(long id,  String nome) {
		setId(id);
		this.nome=nome;
	}
	
	

	
	@Mapping("nome")
    private String nome;
	





}
