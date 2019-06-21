package br.jus.tse.judiciaria.mural.entidade;

import br.jus.tse.corporativa.entidade.AbstractEntidadePK;
import br.jus.tse.judiciaria.mural.util.ConstantsProjeto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "PUBLICACAO", schema = ConstantsProjeto.ENTITY.SCHEMA)
@AttributeOverride(column = @Column(name = "SQ_PUBLICACAO"), name = "id")
@SequenceGenerator(name = "default_gen", sequenceName = ConstantsProjeto.ENTITY.SCHEMA + ".SQ_PUBLICACAO",
allocationSize = 1, initialValue = 1)
public class Publicacao  extends AbstractEntidadePK<Long> {


    
    public Publicacao() {
        super();
    }

    public Publicacao(final Long id) {
        super();
        super.setId(id);
    }
    
    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn(name = "SQ_DECISAO", referencedColumnName = "SQ_DECISAO")
    @Fetch(FetchMode.JOIN)
    private Set<Decisao> decisoes;

    @Column(name = "NR_PUBLICACAO", length = 30)
    private int numeroPublicacao;
    
    @Column(name = "SQ_DECISAO")
    private Long sqDecisao;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "DT_PUBLICACAO")
    private Date dataPublicacao;


	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public int getNumeroPublicacao() {
		return numeroPublicacao;
	}

	public void setNumeroPublicacao(int numeroPublicacao) {
		this.numeroPublicacao = numeroPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}


	public Set<Decisao> getDecisoes() {
		return decisoes;
	}

	public void setDecisoes(Set<Decisao> decisoes) {
		this.decisoes = decisoes;
	}

	public Long getSqDecisao() {
		return sqDecisao;
	}

	public void setSqDecisao(Long sqDecisao) {
		this.sqDecisao = sqDecisao;
	}




    
}
