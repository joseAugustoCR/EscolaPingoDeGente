/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.GaleriaDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author guto
 */
@Named(value = "galeriaBD")
@ApplicationScoped
public class GaleriaBD implements Serializable{
private GaleriaDAO dao = new GaleriaDAO();
    
    /**
     * Creates a new instance of ImagensBD
     */
    public StreamedContent getImagem() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String id = context.getExternalContext().getRequestParameterMap().get("imagemId");
            byte[] image = dao.buscar(Integer.valueOf(id));
            return new DefaultStreamedContent(new ByteArrayInputStream(image));
        }
    }
    
     public Collection<Integer> getIds(){
        return dao.buscarIds();
    }
    
}
