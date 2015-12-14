/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import dao.CalendarioDAO;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
 
import org.primefaces.event.SelectEvent;

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

    public Date getDate1() {
        return calendario.getDate1();
    }

    public void setEvento(String evento) {
        calendario.setEvento(evento);
    }

    public void setDescricao(String descricao) {
        calendario.setDescricao(descricao);
    }
    
    public void setDate1(Date date1) {
        calendario.setDate1(date1);
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
                
    public String editar() {
        dao.editar(calendario);
         return "eventos.xhtml" + "?faces-redirect=true";
    }
    
    public void excluir(){
        Map<String,String> params = javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  String id = params.get("calendarioId");
          setCalendarioId(Integer.valueOf(id));
            dao.excluir(calendarioId);
       
    }  
    
    public void buscarId(){
        if (calendarioId == null) {
            String message = "Bad request. Utilize um link válido";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return;
        }

        calendario = new Calendario();
        
        calendario = dao.buscarEvento(calendarioId);
        
        if (calendario == null) {
            String message = "Bad request. Notícia Inválida.";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }
    
    public Collection<Calendario> getEventos() {

        return dao.buscar();
    }
     
    public Collection<Calendario> getEventosJaneiro() {

        return dao.buscarJaneiro();
    }
    
    public Collection<Calendario> getEventosFevereiro() {

        return dao.buscarFevereiro();
    }
    
    public Collection<Calendario> getEventosMarco() {

        return dao.buscarMarco();
    }
    
    public Collection<Calendario> getEventosAbril() {

        return dao.buscarAbril();
    }
    
    public Collection<Calendario> getEventosMaio() {

        return dao.buscarMaio();
    }
    
    public Collection<Calendario> getEventosJunho() {

        return dao.buscarJunho();
    }
    
    public Collection<Calendario> getEventosJulho() {

        return dao.buscarJulho();
    }
    
    public Collection<Calendario> getEventosAgosto() {

        return dao.buscarAgosto();
    }
    
    public Collection<Calendario> getEventosSetembro() {

        return dao.buscarSetembro();
    }
    
    public Collection<Calendario> getEventosOutubro() {

        return dao.buscarOutubro();
    }
    
    public Collection<Calendario> getEventosNovembro() {

        return dao.buscarNovembro();
    }
    
    public Collection<Calendario> getEventosDezembro() {

        return dao.buscarDezembro();
    }
       
            
    public void inserir() {
        dao.inserir(calendario);
        calendario = new Calendario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Evento adicionado com sucesso!"));
      
               
    }
      
}
