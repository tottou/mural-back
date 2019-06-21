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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "INSTANCIA", schema = ConstantsProjeto.ENTITY.SCHEMA)
@AttributeOverride(column = @Column(name = "SQ_INSTANCIA"), name = "id")
@SequenceGenerator(name = "default_gen", sequenceName = ConstantsProjeto.ENTITY.SCHEMA + ".SQ_INSTANCIA",
allocationSize = 1, initialValue = 1)
public class Instancia  extends AbstractEntidadePK<Long> {


    
    public Instancia() {
        super();
    }

    public Instancia(final Long id) {
        super();
        super.setId(id);
    }
    
    @Id
    @Column(name = "SQ_INSTANCIA")
    private Long sqInstancia;

    @Column(name = "NR_ZONA", nullable=true)
    private Integer numero;
    
    @Column(name = "SQ_TRIBUNAL")
    private Long sqTribunal;
    
    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn(name = "SQ_TRIBUNAL", referencedColumnName = "SQ_TRIBUNAL")
    @Fetch(FetchMode.JOIN)
    private Set<Tribunal> tribunais;    



	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Long getSqTribunal() {
		return sqTribunal;
	}

	public void setSqTribunal(Long sqTribunal) {
		this.sqTribunal = sqTribunal;
	}

	public Long getSqInstancia() {
		return sqInstancia;
	}

	public void setSqInstancia(Long sqInstancia) {
		this.sqInstancia = sqInstancia;
	}    
        


    

    



    
}
