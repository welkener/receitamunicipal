package br.gov.ma.imperatriz.receitamunicipal.dao;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.Lei;
import javax.ejb.Local;

/**
 *
 * @author dalfredewelkenerlima
 */
@Local
public interface LeiDAO extends BaseDAO<Lei> {
    
}
