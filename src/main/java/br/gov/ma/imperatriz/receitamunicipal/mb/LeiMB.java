package br.gov.ma.imperatriz.receitamunicipal.mb;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named; 
import br.gov.ma.imperatriz.receitamunicipal.bo.LeiBO;
import br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis.Lei;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;

/**
 *
 * @author dalfredewelkenerlima
 */
@Named
@ViewScoped
public class LeiMB extends AbstractBaseBean<Lei> implements Serializable {

    @EJB
    private LeiBO leiBO;
    
    private transient Part uploadArquivo;
    private Lei lei = new Lei();

    @Override
    public LeiBO getBO() {
        return leiBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    public void uploadArquivo(ActionEvent event) {
		if (uploadArquivo != null) {
			try (InputStream is = uploadArquivo.getInputStream();
					ByteArrayOutputStream out = new ByteArrayOutputStream()) {
				
				int read = -1;
                byte[] buffer = new byte[1024];
                
                while ((read = is.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
				
                lei.setArquivo(out.toByteArray());
			} catch (IOException e) {
				throw new RuntimeException("Erro ao enviar arquivo.", e);
			}
		}
	}
    
    public Part getuploadArquivo() {
		return uploadArquivo;
	}

	public void setuploadArquivo(Part uploadArquivo) {
		this.uploadArquivo = uploadArquivo;
	}
}
