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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "ADVOGADO", schema = ConstantsProjeto.ENTITY.SCHEMA)
@AttributeOverride(column = @Column(name = "SQ_ADVOGADO"), name = "id")
@SequenceGenerator(name = "default_gen", sequenceName = ConstantsProjeto.ENTITY.SCHEMA + ".SQ_ADVOGADO",
allocationSize = 1, initialValue = 1)
public class Advogado  extends AbstractEntidadePK<Long> {


    
    public Advogado() {
        super();
    }

    public Advogado(final Long id) {
        super();
        super.setId(id);
    }
    
    
     
    @Column(name = "NM_ADVOGADO")
    private String nome;
    
    
    @Column(name = "NR_OAB")
    private String numero;  
    
    @ManyToMany(mappedBy = "advogados")
    private Set<Parte> partes;




	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Set<Parte> getPartes() {
		return partes;
	}

	public void setPartes(Set<Parte> partes) {
		this.partes = partes;
	}












    
}
