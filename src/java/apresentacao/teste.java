/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author guto
 */
@ManagedBean
@RequestScoped
public class teste {
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public void envia(String texto){
        this.texto = texto;
    }
    
}
