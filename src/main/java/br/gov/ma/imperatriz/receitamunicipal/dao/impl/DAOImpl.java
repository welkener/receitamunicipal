package br.gov.ma.imperatriz.receitamunicipal.dao.impl;

import br.gov.ma.imperatriz.receitamunicipal.application.BaseDAOImpl;
import br.gov.ma.imperatriz.receitamunicipal.dao.DAO;
import com.xpert.persistence.dao.BaseDAO;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class DAOImpl extends BaseDAOImpl implements DAO {

    @Override
    public <T> BaseDAO<T> getDAO(Class<T> entity) {
        this.setEntityClass(entity);
        return this;
    }
}
