package br.jus.tse.judiciaria.mural.dto;

import org.dozer.Mapping;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;

public class DashboardDTO extends AbstractBaseDTO<Long> {

	@Mapping("tribunal")
    private String tribunal;

	@Mapping("quantidade")
    private int qtd;
    
    public DashboardDTO(long id, String tribunal, int qtd) {
    	setId(id);
		this.tribunal=tribunal;
		this.qtd=qtd;
	}

	public String getTribunal() {
		return tribunal;
	}

	public void setTribunal(String tribunal) {
		this.tribunal = tribunal;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}









    

}
