/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.PatrocinadorDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author guto
 */
@ManagedBean(name = "patrocinadorBD")
@SessionScoped
public class PatrocinadorBD implements Serializable {
    private Patrocinador patrocinador;
    private PatrocinadorDAO dao;
    private UploadedFile imagem;
     private Collection<Patrocinador> patrocinadores= new ArrayList<Patrocinador>();
    private Collection<Integer> ids = new ArrayList<Integer>();

    
    /**
     * Creates a new instance of PatrocinadorBD
     */
    public PatrocinadorBD() {
        dao = new PatrocinadorDAO();
        patrocinadores = dao.buscarTodos();
    }

    public Collection<Patrocinador> getPatrocinadores() {
        return patrocinadores;
    }
    
    

    public UploadedFile getImagem() {
        return imagem;
    }

    public void setImagem(UploadedFile imagem) {
        this.imagem = imagem;
    }
    
    public void excluir() {
        Map<String, String> params = javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer id = Integer.valueOf(params.get("patrocinadorId"));
        dao.excluir(id);
        patrocinadores= dao.buscarTodos();
    }
    
    public StreamedContent getImagemParaExibir() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String id = context.getExternalContext().getRequestParameterMap().get("patrocinadorId");

            Patrocinador p = dao.buscar(Integer.valueOf(id));
            return new DefaultStreamedContent(new ByteArrayInputStream(p.getImagem()));
        }
    }
    
    
    
}
