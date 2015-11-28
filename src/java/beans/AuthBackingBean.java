/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author guto
 */
@ManagedBean
@RequestScoped
public class AuthBackingBean {
  
  private static Logger log = Logger.getLogger(AuthBackingBean.class.getName());
  
  public String logout() {
    String result="/login?faces-redirect=true";
    
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
    
    try {
      request.logout();
    } catch (ServletException e) {
      log.log(Level.SEVERE, "Failed to logout user!", e);
      result = "/loginError?faces-redirect=true";
    }
    
    return result;
  }
}
