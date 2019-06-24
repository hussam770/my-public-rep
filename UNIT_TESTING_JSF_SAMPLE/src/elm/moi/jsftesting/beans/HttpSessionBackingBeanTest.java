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
//tells PowerMock to prepare to mock the FacesContext class.
//will take care of initializing fields annotated with Mockito annotations.
@PrepareForTest({FacesContext.class})
public class HttpSessionBackingBeanTest {

  private HttpSessionBackingBean someBean2;

  //creating mocks using the mockito library
  @Mock
  private FacesContext mockFacesContext;
  @Mock
  private ExternalContext mockExternalContext;
  @Mock
  private HttpSession mockSession;

  @Before
  public void setUp() throws Exception {
	  someBean2 = new HttpSessionBackingBean();

    // mock all static methods of FacesContext using PowerMockito
    PowerMockito.mockStatic(FacesContext.class);

    when(FacesContext.getCurrentInstance()).thenReturn(mockFacesContext);
    when(mockFacesContext.getExternalContext())
        .thenReturn(mockExternalContext);
    when(mockExternalContext.getSession(true))
    .thenReturn(mockSession);
    
  }

  
  @Test
  public void setSelectedCityId() {
	  City dummyCity = new City();
	  dummyCity.setId(2);
	  
	  when(mockSession.getAttribute("cityId")).thenReturn(dummyCity.getId());
	  
	  assertEquals("editCity" , someBean2.setSelectedCityId());
	  assertEquals(2, someBean2.getSelectedCity());
  }
}