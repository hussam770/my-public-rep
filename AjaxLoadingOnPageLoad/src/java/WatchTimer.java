
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author husam
 */
public class WatchTimer {
    private Minute [] minutes;
    

    public WatchTimer(int numberOfminutes) {
        this.minutes =new Minute[numberOfminutes];
        for(int i =0 ; i< minutes.length;i++){
            minutes[i] = new Minute();
        }
    }
    
    public String decreaseSecand(){
       
        if(minutes[minutes.length -1].secands == 0){
            System.out.printf("length before removing %s %n" , minutes.length);
           minutes = removeElement(minutes,minutes[minutes.length -1]); 
           System.out.printf("length after removing %s %n" , minutes.length);
        }
         minutes[minutes.length -1].secands -- ;   
        if(minutes.length > 0)
            return String.format("%02d:%02d", minutes.length -1 , minutes[minutes.length -1].secands)   ; 
        else return null ;
    }
    
    public boolean finished(){
        if(minutes[0] == null || minutes[0].secands == 0)
            return true ;
        return false ;
    }
    
    private static Minute[] removeElement(Minute[] arr, Minute elem) {
        int length = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != elem) {
                arr[length++] = arr[i];
            }
        }
        arr = Arrays.copyOf(arr, length);
        return arr;
    }
 
    
    
}
