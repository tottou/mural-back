package br.jus.tse.judiciaria.mural.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.jus.tse.judiciaria.mural.dto.MunicipioDTO;
import br.jus.tse.judiciaria.mural.dto.TipoDocumentoDTO;
import br.jus.tse.judiciaria.mural.dto.TribunalDTO;
import br.jus.tse.judiciaria.mural.dto.UfDTO;
import br.jus.tse.judiciaria.mural.dto.UnidadeDTO;

/**
 * Classe exemplo para a implementacao da classe de dao do publicacao.
 */
@Repository
public class FiltroDAOImpl implements IFiltroDAO{
	
	
	  @PersistenceContext
	    private EntityManager entityManager;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoDocumentoDTO> getListaTipoDocumento()  {
		
		StringBuilder hql = new StringBuilder();		
		hql.append("SELECT  td.sq_tipo_documento, td.ds_tipo_documento FROM tipo_documento td ");
		hql.append("order by 2  ");
		
		
		Query query =this.entityManager.createNativeQuery(hql.toString());
		
		List<Object[]> rows = query.getResultList();
		List<TipoDocumentoDTO> result = new ArrayList<>(rows.size());		
		for (Object[] row : rows) {
			BigDecimal numId = (BigDecimal)row[0];
			int id = Integer.valueOf(numId.intValue());
		    result.add(new TipoDocumentoDTO(id,(String) row[1] ));
		}
		
		return result;
		
		


	}
	
	@Override
	public List<UfDTO> getListaUF()  {
		
		StringBuilder hql = new StringBuilder();		
		hql.append("SELECT u.sq_uf, u.sg_uf, u.nm_uf  FROM uf u ");
		hql.append("order by 2  ");
		
		
		Query query =this.entityManager.createNativeQuery(hql.toString());				
		
		@SuppressWarnings("unchecked")
		List<Object[]> rows = query.getResultList();
		List<UfDTO> result = new ArrayList<>(rows.size());		
		for (Object[] row : rows) {
			BigDecimal numId = (BigDecimal)row[0];
			int id = Integer.valueOf(numId.intValue());
		    result.add(new UfDTO(id,(String) row[1], (String) row[2]));
		}
		
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MunicipioDTO> getListaMunicipio(long sqUF)  {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT  m.sq_municipio, m.nm_municipio  FROM municipio m where m.sq_uf= :uf ");
		hql.append("order by 2  ");
		
		Query query =this.entityManager.createNativeQuery(hql.toString());
		query.setParameter("uf", sqUF);	
		List<Object[]> rows = query.getResultList();
		List<MunicipioDTO> result = new ArrayList<>(rows.size());		
		for (Object[] row : rows) {
			BigDecimal numId = (BigDecimal)row[0];
			int id = Integer.valueOf(numId.intValue());
		    result.add(new MunicipioDTO(id,(String) row[1] ));
		}
		
		return result;
		
	}
	
	@Override
	public List<TribunalDTO> getTribunal()  {
		
		StringBuilder hql = new StringBuilder();		
		hql.append("SELECT a.sq_tribunal, a.sg_tribunal, a.nm_tribunal, a.nr_tribunal FROM tribunal a ");
		hql.append("order by 1  ");
		
		
		Query query =this.entityManager.createNativeQuery(hql.toString());				
		
		@SuppressWarnings("unchecked")
		List<Object[]> rows = query.getResultList();
		List<TribunalDTO> result = new ArrayList<>(rows.size());		
		for (Object[] row : rows) {
			BigDecimal numId = (BigDecimal)row[0];
			int id = Integer.valueOf(numId.intValue());
			BigDecimal num = (BigDecimal)row[3];
			int numero = Integer.valueOf(num.intValue());
		    result.add(new TribunalDTO(id,(String) row[1], (String) row[2], numero));
		}
		
		return result;
		
	}
	
	@Override
	public List<UnidadeDTO> getUnidade()  {
		
		StringBuilder hql = new StringBuilder();		
		hql.append("SELECT distinct a.ds_unidade_usuario, a.sq_instancia "+
  " FROM usuario_envio a where a.ds_unidade_usuario is not null ");
		hql.append("order by 1  ");
		
		
		Query query =this.entityManager.createNativeQuery(hql.toString());				
		
		@SuppressWarnings("unchecked")
		List<Object[]> rows = query.getResultList();
		List<UnidadeDTO> result = new ArrayList<>(rows.size());		
		for (Object[] row : rows) {
			BigDecimal numId = (BigDecimal)row[1];
			int id = Integer.valueOf(numId.intValue());
		    result.add(new UnidadeDTO(id,(String) row[0]));
		}
		
		return result;
		
	}

}
