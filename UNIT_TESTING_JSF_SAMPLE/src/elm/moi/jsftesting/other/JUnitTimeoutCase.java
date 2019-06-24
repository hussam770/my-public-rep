package elm.moi.jsftesting.other;


import org.junit.Test;

import elm.moi.jsftesting.util.MessageUtil;

import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class JUnitTimeoutCase {

   String message = "Robert";	
   MessageUtil messageUtil = new MessageUtil(message);
   
   @Test(timeout = 2000)
   public void testPrintMessage() {	
      System.out.println("Inside testPrintMessage()");   
      try {
    	  Thread.sleep(3000);
      }
      catch(InterruptedException ie) {}
      messageUtil.printMessage();     
   }

 
}