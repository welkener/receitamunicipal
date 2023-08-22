package br.gov.ma.imperatriz.receitamunicipal.mb.email;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import br.gov.ma.imperatriz.receitamunicipal.bo.email.ModeloEmailBO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.email.ModeloEmail;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ayslan
 */
@Named
@ViewScoped
public class ModeloEmailMB extends AbstractBaseBean<ModeloEmail> implements Serializable {

    @EJB
    private ModeloEmailBO modeloEmailBO;

    @Override
    public ModeloEmailBO getBO() {
        return modeloEmailBO;
    }

    @Override
    public String getDataModelOrder() {
        return "assunto";
    }
}
