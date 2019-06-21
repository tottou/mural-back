package br.jus.tse.judiciaria.mural.dto;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;


import org.dozer.Mapping;

public class AdvogadoDTO extends AbstractBaseDTO<Long> {


    @Mapping("nome")
    private String nome;


    @Mapping("numero")
    private String numero;
    

    



    

}
