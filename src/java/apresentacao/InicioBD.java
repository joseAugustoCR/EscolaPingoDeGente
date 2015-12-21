/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;


import dao.InicioDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;


/**
 *
 * @author guto
 */
@ManagedBean(name = "inicioBD")
@SessionScoped
public class InicioBD implements Serializable{
    private InicioDAO dao;
    private Inicio inicio;
    private UploadedFile logo;
    
    public InicioBD() {
        dao = new InicioDAO();
        inicio = dao.buscar(1);
    }

    public UploadedFile getLogo() {
        return logo;
    }

    public void setLogo(UploadedFile logo) {
        this.logo = logo;
    }
    
    
    
    public String getQuemSomos(){
        
        return inicio.getQuemSomos();
    }
    
    public String getQualidade(){
        
        return inicio.getQualidade();
    }
    
    public String getEstrutura(){
        
        return inicio.getEstrutura();
    }
    
    public String getMissao(){
        
        return inicio.getMissao();
    }
    
    public void setQuemSomos(String quemSomos){
        inicio.setQuemSomos(quemSomos);
    }
    
     public void setQualidade(String qualidade){
        inicio.setQualidade(qualidade);
    }
     
      public void setEstrutura(String estrutura){
        inicio.setEstrutura(estrutura);
    }
      
     public void setMissao(String missao){
        inicio.setMissao(missao);
    }
     
    public void atualizar() throws IOException{
        dao.alterar(inicio, logo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Informações alteradas com sucesso!"));
    }
    
    public StreamedContent getLogoParaExibir() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {

            if (inicio.getLogo()==null){
                return null;
            }
            
            return new DefaultStreamedContent(new ByteArrayInputStream(inicio.getLogo()));
        }
    }
    
    
  
    
}
