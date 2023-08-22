package br.gov.ma.imperatriz.receitamunicipal.mb.padrao;

import br.gov.ma.imperatriz.receitamunicipal.modelo.itbi.Itbi;
import br.gov.ma.imperatriz.receitamunicipal.modelo.itbi.TipoImovel;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.TipoLei;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.Orgao;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.TipoEsfera;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.Lei;
import br.gov.ma.imperatriz.receitamunicipal.modelo.tabelas.Municipio;
import br.gov.ma.imperatriz.receitamunicipal.modelo.tabelas.Uf;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.Permissao;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.Usuario;
import br.gov.ma.imperatriz.receitamunicipal.modelo.configuracao.ErroSistema;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.SituacaoUsuario;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.AcessoSistema;
import br.gov.ma.imperatriz.receitamunicipal.modelo.email.ConfiguracaoEmail;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.Perfil;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.ma.imperatriz.receitamunicipal.modelo.email.ModeloEmail;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.ma.imperatriz.receitamunicipal.modelo.email.TipoAssuntoEmail;
import br.gov.ma.imperatriz.receitamunicipal.modelo.controleacesso.TipoRecuperacaoSenha;
import com.xpert.audit.model.AuditingType;
import com.xpert.audit.model.QueryAuditingType;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClassMB {

    public Class getAcessoSistema() {
        return AcessoSistema.class;
    }

    public Class getErroSistema() {
        return ErroSistema.class;
    }

    public Class getHistoricoSituacaoUsuario() {
        return HistoricoSituacaoUsuario.class;
    }

    public Class getPerfil() {
        return Perfil.class;
    }

    public Class getPermissao() {
        return Permissao.class;
    }

    public Class getSituacaoUsuario() {
        return SituacaoUsuario.class;
    }

    public Class getUsuario() {
        return Usuario.class;
    }

    public Class getTipoAssuntoEmail() {
        return TipoAssuntoEmail.class;
    }

    public Class getModeloEmail() {
        return ModeloEmail.class;
    }

    public Class getSolicitacaoRecuperacaoSenha() {
        return SolicitacaoRecuperacaoSenha.class;
    }

    public Class getTipoRecuperacaoSenha() {
        return TipoRecuperacaoSenha.class;
    }

    public Class getConfiguracaoEmail() {
        return ConfiguracaoEmail.class;
    }

    public Class getMunicipio() {
        return Municipio.class;
    }
    public Class getUf() {
        return Uf.class;
    }
    public Class getAuditingType() {
        return AuditingType.class;
    }
    public Class getQueryAuditingType() {
        return QueryAuditingType.class;
    }

   

    public Class getItbi() {
        return Itbi.class;
    }
    public Class getTipoImovel() {
        return TipoImovel.class;
    }
    public Class getTipoLei() {
        return TipoLei.class;
    }
    public Class getOrgao() {
        return Orgao.class;
    }
    public Class getTipoEsfera() {
        return TipoEsfera.class;
    }
    public Class getLei() {
        return Lei.class;
    }

}