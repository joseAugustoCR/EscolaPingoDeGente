/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.SobreDAO;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Logger;

import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bernardo
 */
@ManagedBean(name = "sobreBD")
@SessionScoped
public class SobreBD implements Serializable{
    SobreDAO dao;
    Sobre sobre;
    
    public SobreBD() {
        dao = new SobreDAO();
        sobre = dao.buscar(1);
    }
    
    
    public String getQuemSomos(){
        
        return sobre.getQuemSomos();
    }
    
    public String getHistoria(){
        
        return sobre.getHistoria();
    }
    
    public String getEstrutura(){
        
        return sobre.getEstrutura();
    }
    
    public String getMissao(){
        
        return sobre.getMissao();
    }
    
    public String getVisao(){
        
        return sobre.getVisao();
    }
    
    public String getValores(){
        return sobre.getValores();
    }
    
    public void setQuemSomos(String quemSomos){
        sobre.setQuemSomos(quemSomos);
    }
    
     public void setHistoria(String historia){
        sobre.setHistoria(historia);
    }
     
      public void setEstrutura(String estrutura){
        sobre.setEstrutura(estrutura);
    }
      
     public void setMissao(String missao){
        sobre.setMissao(missao);
    }
     
    public void setVisao(String visao){
        sobre.setVisao(visao);
    }
    
    public void setValores(String valores){
        sobre.setValores(valores);
    }
     
    public void atualizar(){
        dao.alterar(sobre);
    }
    
}
