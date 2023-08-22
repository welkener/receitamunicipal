package br.gov.ma.imperatriz.receitamunicipal.mb.controleacesso;

import br.gov.ma.imperatriz.receitamunicipal.bo.controleacesso.UsuarioMenuBO;
import br.gov.ma.imperatriz.receitamunicipal.bo.controleacesso.PermissaoBO;
import br.gov.ma.imperatriz.receitamunicipal.dao.controleacesso.PermissaoDAO;
import br.gov.ma.imperatriz.receitamunicipal.mb.tema.UserThemeMB;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.Permissao;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.Usuario;
import com.xpert.security.model.User;
import com.xpert.security.session.AbstractUserSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.MenuModel;

/**
 * @ManagedBean que guarda o usuario logado e suas permissoess
 *
 * @author ayslan
 */
@Named
@SessionScoped
public class SessaoUsuarioMB extends AbstractUserSession implements Serializable {

    @EJB
    private PermissaoDAO permissaoDAO;
    @EJB
    private UsuarioMenuBO usuarioMenuBO;
    @EJB
    private PermissaoBO permissaoBO;
    private Usuario user;
    private List<Permissao> roles;
    private List<Permissao> atalhos;
    @Inject
    private SessaoFavoritosMB sessaoFavoritosMB;
    @Inject
    private UserThemeMB userThemeMB;
    private MenuModel menuModel;
    private SolicitacaoRecuperacaoSenha solicitacaoRecuperacaoSenha;

    @Override
    public void createSession() {
        //pegar permissoes do usuario
        roles = permissaoBO.getPermissoes(user, true);
        //pegar atalhos do usuario
        atalhos = permissaoDAO.getPermissoesAtalhos(user);
        //carregar os favoritos
        sessaoFavoritosMB.carregarFavoritos();
        //carregar tema
        userThemeMB.carregarTema();
        //criar o menu
        criarMenu();
        criarCaminhoPermissao();
        super.createSession();
        //iniciar lazy
        user.setPerfis(permissaoDAO.getInitialized(user.getPerfis()));
    }

   

    public void criarMenu() {
        menuModel = usuarioMenuBO.criarMenu(roles);
    }

    public void criarCaminhoPermissao() {
        permissaoBO.criarCaminhoPermissao(atalhos, false);
        permissaoBO.criarCaminhoPermissao(roles, true);
    }

    public List<Permissao> pesquisarPermissao(String query) {
        return permissaoBO.pesquisarPermissao(query, roles);
    }
    
   

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    @Override
    public void setUser(User user) {
        this.user = (Usuario) user;
    }

    @Override
    public Usuario getUser() {
        return user;
    }

    @Override
    public List getRoles() {
        return roles;
    }

    public List<Permissao> getAtalhos() {
        return atalhos;
    }

    public void setAtalhos(List<Permissao> atalhos) {
        this.atalhos = atalhos;
    }

    public SolicitacaoRecuperacaoSenha getSolicitacaoRecuperacaoSenha() {
        return solicitacaoRecuperacaoSenha;
    }

    public void setSolicitacaoRecuperacaoSenha(SolicitacaoRecuperacaoSenha solicitacaoRecuperacaoSenha) {
        this.solicitacaoRecuperacaoSenha = solicitacaoRecuperacaoSenha;
    }

    public SessaoFavoritosMB getSessaoFavoritosMB() {
        return sessaoFavoritosMB;
    }

    public void setSessaoFavoritosMB(SessaoFavoritosMB sessaoFavoritosMB) {
        this.sessaoFavoritosMB = sessaoFavoritosMB;
    }

    public UserThemeMB getUserThemeMB() {
        return userThemeMB;
    }

    public void setUserThemeMB(UserThemeMB userThemeMB) {
        this.userThemeMB = userThemeMB;
    }

    
    
}
