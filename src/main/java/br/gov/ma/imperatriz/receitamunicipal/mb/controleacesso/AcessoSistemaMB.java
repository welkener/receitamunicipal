package br.gov.ma.imperatriz.receitamunicipal.mb.controleacesso;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import javax.ejb.EJB;
import br.gov.ma.imperatriz.receitamunicipal.bo.controleacesso.AcessoSistemaBO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.AcessoSistema;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ayslan
 */
@Named
@ViewScoped
public class AcessoSistemaMB extends AbstractBaseBean<AcessoSistema> implements Serializable {

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
    public boolean isAuditQuery() {
        return true;
    }
}
