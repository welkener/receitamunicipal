package br.gov.ma.imperatriz.receitamunicipal.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.AcessoSistema;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface AcessoSistemaDAO extends BaseDAO<AcessoSistema> {
    
}
