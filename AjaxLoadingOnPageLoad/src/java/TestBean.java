
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author husam
 */
@ViewScoped
@ManagedBean(name = "testBean")
public class TestBean implements Serializable {
    Integer clickCount=1;
    Timer timer = null ;
    private boolean isCompleted  = false ; 
    private WatchTimer watch = null ;
    private String counter = null ;
    
    @PostConstruct
    public void init() { 
         
    }

public Integer getClickCount() {
    return clickCount;                                                                                                                              
}

public void setClickCount(Integer clickCount) {
    this.clickCount = clickCount;
}

public void counterUpdateEvent(ActionEvent event) {
    System.out.println("counterUpdateEvent called");
}

public void initiateEventTimer(ActionEvent event) {
    System.out.printf("increaseCount is called.. before increase %s %n" , clickCount);
    if(timer != null){
        System.out.println("timer is not null... return to upate timer value");
        return ;
    }
        
    timer = new Timer("requestCheckerTimer" , false);
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println("Checking Data base status ");
            
            int randomNumber = (int)(Math.random() * 10) + 1 ;
            System.out.printf("the random number is %s %n" , randomNumber);
            if(randomNumber > 8){
                System.out.println("Thats it , the request is completed ");
                cancel() ;
                setIsCompleted(true);
            }else {
                System.out.println("need to check again");
            }
            
    }}, 5000, 5000);
    watch = new WatchTimer(5);
    while(!isCompleted){
        try {
            Thread.sleep(1000);
            setCounter(watch.decreaseSecand()) ;
            System.out.printf("counter is :: %s %n" , counter);
           } catch (InterruptedException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    setIsCompleted(true);
}

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public WatchTimer getWatch() {
        return watch;
    }

    public void setWatch(WatchTimer watch) {
        this.watch = watch;
    }

   public String getCounter() {
       System.out.println("getCounter is : %s %n");
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    
  


}
