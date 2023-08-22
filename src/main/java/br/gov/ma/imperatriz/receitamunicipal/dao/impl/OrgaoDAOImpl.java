package br.gov.ma.imperatriz.receitamunicipal.dao.impl;

import br.gov.ma.imperatriz.receitamunicipal.application.BaseDAOImpl;
import br.gov.ma.imperatriz.receitamunicipal.dao.OrgaoDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.Orgao;
import javax.ejb.Stateless;

/**
 *
 * @author dalfredewelkenerlima
 */
@Stateless
public class OrgaoDAOImpl extends BaseDAOImpl<Orgao> implements OrgaoDAO {

    @Override
    public Class getEntityClass() {
        return Orgao.class;
    }

}
