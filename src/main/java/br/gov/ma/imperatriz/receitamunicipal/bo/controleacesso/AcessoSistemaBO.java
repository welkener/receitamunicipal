package br.gov.ma.imperatriz.receitamunicipal.bo.controleacesso;

import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.persistence.dao.BaseDAO;
import br.gov.ma.imperatriz.receitamunicipal.dao.controleacesso.AcessoSistemaDAO;
import br.gov.ma.imperatriz.receitamunicipal.dao.controleacesso.UsuarioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.AcessoSistema;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.Usuario;
import com.xpert.faces.utils.FacesUtils;
import java.util.Date;

/**
 *
 * @author ayslan
 */
@Stateless
public class AcessoSistemaBO extends AbstractBusinessObject<AcessoSistema> {

    @EJB
    private AcessoSistemaDAO acessoSistemaDAO;
    
    @EJB
    private UsuarioDAO usuarioDAO;

    @Override
    public BaseDAO getDAO() {
        return acessoSistemaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    /**
     * Registra um acesso ao sistema de um usuario especifico
     *
     * @param usuario
     */
    public void save(Usuario usuario) {
        AcessoSistema acessoSistema = new AcessoSistema();
        acessoSistema.setDataHora(new Date());
        acessoSistema.setIp(FacesUtils.getIP());
        acessoSistema.setUserAgent(FacesUtils.getBrowser());
        acessoSistema.setUsuario(usuario);
        acessoSistemaDAO.saveOrMerge(acessoSistema, false);
        
        usuario.setDataUltimoAcesso(new Date());
        usuarioDAO.merge(usuario);
        
        
    }

    @Override
    public void validate(AcessoSistema acessoSistema) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
