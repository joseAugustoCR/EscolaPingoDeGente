/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;
 
import java.util.Date; 

/**
 *
 * @author bernardo
 */
public class Calendario {

    private Integer id;
    private String evento;
    private String descricao;
    private Date date1;
    
        

    public Calendario() {
    }

    public Calendario(Integer id, String evento, String descricao, Date date1) {
        this.id = id;
        this.evento = evento;
        this.descricao = descricao;
        this.date1 = date1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDate1() {
        return date1;
    }
    
      
    public void setDate1(Date date1) {
        this.date1 = date1;
    }
             
}
