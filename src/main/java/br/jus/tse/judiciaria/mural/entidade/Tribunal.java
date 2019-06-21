package br.jus.tse.judiciaria.mural.entidade;

import br.jus.tse.corporativa.entidade.AbstractEntidadePK;
import br.jus.tse.judiciaria.mural.util.ConstantsProjeto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "TRIBUNAL", schema = ConstantsProjeto.ENTITY.SCHEMA)
@AttributeOverride(column = @Column(name = "SQ_TRIBUNAL"), name = "id")
@SequenceGenerator(name = "default_gen", sequenceName = ConstantsProjeto.ENTITY.SCHEMA + ".SQ_TRIBUNAL",
allocationSize = 1, initialValue = 1)
public class Tribunal  extends AbstractEntidadePK<Long> {


    
    public Tribunal() {
        super();
    }

    public Tribunal(final Long id) {
        super();
        super.setId(id);
    }
    
    @Id
    @Column(name = "SQ_TRIBUNAL")
    private Long sqTribunal;
    
    @Column(name = "SG_TRIBUNAL")
    private String sigla;
    
    @Column(name = "NM_TRIBUNAL")
    private String nome;

    @Column(name = "NR_TRIBUNAL")
    private int numero;

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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Long getSqTribunal() {
		return sqTribunal;
	}

	public void setSqTribunal(Long sqTribunal) {
		this.sqTribunal = sqTribunal;
	}



    

    



    
}
