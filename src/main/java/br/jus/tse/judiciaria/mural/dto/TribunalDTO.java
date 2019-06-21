package br.jus.tse.judiciaria.mural.dto;

import org.dozer.Mapping;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;

public class TribunalDTO extends AbstractBaseDTO<Long> {
	
	public TribunalDTO(long id, String sigla, String nome, long numero) {
		setId(id);
		this.sigla=sigla;
		this.nome=nome;
		this.numero=numero;
	}
	
	
	@Mapping("sigla")
    private String sigla;
	
	@Mapping("nome")
    private String nome;
	
	@Mapping("numero")
	private long numero;

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

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}
   



}
