package br.gov.ma.imperatriz.receitamunicipal.dao.tabelas.impl;

import br.gov.ma.imperatriz.receitamunicipal.application.BaseDAOImpl;
import br.gov.ma.imperatriz.receitamunicipal.dao.tabelas.UfDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.tabelas.Uf;
import javax.ejb.Stateless;

/**
 *
 * @author ayslanms
 */
@Stateless
public class UfDAOImpl extends BaseDAOImpl<Uf> implements UfDAO {

    @Override
    public Class getEntityClass() {
        return Uf.class;
    }

}
