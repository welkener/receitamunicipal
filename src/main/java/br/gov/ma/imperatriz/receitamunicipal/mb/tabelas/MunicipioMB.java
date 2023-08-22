package br.gov.ma.imperatriz.receitamunicipal.mb.tabelas;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named; 
import br.gov.ma.imperatriz.receitamunicipal.bo.tabelas.MunicipioBO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.tabelas.Municipio;

/**
 *
 * @author ayslanms
 */
@Named
@ViewScoped
public class MunicipioMB extends AbstractBaseBean<Municipio> implements Serializable {

    @EJB
    private MunicipioBO municipioBO;

    @Override
    public MunicipioBO getBO() {
        return municipioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }
}
