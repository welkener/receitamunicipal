package br.gov.ma.imperatriz.receitamunicipal.mb.controleacesso;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import br.gov.ma.imperatriz.receitamunicipal.bo.controleacesso.SolicitacaoRecuperacaoSenhaBO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ayslan
 */
@Named
@ViewScoped
public class SolicitacaoRecuperacaoSenhaMB extends AbstractBaseBean<SolicitacaoRecuperacaoSenha> implements Serializable {

    @EJB
    private SolicitacaoRecuperacaoSenhaBO solicitacaoRecuperacaoSenhaBO;

    @Override
    public SolicitacaoRecuperacaoSenhaBO getBO() {
        return solicitacaoRecuperacaoSenhaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id DESC";
    }

    @Override
    public boolean isLoadEntityOnPostConstruct() {
        return false;
    }

    @Override
    public boolean isAuditQuery() {
        return true;
    }

}
