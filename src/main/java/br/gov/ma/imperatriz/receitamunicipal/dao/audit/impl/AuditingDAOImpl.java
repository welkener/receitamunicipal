package br.gov.ma.imperatriz.receitamunicipal.dao.audit.impl;

import br.gov.ma.imperatriz.receitamunicipal.application.BaseDAOImpl;
import br.gov.ma.imperatriz.receitamunicipal.dao.audit.AuditingDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.audit.Auditing;
import javax.ejb.Stateless;

/**
 *
 * @author Ayslan
 */
@Stateless
public class AuditingDAOImpl extends BaseDAOImpl<Auditing> implements AuditingDAO {

    @Override
    public Class getEntityClass() {
        return Auditing.class;
    }

}
