package br.jus.tse.judiciaria.mural.entidade;

import br.jus.tse.corporativa.entidade.AbstractEntidadePK;
import br.jus.tse.judiciaria.mural.util.ConstantsProjeto;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "TIPO_PARTE", schema = ConstantsProjeto.ENTITY.SCHEMA)
@AttributeOverride(column = @Column(name = "SQ_TIPO_PARTE"), name = "id")
@SequenceGenerator(name = "default_gen", sequenceName = ConstantsProjeto.ENTITY.SCHEMA + ".SQ_TIPO_PARTE",
allocationSize = 1, initialValue = 1)
public class TipoParte  extends AbstractEntidadePK<Long> {


    
    public TipoParte() {
        super();
    }

    public TipoParte(final Long id) {
        super();
        super.setId(id);
    }
    
    
     
    @Column(name = "NM_TIPO_PARTE")
    private String nome;
    


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}











    
}
