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
@Table(name = "USUARIO_ENVIO", schema = ConstantsProjeto.ENTITY.SCHEMA)
@AttributeOverride(column = @Column(name = "SQ_USUARIO_ENVIO"), name = "id")
@SequenceGenerator(name = "default_gen", sequenceName = ConstantsProjeto.ENTITY.SCHEMA + ".SQ_USUARIO_ENVIO",
allocationSize = 1, initialValue = 1)
public class UsuarioEnvio  extends AbstractEntidadePK<Long> {


    
    public UsuarioEnvio() {
        super();
    }

    public UsuarioEnvio(final Long id) {
        super();
        super.setId(id);
    }
    
    @Id
    @Column(name = "SQ_USUARIO_ENVIO")
    private Long sqUsuario;

    @Column(name = "ID_USUARIO")
    private String idUsuario;

   
    @Column(name = "NM_USUARIO")
    private String nome;
    
    @Column(name = "DS_UNIDADE_USUARIO")
    private String unidade;
    
    
    @Column(name = "SQ_INSTANCIA")
    private Long sqInstancia;
    
    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn(name = "SQ_INSTANCIA", referencedColumnName = "SQ_INSTANCIA")
    @Fetch(FetchMode.JOIN)
    private Set<Instancia> zonas;




	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getSqInstancia() {
		return sqInstancia;
	}

	public void setSqInstancia(Long sqInstancia) {
		this.sqInstancia = sqInstancia;
	}


	public Long getSqUsuario() {
		return sqUsuario;
	}

	public void setSqUsuario(Long sqUsuario) {
		this.sqUsuario = sqUsuario;
	}






    
}
