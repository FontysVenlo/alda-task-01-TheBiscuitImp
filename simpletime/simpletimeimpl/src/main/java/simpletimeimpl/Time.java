
package simpletimeimpl;

/**
 *
 * @author lukas
 */
public class Time{
    
    private int hours;
    private int minutes;
    
    public Time ( int pHours, int pMinutes ){
        hours = pHours;
        if (pMinutes >= 0){
            minutes = pMinutes;
        } else {
            hours -=1;
            minutes = pMinutes+60;
        }
    }
    
    
    //@Override
    public int getHours() {
        return hours;
    }
    //@Override
    public int getMinutes() {
        return minutes;
    }
    
    
    public boolean isBefore(Time pTime) {
        if(this.compareTo(pTime)==1){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isBeforeOrEqual(Time pTime) {
        if(this.compareTo(pTime)>=0){
            return true;
        }else{
            return false;
        }
    }
    
    public Time addTime(Time pTime) {
        hours += pTime.getHours();
        minutes += pTime.getMinutes();
        while (minutes>=60){
            minutes -= 60;
            hours++;
        }
        return this;
    }
    
    public Time addTime(int pMinutes) {
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
    
    
    //@Override
    public int asMinutes() {
        int tempMinutes = minutes + hours *60;
        return tempMinutes;
    }
    
    
    public Duration untill(Time pTime){
        
        int dHours = pTime.getHours() - hours;
        int dMinutes = pTime.getMinutes() - minutes;
        return new Duration(dHours,dMinutes);
    }
    
    
    public int compareTo(Time otherTime){
        return Integer.compare(this.asMinutes(), otherTime.asMinutes());
    }
    
}
