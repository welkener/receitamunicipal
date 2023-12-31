package br.gov.ma.imperatriz.receitamunicipal.mb.configuracao;

import br.gov.ma.imperatriz.receitamunicipal.bo.configuracao.ErroSistemaBO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.configuracao.ErroSistema;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Ayslan
 */
@Named
@ViewScoped
public class ErroSistemaMB extends AbstractBaseBean<ErroSistema> implements Serializable {

    @EJB
    private ErroSistemaBO erroSistemaBO;

    @Override
    public AbstractBusinessObject getBO() {
        return erroSistemaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id DESC";
    }
}
