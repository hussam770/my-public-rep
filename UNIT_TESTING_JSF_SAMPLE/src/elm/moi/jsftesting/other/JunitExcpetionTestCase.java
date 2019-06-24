package elm.moi.jsftesting.other;


import org.junit.Test;

import elm.moi.jsftesting.util.MessageUtil;

import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class JunitExcpetionTestCase {

   String message = "Robert";	
   MessageUtil messageUtil = new MessageUtil(message);
   
   @Test(expected = ArithmeticException.class)
   public void testPrintMessage() {	
      System.out.println("Inside testPrintMessage()");   
      if(true)throw new ArithmeticException();
      messageUtil.printMessage();     
   }

   
}