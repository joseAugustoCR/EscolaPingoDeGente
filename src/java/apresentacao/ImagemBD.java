/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.GaleriaDAO;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author guto
 */
@Named(value = "imagemBD")
@RequestScoped
public class ImagemBD implements Serializable{
GaleriaDAO dao; 

    public ImagemBD() {
        dao = new GaleriaDAO();
    }
    
    
    public void inserir(){
        dao.inserir();
    }
    
    public UploadedFile getFile(){
        return dao.getFile();
    }
    
    public void setFile(UploadedFile file){
        dao.setFile(file);
    }
}
