package br.gov.ma.imperatriz.receitamunicipal.mb;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named; 
import br.gov.ma.imperatriz.receitamunicipal.bo.OrgaoBO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.Orgao;

/**
 *
 * @author dalfredewelkenerlima
 */
@Named
@ViewScoped
public class OrgaoMB extends AbstractBaseBean<Orgao> implements Serializable {

    @EJB
    private OrgaoBO orgaoBO;

    @Override
    public OrgaoBO getBO() {
        return orgaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
