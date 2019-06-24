package elm.moi.jsftesting.beans;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("someBean")
@javax.enterprise.context.SessionScoped
public class SomeBean {

  public void addMessage(Severity severity, String summary,
      String detail) {
    FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(severity, summary, detail));
  }

  public String logout() {
    FacesContext.getCurrentInstance().getExternalContext()
        .invalidateSession();
    FacesContext.getCurrentInstance().getExternalContext()
    .getSessionId(true);
    
    return "logout?faces-redirect=true";
  }
}