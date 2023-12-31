package br.gov.ma.imperatriz.receitamunicipal.handle;

import br.gov.ma.imperatriz.receitamunicipal.util.SessaoUtils;
import br.gov.ma.imperatriz.receitamunicipal.bo.configuracao.ErroSistemaBO;
import br.gov.ma.imperatriz.receitamunicipal.constante.Constantes;
import br.gov.ma.imperatriz.receitamunicipal.modelo.configuracao.ErroSistema;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.faces.utils.FacesUtils;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.jsoup.Jsoup;

/**
 * ExceptionHandler que trata os erros da aplicacao, caso seja um
 * ViewExpiredException o usuario deve ser redirecionado para a pagina inicial
 * caso seja outra excecao essa deve ser registrada usando a classe ErroSistema
 *
 * @see ErroSistema
 * @author ayslan
 */
public class ApplicationExceptionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;
    private static final String INDEX = "/index.jsf";
    private static final String ERRO = "/erro.jsf";
    private static final Logger logger = Logger.getLogger(ApplicationExceptionHandler.class.getName());
    private String pilhaErro;
    private ErroSistemaBO erroSistemaBO;

    public ApplicationExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {

        //Iterate over all unhandeled exceptions
        Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();

        while (i.hasNext()) {

            ExceptionQueuedEvent exceptionQueuedEvent = i.next();
            
            Throwable throwable = exceptionQueuedEvent.getContext().getException();
            logger.log(Level.SEVERE, "", throwable);

            pilhaErro = ErroSistemaBO.getStackTrace(throwable);
            try {
                //if view expired then redirect to index
                if (throwable instanceof ViewExpiredException) {
                    FacesUtils.redirect(INDEX);
                } else {
                    salvarErro(throwable, exceptionQueuedEvent.getContext().getContext());
                }
            } catch (Throwable ex) {
                //caso aconteça alguma exceção ao salva o erro, exibir o erro no log e mostrar na tela
                logger.log(Level.SEVERE, "Erro ao registrar exceção lançada", ex);
                FacesUtils.addToSession("erroSistema", Jsoup.clean(pilhaErro, Constantes.WHITE_LIST_HTML));
                FacesUtils.redirect(ERRO);
            } finally {
                //sempre remover a execeção
                i.remove();
            }
        }
        //let the parent handle the rest
        getWrapped().handle();

    }

    /**
     * Este metodo salva o erro erro. A classe ErroSistemaBO deve ser pega via
     * lookup pois nao existe injecao de dependencia nesse contexto
     *
     * @param throwable
     * @param context
     * @throws NamingException
     */
    public void salvarErro(Throwable throwable, FacesContext context) throws NamingException {
        //lookup do EJB
        InitialContext ctx = new InitialContext();
        erroSistemaBO = (ErroSistemaBO) ctx.lookup("java:comp/env/ejb/ErroSistemaBO");
        ErroSistema erroSistema = erroSistemaBO.save(SessaoUtils.getUser(), pilhaErro, context);
        FacesMessageUtils.fatal("erroInesperadoComProtocolo", erroSistema.getId().toString());
        logger.info("Erro salvo no ApplicationExceptionHandler");
    }
}
