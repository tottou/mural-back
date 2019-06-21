package br.jus.tse.judiciaria.mural.dto;

import java.util.Set;

import org.dozer.Mapping;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;

public class ParteDTO extends AbstractBaseDTO<Long> {	


   
	@Mapping("nome")
    private String nome;
    
	@Mapping("ordem")
    private Integer ordem;    

	@Mapping("advogados")
	private Set<AdvogadoDTO> advogados;
    



}
