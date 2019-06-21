package br.jus.tse.judiciaria.mural.dto;

import org.dozer.Mapping;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;

public class UfDTO extends AbstractBaseDTO<Long> {
	
	public UfDTO(long id, String sigla, String nome) {
		setId(id);
		this.sigla=sigla;
		this.nome=nome;
	}
	
	
	@Mapping("sigla")
    private String sigla;
	
	@Mapping("nome")
    private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


    



}
