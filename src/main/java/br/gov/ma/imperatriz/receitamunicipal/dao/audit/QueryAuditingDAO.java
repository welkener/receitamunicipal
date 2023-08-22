package br.gov.ma.imperatriz.receitamunicipal.dao.audit;

import br.gov.ma.imperatriz.receitamunicipal.modelo.audit.QueryAuditing;
import com.xpert.persistence.dao.BaseDAO;
import javax.ejb.Local;

/**
 *
 * @author Ayslan
 */
@Local
public interface QueryAuditingDAO extends BaseDAO<QueryAuditing> {
    
}
