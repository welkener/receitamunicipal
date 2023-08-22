package br.gov.ma.imperatriz.receitamunicipal.dao.exemplo.impl;

import br.gov.ma.imperatriz.receitamunicipal.application.BaseDAOImpl;
import br.gov.ma.imperatriz.receitamunicipal.dao.exemplo.PessoaExemploDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.exemplo.PessoaExemplo;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class PessoaExemploDAOImpl extends BaseDAOImpl<PessoaExemplo> implements PessoaExemploDAO {

    @Override
    public Class getEntityClass() {
        return PessoaExemplo.class;
    }

}
