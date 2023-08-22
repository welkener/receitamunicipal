package br.gov.ma.imperatriz.receitamunicipal.dao.audit.impl;

import br.gov.ma.imperatriz.receitamunicipal.application.BaseDAOImpl;
import br.gov.ma.imperatriz.receitamunicipal.dao.audit.QueryAuditingDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.audit.QueryAuditing;
import javax.ejb.Stateless;

/**
 *
 * @author Ayslan
 */
@Stateless
public class QueryAuditingDAOImpl extends BaseDAOImpl<QueryAuditing> implements QueryAuditingDAO {

    @Override
    public Class getEntityClass() {
        return QueryAuditing.class;
    }
    
    
    
}
