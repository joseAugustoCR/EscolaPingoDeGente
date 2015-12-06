/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.CalendarioDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.sql.Date;
import java.util.Map;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author bernardo
 */
@ManagedBean(name = "calendarioDB")
@SessionScoped
public class CalendarioDB implements Serializable{

    CalendarioDAO dao;
    Calendario calendario;
    private Integer calendarioId;
  
  

    /**
     * Creates a new instance of CalendarioDB
     */
    public CalendarioDB() {
        dao = new CalendarioDAO();
        calendario = new Calendario();
        
    }

    public Integer getId() {

        return calendario.getId();
    }

    public String getEvento() {
        return calendario.getEvento();
    }

    public String getDescricao() {
        return calendario.getDescricao();
    }

    public Date getData() {
        return calendario.getData();
    }

    public void setEvento(String evento) {
        calendario.setEvento(evento);
    }

    public void setDescricao(String descricao) {
        calendario.setDescricao(descricao);
    }
    
    public void setDate(Date data) {
        calendario.setData(data);
    }
    
      public Integer getCalendarioId() {
        return calendarioId;
    }

    public void setCalendarioId(Integer calendarioId) {
        this.calendarioId = calendarioId;
    }

        
    public void novoCalendario(){
        calendario = new Calendario();
    }
    
    public void inserir() {
        dao.inserir(calendario);
    }
      
    public void buscar(){
        if (calendarioId == null) {
            String message = "Bad request. Utilize um link válido";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return;
        }

        calendario = null;
        
        calendario = dao.buscar(calendarioId);
        
        if (calendario == null) {
            String message = "Bad request. Notícia Inválida.";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }

}
