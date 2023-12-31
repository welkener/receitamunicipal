package br.gov.ma.imperatriz.receitamunicipal.mb.dashboard;

import br.gov.ma.imperatriz.receitamunicipal.bo.audit.AuditingBO;
import br.gov.ma.imperatriz.receitamunicipal.bo.dashboard.DashboardAuditoriaConsultaBO;
import br.gov.ma.imperatriz.receitamunicipal.vo.audit.TabelaAuditoria;
import br.gov.ma.imperatriz.receitamunicipal.vo.dashboard.DashboardAuditoriaConsulta;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.Serializable;
import java.util.List;
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
public class DashboardAuditoriaConsultaMB implements Serializable {

    @EJB
    private DashboardAuditoriaConsultaBO dashboardAuditoriaBO;
    @EJB
    private AuditingBO auditingBO;

    private DashboardAuditoriaConsulta dashboardAuditoria;
    private List<TabelaAuditoria> tabelas;

    @PostConstruct
    public void init() {
        try {
            dashboardAuditoria = dashboardAuditoriaBO.getDashboardAuditoria();
            tabelas = auditingBO.getTabelasAuditoria();
        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    public void carregarDashboard() {
        try {
            dashboardAuditoriaBO.carregarDashboardAuditoria(dashboardAuditoria);
        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    public DashboardAuditoriaConsulta getDashboardAuditoria() {
        return dashboardAuditoria;
    }

    public void setDashboardAuditoria(DashboardAuditoriaConsulta dashboardAuditoria) {
        this.dashboardAuditoria = dashboardAuditoria;
    }

    public List<TabelaAuditoria> getTabelas() {
        return tabelas;
    }

    public void setTabelas(List<TabelaAuditoria> tabelas) {
        this.tabelas = tabelas;
    }
    
    

}
