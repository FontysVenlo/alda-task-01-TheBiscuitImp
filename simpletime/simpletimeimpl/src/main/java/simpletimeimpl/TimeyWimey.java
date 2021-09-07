
package simpletimeimpl;

/**
 *
 * @author lukas
 */
public abstract class TimeyWimey implements Comparable<TimeyWimey> {
    private int hours;
    private int minutes;
    
    public int getHours() {
        return hours;
    }
    
    public int getMinutes() {
        return minutes;
    }
    
     public int asMinutes() {
        int tempMinutes = 0;
        tempMinutes = minutes + hours *60;
        return tempMinutes;
    }
     
    public int compareTo(TimeyWimey otherTimey){
        return Integer.compare(this.asMinutes(), otherTimey.asMinutes());
    }
}
