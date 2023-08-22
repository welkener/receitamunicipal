package br.gov.ma.imperatriz.receitamunicipal.dao.impl;

import br.gov.ma.imperatriz.receitamunicipal.application.BaseDAOImpl;
import br.gov.ma.imperatriz.receitamunicipal.dao.ItbiDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.itbi.Itbi;
import javax.ejb.Stateless;

/**
 *
 * @author dalfredewelkenerlima
 */
@Stateless
public class ItbiDAOImpl extends BaseDAOImpl<Itbi> implements ItbiDAO {

    @Override
    public Class getEntityClass() {
        return Itbi.class;
    }

}
