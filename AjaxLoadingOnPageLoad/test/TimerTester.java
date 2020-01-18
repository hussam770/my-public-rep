/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author husam
 */
public class TimerTester {
    
    public TimerTester() {
    }
    
    @Before
    public void setUp() {
    }

    // TODO add test methods here
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         WatchTimer watch = new WatchTimer(2);
         while(!watch.finished())
          try {
            Thread.sleep(100);
              System.out.printf("Timer is : %s %n" , watch.decreaseSecand()) ;
           } catch (InterruptedException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
