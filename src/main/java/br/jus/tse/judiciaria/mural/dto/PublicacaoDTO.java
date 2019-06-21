package br.jus.tse.judiciaria.mural.dto;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;
import java.util.Date;
import java.util.Set;

import org.dozer.Mapping;

public class PublicacaoDTO extends AbstractBaseDTO<Long> {


    @Mapping("dataPublicacao")
    private Date dataPublicacao;


    @Mapping("numeroPublicacao")
    private int numeroPublicacao;
    
    @Mapping("decisoes")
    private Set<DecisaoDTO> decisoes;


    

}
