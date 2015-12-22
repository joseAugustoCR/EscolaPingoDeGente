/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.NoticiasDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;



/**
 *
 * @author guto
 */
@ManagedBean(name = "noticiasBD")
@SessionScoped
public class NoticiasBD implements Serializable{

    private NoticiasDAO dao;
   private  Noticia noticia;
    private Integer noticiaId;
    private UploadedFile imagemNoticia;
    
    public NoticiasBD() {
        dao = new NoticiasDAO();
        noticia = new Noticia();
        
    }

    public Integer getId() {

        return noticia.getId();
    }

    public String getTitulo() {
        return noticia.getTitulo();
    }

    public String getTexto() {
        return noticia.getTexto();
    }

    /*public String getImagem(){
        return noticia.getTitulo();
    }*/
    public String getTimestamp() {
        return noticia.getTimestamp();
    }

    public void setTitulo(String titulo) {
        noticia.setTitulo(titulo);
    }

    public void setTexto(String texto) {
        noticia.setTexto(texto);
    }

    public String getUrl() {
        return noticia.getUrl();
    }
    
    public void setUrl(String url){
        noticia.setUrl(url);
    }
    
    
    
      public Integer getNoticiaId() {
        return noticiaId;
    }

    public void setNoticiaId(Integer noticiaId) {
        this.noticiaId = noticiaId;
    }

    public void setImagem(byte[] imagem){
        noticia.setImagem(imagem);
    }
    
    public byte[] getImagem(){
        return noticia.getImagem();
    }

    public UploadedFile getImagemNoticia() {
        return imagemNoticia;
    }

    public void setImagemNoticia(UploadedFile imagemNoticia) {
        this.imagemNoticia = imagemNoticia;
    }
    
    
    
    public String inserir() throws IOException {
        dao.inserir(noticia, imagemNoticia);
        return "noticias.xhtml" + "?faces-redirect=true";
    }

    public Collection<Noticia> getNoticias() {

        return dao.buscarTodos();
    }
    
    public Collection<Noticia> getUltimasNoticias() {
        return dao.buscarUltimas();
    }
    
    public Boolean getImagemSet(){
        return noticia.getImagemSet();
    }

    public String editar() throws IOException{
        dao.editar(noticia, imagemNoticia);
         return "noticias.xhtml" + "?faces-redirect=true";
    }
    
    public void excluir(){
        Map<String,String> params = javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  String id = params.get("noticiaId");
          setNoticiaId(Integer.valueOf(id));
            dao.excluir(noticiaId);
       
    }
    
    public void novaNoticia(){
        noticia = new Noticia();
    }
    
  
    
    public void buscar(){
        if (noticiaId == null) {
            String message = "Bad request. Utilize um link válido";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return;
        }

        noticia = new Noticia();
        
        noticia = dao.buscar(noticiaId);
        
        if (noticia == null) {
            String message = "Bad request. Notícia Inválida.";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }
    
    public void handleFileUpload(FileUploadEvent event) {
      
         byte[] file = new byte[event.getFile().getContents().length];
         System.arraycopy(event.getFile().getContents(),0,file,0,event.getFile().getContents().length);
         setImagem(file);      
      
   }
    
     public StreamedContent getImagemParaExibir() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String id = context.getExternalContext().getRequestParameterMap().get("imagemId");

            noticia = dao.buscar(Integer.valueOf(id));
            if (noticia.getImagem()==null){
                return null;
            }
            
            return new DefaultStreamedContent(new ByteArrayInputStream(noticia.getImagem()));
        }
    }
    
    

}
