package elm.moi.jsftesting.beans;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import elm.moi.jsftesting.model.City;
import elm.moi.jsftesting.model.dao.CityDao;

@Named("sessionBean")
@javax.enterprise.context.SessionScoped
public class HttpSessionBackingBean {

	private int selectedCity ;
  public String setSelectedCityId() {
	  
	  ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	  HttpSession session = (HttpSession)externalContext.getSession(true);
	  int cityId = (int)session.getAttribute("cityId");
	  setSelectedCity(cityId);
	  return "editCity";

  }
	public int getSelectedCity() {
		return selectedCity;
	}
	public void setSelectedCity(int selectedCity) {
		this.selectedCity = selectedCity;
	}
  
  
}