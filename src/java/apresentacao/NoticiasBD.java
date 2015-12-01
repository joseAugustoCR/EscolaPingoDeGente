/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.NoticiasDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



/**
 *
 * @author guto
 */
@ManagedBean(name = "noticiasBD")
@SessionScoped
public class NoticiasBD implements Serializable{

    NoticiasDAO dao;
    Noticia noticia;
    private Integer noticiaId;
  

  

    /**
     * Creates a new instance of NoticiasBD
     */
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
    
      public Integer getNoticiaId() {
        return noticiaId;
    }

    public void setNoticiaId(Integer noticiaId) {
        this.noticiaId = noticiaId;
    }

    //set imagem
    
    
    public String inserir() {
        dao.inserir(noticia);
        return "noticias.xhtml" + "?faces-redirect=true";
    }

    public Collection<Noticia> getNoticias() {

        return dao.buscarTodos();
    }
    
    public String editar() throws IOException{
        dao.editar(noticia);
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

        noticia = null;
        
        noticia = dao.buscar(noticiaId);
        
        if (noticia == null) {
            String message = "Bad request. Notícia Inválida.";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }

}
