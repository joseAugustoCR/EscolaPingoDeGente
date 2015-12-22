/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.InicioDAO;
import dao.LogoDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
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
@ManagedBean(name = "logoBD")
@SessionScoped
public class LogoBD implements Serializable {
    Logo logo;
    InicioDAO inicioDAO;
    LogoDAO dao;
    UploadedFile imagem;
    
    /**
     * Creates a new instance of LogoBD
     */
    public LogoBD() {
        dao = new LogoDAO();
        logo = dao.buscar();   
    }

    public UploadedFile getImagem() {
        return imagem;
    }

    public void setImagem(UploadedFile imagem) {
        this.imagem = imagem;
    }

    
    public StreamedContent getLogoParaExibir() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {

            if (logo.getImagem()==null){
                return null;
            }
            
            return new DefaultStreamedContent(new ByteArrayInputStream(logo.getImagem()));
        }
    }
    
    public void atualizar() throws IOException{
        inicioDAO.alterarLogo(imagem);
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Novo logo salvo!"));
        
    }
    
}
