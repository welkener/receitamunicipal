package br.gov.ma.imperatriz.receitamunicipal.dao.tabelas.impl;

import br.gov.ma.imperatriz.receitamunicipal.application.BaseDAOImpl;
import br.gov.ma.imperatriz.receitamunicipal.dao.tabelas.MunicipioDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.tabelas.Municipio;
import javax.ejb.Stateless;

/**
 *
 * @author ayslanms
 */
@Stateless
public class MunicipioDAOImpl extends BaseDAOImpl<Municipio> implements MunicipioDAO {

    @Override
    public Class getEntityClass() {
        return Municipio.class;
    }

}
