package br.gov.ma.imperatriz.receitamunicipal.dao.impl;

import br.gov.ma.imperatriz.receitamunicipal.application.BaseDAOImpl;
import br.gov.ma.imperatriz.receitamunicipal.dao.LeiDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.Lei;
import javax.ejb.Stateless;

/**
 *
 * @author dalfredewelkenerlima
 */
@Stateless
public class LeiDAOImpl extends BaseDAOImpl<Lei> implements LeiDAO {

    @Override
    public Class getEntityClass() {
        return Lei.class;
    }

}
