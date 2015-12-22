/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.ImagemDAO;
import dao.LogoDAO;
import dao.PatrocinadorDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author guto
 */
@ManagedBean
@SessionScoped
public class FileUpload implements Serializable {

    private List<String> nomes; //to remember which files have been uploaded
    private List<FileUpload> arquivos;
    private ImagemDAO dao = new ImagemDAO();
    private NoticiasBD noticiaDao = new NoticiasBD();
    private LogoDAO logoDao = new LogoDAO();
    private PatrocinadorDAO patrocinadorDAO = new PatrocinadorDAO();
    private Integer albumId = 0;
    private String legenda;

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public void handleFileUpload(FileUploadEvent event) {
        // String filename = event.getFile().getFileName();
        // System.out.println("INCOMING FILE: " + filename);
        //names.add(filename);

        if (albumId == 0) {
            FacesMessage errorMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione um álbum para inserir fotos", "");
            FacesContext.getCurrentInstance().addMessage(null, errorMsg);
        } else {
            //dao.setFile(event.getFile());
            dao.inserir(albumId,event.getFile());
        }

    }

    public void handleFileUploadNoticia(FileUploadEvent event) {
        // String filename = event.getFile().getFileName();
        // System.out.println("INCOMING FILE: " + filename);
        //names.add(filename);

       
            //dao.setFile(event.getFile());
            dao.inserir(albumId,event.getFile());
        

    }
    public void handleFileUploadLogo(FileUploadEvent event) throws IOException {
        
            logoDao.alterar(event.getFile());
        

    }
    
    public void handleFileUploadPatrocinador(FileUploadEvent event) throws IOException {
        
            patrocinadorDAO.inserir(event.getFile());
        

    }
}
