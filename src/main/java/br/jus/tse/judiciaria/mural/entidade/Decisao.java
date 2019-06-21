package br.jus.tse.judiciaria.mural.entidade;

import br.jus.tse.corporativa.entidade.AbstractEntidadePK;
import br.jus.tse.judiciaria.mural.util.ConstantsProjeto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "DECISAO", schema = ConstantsProjeto.ENTITY.SCHEMA)
@AttributeOverride(column = @Column(name = "SQ_DECISAO"), name = "id")
@SequenceGenerator(name = "default_gen", sequenceName = ConstantsProjeto.ENTITY.SCHEMA + ".SQ_DECISAO",
allocationSize = 1, initialValue = 1)
public class Decisao  extends AbstractEntidadePK<Long> {


    
    public Decisao() {
        super();
    }

    public Decisao(final Long id) {
        super();
        super.setId(id);
    }
    
   /* @Id
    @Column(name = "SQ_DECISAO")
    private Long sqDecisao;
*/

    @Temporal(value = TemporalType.DATE)
    @Column(name = "DT_DECISAO")
    private Date dataDecisao;
    
    @Column(name = "NR_UNICO", length = 30)
    private String numeroUnico;

    @Column(name = "NR_PROCESSO", length = 13)
    private int numeroProcesso;
    
    @Lob
    @Column(name = "TX_DECISAO", length = 4000, columnDefinition="CLOB")
    private String textoDecisao;

    @Column(name = "ST_SEGREDO_JUSTICA", length = 1)
    private int segredoJustica;
    
    @Column(name = "ST_PRAZO_MP", length = 1)
    private int prazoMP;
    
    @Column(name = "TP_ORIGEM_DECISAO", length = 1)    
    private String origemDecisao;
    
    @Column(name = "SQ_USUARIO_ENVIO")
    private Long sqUsuarioEnvio;
    
    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn(name = "SQ_USUARIO_ENVIO", referencedColumnName = "SQ_USUARIO_ENVIO")
    @Fetch(FetchMode.JOIN)
    private Set<UsuarioEnvio> usuarios;
    
      
    @OneToMany(mappedBy = "decisao", targetEntity = Parte.class, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<Parte> partes;
    

 

	public Date getDataDecisao() {
		return dataDecisao;
	}

	public void setDataDecisao(Date dataDecisao) {
		this.dataDecisao = dataDecisao;
	}

	public String getNumeroUnico() {
		return numeroUnico;
	}

	public void setNumeroUnico(String numeroUnico) {
		this.numeroUnico = numeroUnico;
	}


	public int getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public String getTextoDecisao() {
		return textoDecisao;
	}

	public void setTextoDecisao(String textoDecisao) {
		this.textoDecisao = textoDecisao;
	}

	public int getSegredoJustica() {
		return segredoJustica;
	}

	public void setSegredoJustica(int segredoJustica) {
		this.segredoJustica = segredoJustica;
	}

	public int getPrazoMP() {
		return prazoMP;
	}

	public void setPrazoMP(int prazoMP) {
		this.prazoMP = prazoMP;
	}

	public String getOrigemDecisao() {
		return origemDecisao;
	}

	public void setOrigemDecisao(String origemDecisao) {
		this.origemDecisao = origemDecisao;
	}



	public Long getSqUsuarioEnvio() {
		return sqUsuarioEnvio;
	}

	public void setSqUsuarioEnvio(Long sqUsuarioEnvio) {
		this.sqUsuarioEnvio = sqUsuarioEnvio;
	}


    
    
}
