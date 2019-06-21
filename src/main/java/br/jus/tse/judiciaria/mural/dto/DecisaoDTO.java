package br.jus.tse.judiciaria.mural.dto;

import br.jus.tse.corporativa.dto.AbstractBaseDTO;

import java.util.Date;
import java.util.Set;

import org.dozer.Mapping;

public class DecisaoDTO extends AbstractBaseDTO<Long> {


    @Mapping("dataDecisao")
    private Date dataDecisao;


    @Mapping("origemDecisao")
    private String origemDecisao;
    
    @Mapping("partes")
    private Set<ParteDTO> partes;
    
    @Mapping("usuarios")
    private Set<UsuarioEnvioDTO> usuarios;
    
	



    

}
