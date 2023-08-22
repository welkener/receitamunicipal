package br.gov.ma.imperatriz.receitamunicipal.mb;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named; 
import br.gov.ma.imperatriz.receitamunicipal.bo.ItbiBO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.itbi.Itbi;

/**
 *
 * @author dalfredewelkenerlima
 */
@Named
@ViewScoped
public class ItbiMB extends AbstractBaseBean<Itbi> implements Serializable {

    @EJB
    private ItbiBO itbiBO;

    @Override
    public ItbiBO getBO() {
        return itbiBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
