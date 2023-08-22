package br.gov.ma.imperatriz.receitamunicipal.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
