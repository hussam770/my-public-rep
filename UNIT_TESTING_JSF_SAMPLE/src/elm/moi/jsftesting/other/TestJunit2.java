package elm.moi.jsftesting.other;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit2 {

   String message = "Robert";	
   String message2 = "Robert";
 
   @Test
   public void testSalutationMessage() {
      //System.out.println("Inside testSalutationMessage()");
      //message = "Hi!" + "Robert";
      assertEquals(message,message2);
   }
}