
package simpletimeimpl;

/**
 *
 * @author lukas
 */
public class Duration{
    private int hours;
    private int minutes;
    
    public Duration ( int pHours, int pMinutes ){
        hours = pHours;
        minutes = pMinutes;
        
        while (pMinutes>=60){
            pMinutes -= 60;
            hours++;
        }
        minutes = pMinutes;
    }
    
    
    //@Override
    public int getHours() {
        return hours;
    }
    
    //@Override
    public int getMinutes() {
        return minutes;
    }
    
    //@Override
    public int asMinutes() {
        int tempMinutes = 0;
        tempMinutes = minutes + hours *60;
        return tempMinutes;
    }
    
    
    public Duration plus(Duration otherDuration){
        int temp = otherDuration.getMinutes()+minutes;
        while (temp >= 60){
            temp -= 60;
            hours++;
        }
        minutes += temp;
        hours += otherDuration.getHours();
        return this;
    }
    
    
}
