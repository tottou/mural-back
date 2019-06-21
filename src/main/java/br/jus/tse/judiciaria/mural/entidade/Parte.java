package br.jus.tse.judiciaria.mural.entidade;

import br.jus.tse.corporativa.entidade.AbstractEntidadePK;
import br.jus.tse.judiciaria.mural.util.ConstantsProjeto;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "PARTE", schema = ConstantsProjeto.ENTITY.SCHEMA)
@AttributeOverride(column = @Column(name = "SQ_PARTE"), name = "id")
@SequenceGenerator(name = "default_gen", sequenceName = ConstantsProjeto.ENTITY.SCHEMA + ".SQ_PARTE",
allocationSize = 1, initialValue = 1)
public class Parte  extends AbstractEntidadePK<Long> {


    
    public Parte() {
        super();
    }

    public Parte(final Long id) {
        super();
        super.setId(id);
    }
    
    
     
    @Column(name = "NM_PARTE")
    private String nome;
    
    
    @Column(name = "GR_ORDEM")
    private Integer ordem;
    
    
    @ManyToMany
    @JoinTable(
        name = "ADVOGADO_PARTE", 
        joinColumns = { @JoinColumn(name = "SQ_PARTE") }, 
        inverseJoinColumns = { @JoinColumn(name = "SQ_ADVOGADO") })
    @Fetch(FetchMode.JOIN)
    private Set<Advogado> advogados;
    
    @ManyToOne
    @JoinColumn(name = "SQ_DECISAO")    
    private Decisao decisao;
    
 /*   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SQ_DECISAO", referencedColumnName = "SQ_DECISAO")
    @Fetch(FetchMode.JOIN)
    private Decisao decisao;*/



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

/*	public Decisao getDecisao() {
		return decisao;
	}

	public void setDecisao(Decisao decisao) {
		this.decisao = decisao;
	}*/










    
}
