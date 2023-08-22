package br.gov.ma.imperatriz.receitamunicipal.mb.controleacesso;


import br.gov.ma.imperatriz.receitamunicipal.bo.controleacesso.AcessoSistemaBO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.AcessoSistema;
import br.gov.ma.imperatriz.receitamunicipal.util.SessaoUtils;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import javax.ejb.EJB;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ayslan
 */
@Named
@ViewScoped
public class AcessoSistemaUsuarioMB extends AbstractBaseBean<AcessoSistema> implements Serializable {

    @EJB
    private AcessoSistemaBO acessoSistemaBO;

    @Override
    public AbstractBusinessObject getBO() {
        return acessoSistemaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id DESC";
    }

    @Override
    public List<Restriction> getDataModelRestrictions() {
        return new Restrictions().add("usuario", SessaoUtils.getUser());
    }
    
    
}
