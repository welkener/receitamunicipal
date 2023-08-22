package br.gov.ma.imperatriz.receitamunicipal.mb.tabelas;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named; 
import br.gov.ma.imperatriz.receitamunicipal.bo.tabelas.UfBO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.tabelas.Uf;

/**
 *
 * @author ayslanms
 */
@Named
@ViewScoped
public class UfMB extends AbstractBaseBean<Uf> implements Serializable {

    @EJB
    private UfBO ufBO;

    @Override
    public UfBO getBO() {
        return ufBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }
}
