package br.gov.ma.imperatriz.receitamunicipal.bo.tabelas;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.ma.imperatriz.receitamunicipal.dao.tabelas.UfDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.ma.imperatriz.receitamunicipal.modelo.tabelas.Uf;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author ayslanms
 */
@Stateless
public class UfBO extends AbstractBusinessObject<Uf> {

    @EJB
    private UfDAO ufDAO;
    
    @Override
    public UfDAO getDAO() {
        return ufDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return UniqueFields.from(Uf.class);
    }

    @Override
    public void validate(Uf uf) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
