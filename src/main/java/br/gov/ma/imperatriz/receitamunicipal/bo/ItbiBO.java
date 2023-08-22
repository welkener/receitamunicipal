package br.gov.ma.imperatriz.receitamunicipal.bo;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.ma.imperatriz.receitamunicipal.dao.ItbiDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.validation.UniqueFields;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.ma.imperatriz.receitamunicipal.modelo.itbi.Itbi;

/**
 *
 * @author dalfredewelkenerlima
 */
@Stateless
public class ItbiBO extends AbstractBusinessObject<Itbi> {

    @EJB
    private ItbiDAO itbiDAO;
    
    @Override
    public ItbiDAO getDAO() {
        return itbiDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return UniqueFields.from(Itbi.class);
    }

    @Override
    public void validate(Itbi itbi) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
