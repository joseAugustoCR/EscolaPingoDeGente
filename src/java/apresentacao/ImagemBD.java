/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.GaleriaDAO;
import dao.ImagemDAO;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author guto
 */
@ManagedBean(name = "imagemBD")
@SessionScoped
public class ImagemBD implements Serializable{
    private ImagemDAO dao; 
    

    public ImagemBD() {
        dao = new ImagemDAO();
    }
    


    
    /*
    public void inserir(Integer albumId){
        dao.inserir(albumId);
    }
    
    public UploadedFile getFile(){
        return dao.getFile();
    }
    
    public void setFile(UploadedFile file){
        dao.setFile(file);
    }*/
    
    public void excluir(){
        Map<String,String> params = javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  Integer id = Integer.valueOf(params.get("imagemId"));
          dao.excluirFoto(id);
    }
    
    
        
    
   
}
