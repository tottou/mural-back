package br.jus.tse.judiciaria.mural.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.jus.tse.judiciaria.mural.dto.DashboardDTO;
import br.jus.tse.judiciaria.mural.dto.UfDTO;

/**
 * Classe exemplo para a implementacao da classe de dao do publicacao.
 */
@Repository
public class DashboardDAOImpl implements IDashboardDAO{
	
	
	  @PersistenceContext
	    private EntityManager entityManager;

	
	  @Override
		public List<DashboardDTO> consultarDashboard()  {
			
			StringBuilder hql = new StringBuilder();

	/*		
			hql.append("select   t.sg_tribunal, count(d.sq_decisao) ");
			hql.append("from    admmural_je.decisao d, ");
			hql.append("        admmural_je.instancia i, ");
			hql.append("        admmural_je.tribunal t, ");
			hql.append("        admmural_je.usuario_envio u, ");
			hql.append("        admmural_je.publicacao p ");
			hql.append(" where   t.sq_tribunal = i.sq_tribunal ");
			hql.append("    and i.sq_instancia = u.sq_instancia ");
			hql.append("  and u.sq_usuario_envio = d.sq_usuario_envio ");
			hql.append("   and d.sq_decisao=p.sq_decisao    ");
			hql.append("   and to_char(p.dt_publicacao, 'YYYY')= :ano ");
			hql.append("  group by t.sg_tribunal");
			hql.append(" order by 1 DESC");*/		
			
			hql.append("select * from ( ");
					hql.append("	select ");
					hql.append("	t.sq_tribunal, t.sg_tribunal,  count(d.sq_decisao) ");
					hql.append("from	admmural_je.decisao d,  admmural_je.instancia i,  admmural_je.tribunal t,  	admmural_je.usuario_envio u,  admmural_je.publicacao p     ");      
					hql.append("			where	t.sq_tribunal = i.sq_tribunal ");
					hql.append("			and i.sq_instancia = u.sq_instancia ");
					hql.append("		and u.sq_usuario_envio = d.sq_usuario_envio ");
				    hql.append("		and d.sq_decisao=p.sq_decisao AND    ");
					hql.append("			to_char(p.dt_publicacao, 'YYYY') = :ano    ");
					hql.append("			group by t.sg_tribunal, t.sq_tribunal ");
					hql.append("			union ");
					hql.append("			select t.sq_tribunal, t.sg_tribunal, 0 ");
					hql.append("			from admmural_je.tribunal t, admmural_je.instancia i ");
					hql.append("			where  ");
					hql.append("			 t.sq_tribunal = i.sq_instancia and ");
					hql.append("			i.sq_instancia not in (select ");
					hql.append("                       i.sq_instancia     from   admmural_je.decisao d,   admmural_je.instancia i,   admmural_je.tribunal t,   ");
					hql.append("                   admmural_je.usuario_envio u,   admmural_je.publicacao p          ");  
					hql.append("                     where   t.sq_tribunal = i.sq_tribunal ");
					hql.append("                     and i.sq_instancia = u.sq_instancia ");
					hql.append("                      and u.sq_usuario_envio = d.sq_usuario_envio ");
					hql.append("                        and d.sq_decisao=p.sq_decisao AND     ");
					hql.append("	                        to_char(p.dt_publicacao, 'YYYY') = :ano   )) ");
					hql.append("order by 1  ");
			
			
			
			
			Query query =this.entityManager.createNativeQuery(hql.toString());
			query.setParameter("ano", 2018);		
			
			List<Object[]> rows = query.getResultList();
			List<DashboardDTO> result = new ArrayList<>(rows.size());		
			for (Object[] row : rows) {
				BigDecimal num = (BigDecimal)row[2];
				int numero = Integer.valueOf(num.intValue());
				BigDecimal numId = (BigDecimal)row[0];
				int id = Integer.valueOf(numId.intValue());
			    result.add(new DashboardDTO(id,(String) row[1], numero));
			}
			
			return result;


		}



}
