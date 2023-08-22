package br.gov.ma.imperatriz.receitamunicipal.dao.controleacesso.impl;

import br.gov.ma.imperatriz.receitamunicipal.application.BaseDAOImpl;
import br.gov.ma.imperatriz.receitamunicipal.dao.controleacesso.UsuarioDAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.SituacaoUsuario;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.Usuario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Ayslan
 */
@Stateless
public class UsuarioDAOImpl extends BaseDAOImpl<Usuario> implements UsuarioDAO {

    @Override
    public Class getEntityClass() {
        return Usuario.class;
    }

    @Override
    public List<Usuario> getUsuariosAtivos() {
        return list("situacaoUsuario", SituacaoUsuario.ATIVO, "nome");
    }
    
    
}
