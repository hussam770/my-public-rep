package elm.moi.jsftesting.other;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestJunit1 {

	   String message = "Robert";	
	   String message2 = "Robert";
	   
	   @Test
	   public void testPrintMessage() {	
	      //System.out.println("Inside testPrintMessage()");    
	      assertEquals(message, message2);
	      
	   }
	}