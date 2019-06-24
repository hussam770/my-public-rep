package elm.moi.jsftesting.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import elm.moi.jsftesting.model.City;
import elm.moi.jsftesting.model.dao.CityDao;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CityDao.class})
public class DataAccessObejctBackingBeanTest {

  private DataAccessObejctBackingBean someBean2;

  
  
  @Mock
  private CityDao mockCityDao;

  @Before
  public void setUp() throws Exception {
	  someBean2 = new DataAccessObejctBackingBean();

    // mock all static methods of CityDao using PowerMockito
    PowerMockito.mockStatic(CityDao.class);
    when(CityDao.getInstance()).thenReturn(mockCityDao);
    
  }

  
  @Test
  public void testGetCity() {
	  City dummyCity = new City();
	  dummyCity.setId(2);
	  
	  when(mockCityDao.get(dummyCity.getId())).thenReturn(dummyCity);
	  
	  assertEquals("editCity" , someBean2.getCity());
	  assertEquals(3 , someBean2.getSelectedCity().getId());
  }
}