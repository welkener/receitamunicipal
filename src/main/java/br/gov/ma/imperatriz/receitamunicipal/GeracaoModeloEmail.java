package br.gov.ma.imperatriz.receitamunicipal;

import br.gov.ma.imperatriz.receitamunicipal.dao.DAO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.email.ConfiguracaoEmail;
import br.gov.ma.imperatriz.receitamunicipal.modelo.email.ModeloEmail;
import br.gov.ma.imperatriz.receitamunicipal.modelo.email.TipoAssuntoEmail;
import com.xpert.persistence.dao.BaseDAO;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author ayslan
 */
@Stateless
public class GeracaoModeloEmail {

    @EJB
    private DAO dao;
    private static final Logger logger = Logger.getLogger(GeracaoModeloEmail.class.getName());

    public <T> BaseDAO<T> getDAO(Class<T> entity) {
        return dao.getDAO(entity);
    }

    public void generate() {

        String email = "xpert.testes@gmail.com";
        
        ConfiguracaoEmail configuracaoEmail = getDAO(ConfiguracaoEmail.class).unique("email", email);
        if (configuracaoEmail == null) {
            configuracaoEmail = new ConfiguracaoEmail();
            configuracaoEmail.setNome("[receitamunicipal]");
            configuracaoEmail.setEmail(email);
            configuracaoEmail.setUsuario(email);
            configuracaoEmail.setSenha("xpert@12345");
            configuracaoEmail.setHostName("smtp.gmail.com");
            configuracaoEmail.setSsl(false);
            configuracaoEmail.setTls(true);
            configuracaoEmail.setSmtpPort(587);
            configuracaoEmail = getDAO(ConfiguracaoEmail.class).merge(configuracaoEmail, false);
        }

        salvarModeloEmail("[receitamunicipal] Cadastro de Usuario", TipoAssuntoEmail.NOVO_USUARIO_SISTEMA, configuracaoEmail);
        salvarModeloEmail("[receitamunicipal] Recuperacao de Senha", TipoAssuntoEmail.RECUPERACAO_SENHA, configuracaoEmail);
    }

    public void salvarModeloEmail(String assunto, TipoAssuntoEmail tipoAssuntoEmail, ConfiguracaoEmail configuracaoEmail) {

        BaseDAO<ModeloEmail> dao = getDAO(ModeloEmail.class);
        ModeloEmail modeloEmail = dao.unique("tipoAssuntoEmail", tipoAssuntoEmail);

        //caso encontre o modelo ja cadastrado, nao fazer nada
        if (modeloEmail != null) {
            return;
        }
        try {
            String layout = getLayout(tipoAssuntoEmail);
            if (layout == null) {
                return;
            }
            modeloEmail = new ModeloEmail();
            modeloEmail.setAssunto(assunto);
            modeloEmail.setLayout(layout);
            modeloEmail.setConfiguracaoEmail(configuracaoEmail);
            modeloEmail.setTipoAssuntoEmail(tipoAssuntoEmail);
            dao.saveOrMerge(modeloEmail, false);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
            return;
        }

    }

    public static String getLayout(TipoAssuntoEmail tipoAssuntoEmail) throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/email/" + tipoAssuntoEmail.name().toLowerCase() + ".html");
        if (inputStream == null) {
            logger.log(Level.WARNING, "Template para o email {0} nao encontrado", tipoAssuntoEmail);
            return null;
        }
        return IOUtils.toString(inputStream, "UTF-8");
    }

    public static void main(String[] args) {
        try {
            System.out.println(getLayout(TipoAssuntoEmail.NOVO_USUARIO_SISTEMA));
        } catch (IOException ex) {
            Logger.getLogger(GeracaoModeloEmail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
