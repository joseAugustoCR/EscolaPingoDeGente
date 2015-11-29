/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.InicioDAO;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Logger;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author guto
 */
@ManagedBean(name = "inicioBD")
@SessionScoped
public class InicioBD implements Serializable{
    InicioDAO dao;
    Inicio inicio;
    
    public InicioBD() {
        dao = new InicioDAO();
        inicio = dao.buscar(1);
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
     
    public void atualizar(){
        dao.alterar(inicio);
    }
    
    
  
    
}
