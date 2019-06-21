package br.jus.tse.judiciaria.mural.dto;

import org.dozer.Mapping;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;

public class MunicipioDTO extends AbstractBaseDTO<Long> {
	
	public MunicipioDTO(long id, String nome) {
		setId(id);
		this.nome=nome;
	}
		
	
	@Mapping("nome")
    private String nome;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


    



}
