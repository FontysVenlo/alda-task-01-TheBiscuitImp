
package simpletimeimpl;
//import simpletimeapi.APTime;

import simpletimeapi.Duration;
import simpletimeapi.Time;


/**
 *
 * @author lukas
 */
public class APTime implements simpletimeapi.Time{
    
    private int hours;
    private int minutes;
    
    public APTime ( int pHours, int pMinutes ){
        hours = pHours;
        if (pMinutes >= 0){
            minutes = pMinutes;
        } else {
            hours -=1;
            minutes = pMinutes+60;
        }
    }
    
    
    @Override
    public int getHours() {
        return hours;
    }
    @Override
    public int getMinutes() {
        return minutes;
    }
    
    
    @Override
    public boolean isBefore(Time pTime) {
        if(this.compareTo(pTime)<0){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean isBeforeOrEqual(Time pTime) {
        if(this.compareTo(pTime)<=0){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public APTime addTime(Time pTime) {
        hours += pTime.getHours();
        minutes += pTime.getMinutes();
        while (minutes>=60){
            minutes -= 60;
            hours++;
        }
        return this;
    }
    
    @Override
    public APTime addTime(int pMinutes) {
        while (pMinutes>=60){
            pMinutes -= 60;
            hours++;
        }
        if (pMinutes+minutes>=60) {
            hours++;
            minutes += pMinutes-60;
        } else {
            minutes += pMinutes;
        }
        return this;
    }
    
    
    @Override
    public int asMinutes() {
        int tempMinutes = minutes + hours *60;
        return tempMinutes;
    }
    
    @Override
    public Duration until(Time pTime){
        
        int dHours = pTime.getHours() - hours;
        int dMinutes = pTime.getMinutes() - minutes;
        return new APDuration(dHours,dMinutes);
    }
    
    
    @Override
    public int compareTo(Time otherTime){
        return Integer.compare(this.asMinutes(), otherTime.asMinutes());
    }

    
    
}
