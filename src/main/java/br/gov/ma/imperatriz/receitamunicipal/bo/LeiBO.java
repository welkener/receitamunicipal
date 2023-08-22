package br.gov.ma.imperatriz.receitamunicipal.bo;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.ma.imperatriz.receitamunicipal.dao.LeiDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.validation.UniqueFields;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.Lei;

/**
 *
 * @author dalfredewelkenerlima
 */
@Stateless
public class LeiBO extends AbstractBusinessObject<Lei> {

    @EJB
    private LeiDAO leiDAO;
    
    @Override
    public LeiDAO getDAO() {
        return leiDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return UniqueFields.from(Lei.class);
    }

    @Override
    public void validate(Lei lei) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
