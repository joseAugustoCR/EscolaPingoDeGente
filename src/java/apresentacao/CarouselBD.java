/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.CarouselDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;

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
@ManagedBean(name = "carouselBD")
@SessionScoped
public class CarouselBD {
    Carousel carousel;
    CarouselDAO dao;
    UploadedFile imagem1;
    UploadedFile imagem2;
    UploadedFile imagem3;
    

    /**
     * Creates a new instance of CarouselBD
     */
    public CarouselBD() {
        
        dao = new CarouselDAO();
        carousel = dao.buscar();
    }

    public void setTitulo1(String titulo){
        carousel.setTitulo1(titulo);
    }
    public void setTitulo2(String titulo){
        carousel.setTitulo2(titulo);
    }
    public void setTitulo3(String titulo){
        carousel.setTitulo3(titulo);
    }
    
    public void setLegenda1(String legenda){
        carousel.setLegenda1(legenda);
    }
    public void setLegenda2(String legenda){
        carousel.setLegenda2(legenda);
    }
    public void setLegenda3(String legenda){
        carousel.setLegenda3(legenda);
    }

    public UploadedFile getImagem1() {
        return imagem1;
    }

    public void setImagem1(UploadedFile imagem1) {
        this.imagem1 = imagem1;
    }

    public UploadedFile getImagem2() {
        return imagem2;
    }

    public void setImagem2(UploadedFile imagem2) {
        this.imagem2 = imagem2;
    }

    public UploadedFile getImagem3() {
        return imagem3;
    }

    public void setImagem3(UploadedFile imagem3) {
        this.imagem3 = imagem3;
    }
    
   public String getTitulo1(){
       return carousel.getTitulo1();
   }
   public String getTitulo2(){
       return carousel.getTitulo2();
   }
   public String getTitulo3(){
       return carousel.getTitulo3();
   }
   public String getLegenda1(){
       return carousel.getLegenda1();
   }
   public String getLegenda2(){
       return carousel.getLegenda2();
   }
   public String getLegenda3(){
       return carousel.getLegenda3();
   }
   
   public void editar() throws IOException{
       dao.editar(carousel, imagem1, imagem2, imagem3);
   }
   
   public void inserir() throws IOException{
       dao.inserir(carousel, imagem1, imagem2, imagem3);
       
   }
   
    /**
     *
     * @return
     * @throws IOException
     */
    public StreamedContent getImagem1ParaExibir() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
     

            Carousel c = dao.buscar();
            if (c.getImagem1()==null){
                return null;
            }
            
            return new DefaultStreamedContent(new ByteArrayInputStream(c.getImagem1()));
        }
    }
    
    
    
    
    
    
}
