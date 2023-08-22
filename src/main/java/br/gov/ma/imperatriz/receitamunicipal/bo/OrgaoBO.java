package br.gov.ma.imperatriz.receitamunicipal.bo;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.ma.imperatriz.receitamunicipal.dao.OrgaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.validation.UniqueFields;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.Orgao;

/**
 *
 * @author dalfredewelkenerlima
 */
@Stateless
public class OrgaoBO extends AbstractBusinessObject<Orgao> {

    @EJB
    private OrgaoDAO orgaoDAO;
    
    @Override
    public OrgaoDAO getDAO() {
        return orgaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return UniqueFields.from(Orgao.class);
    }

    @Override
    public void validate(Orgao orgao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
