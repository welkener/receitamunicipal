package br.gov.ma.imperatriz.receitamunicipal.mb.dashboard;

import br.gov.ma.imperatriz.receitamunicipal.bo.dashboard.DashboardAcessoBO;
import br.gov.ma.imperatriz.receitamunicipal.vo.dashboard.DashboardAcesso;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ayslanms
 */
@Named
@ViewScoped
public class DashboardAcessoMB implements Serializable {

    @EJB
    private DashboardAcessoBO dashboardAcessoBO;

    private DashboardAcesso dashboardAcesso;

    @PostConstruct
    public void init() {
        try {
            dashboardAcesso = dashboardAcessoBO.getDashboardAcesso();
        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    public void carregarDashboard() {
        try {
            dashboardAcessoBO.carregarDashboardAcesso(dashboardAcesso);
        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    public DashboardAcesso getDashboardAcesso() {
        return dashboardAcesso;
    }

    public void setDashboardAcesso(DashboardAcesso dashboardAcesso) {
        this.dashboardAcesso = dashboardAcesso;
    }

}
