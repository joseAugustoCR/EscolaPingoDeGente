/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.ContatoDAO;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author bernardo
 */
@ManagedBean(name = "contatoBD")
@SessionScoped
public class ContatoBD implements Serializable{
    ContatoDAO dao;
    Contato contato;
    
    public ContatoBD() {
        dao = new ContatoDAO();
        contato = dao.buscar(1);
    }
    
    
    public String getEndereco(){
        
        return contato.getEndereco();
    }
    
    public String getFone1(){
        
        return contato.getFone1();
    }
    
    public String getFone2(){
        
        return contato.getFone2();
    }
    
    public String getFone3(){
        
        return contato.getFone3();
    }
            
    public void setEndereco(String endereco){
        contato.setEndereco(endereco);
    }
    
    public void setFone1(String fone1){
        contato.setFone1(fone1);
    }
     
    public void setFone2(String fone2){
        contato.setFone2(fone2);
    } 
    
    public void setFone3(String fone3){
        contato.setFone3(fone3);
    }
    
    public void atualizar(){
        dao.alterar(contato);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Informações alteradas com sucesso!"));
    }
}
