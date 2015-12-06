/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author guto
 */
@ManagedBean
@SessionScoped
public class FileUpload implements Serializable{

    private List<String> nomes; //to remember which files have been uploaded
    private List<FileUpload> arquivos;
    ImagemBD dao = new ImagemBD();


    public void handleFileUpload(FileUploadEvent event) { 
       // String filename = event.getFile().getFileName();
       // System.out.println("INCOMING FILE: " + filename);
        //names.add(filename);
        dao.setFile(event.getFile());
        dao.inserir();
     
   }  



}
