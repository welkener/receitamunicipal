package br.gov.ma.imperatriz.receitamunicipal.application;

import br.gov.ma.imperatriz.receitamunicipal.dao.audit.QueryAuditingDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.audit.QueryAuditing;
import br.gov.ma.imperatriz.receitamunicipal.util.SessaoUtils;
import com.xpert.audit.QueryAuditPersister;
import com.xpert.audit.model.AbstractQueryAuditing;
import javax.ejb.EJB;
import javax.enterprise.inject.Default;
import javax.inject.Named;

/**
 * Implementacao padrao do QueryAuditPersister do xpert-framework utilizando CDI
 *
 * @author ayslanms
 */
@Default
@Named
public class QueryAuditPersisterImpl implements QueryAuditPersister {

    @EJB
    private QueryAuditingDAO queryAuditingDAO;

    @Override
    public void persist(AbstractQueryAuditing abstractQueryAuditing) {
        QueryAuditing queryAuditing = (QueryAuditing) abstractQueryAuditing;
        queryAuditing.setUsuario(SessaoUtils.getUser());
        queryAuditingDAO.save(queryAuditing, false);
    }

    @Override
    public int getSqlStringMaxSize() {
        return AbstractQueryAuditing.SQL_STRING_MAX_SIZE;
    }

    @Override
    public int getParametersMaxSize() {
        return AbstractQueryAuditing.SQL_STRING_MAX_SIZE;
    }

}
