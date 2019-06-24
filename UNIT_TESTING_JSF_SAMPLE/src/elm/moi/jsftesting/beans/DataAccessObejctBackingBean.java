package elm.moi.jsftesting.beans;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import elm.moi.jsftesting.model.City;
import elm.moi.jsftesting.model.dao.CityDao;

@Named("DaoBean")
@javax.enterprise.context.SessionScoped
public class DataAccessObejctBackingBean {
	
	private City selectedCity ;
  
  public String getCity() {
	  City city = (City)CityDao.getInstance().get(Float.valueOf(2).intValue());
	  setSelectedCity(city);
	  return "editCity";  
  }

	public City getSelectedCity() {
		return selectedCity;
	}
	
	public void setSelectedCity(City selectedCity) {
		this.selectedCity = selectedCity;
	}
  
  
}