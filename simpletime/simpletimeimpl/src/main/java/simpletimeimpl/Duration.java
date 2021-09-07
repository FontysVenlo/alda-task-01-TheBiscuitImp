
package simpletimeimpl;

/**
 *
 * @author lukas
 */
public abstract class Duration {
    private int hours;
    private int minutes;
    
    public Duration ( int pHours, int pMinutes ){
        hours = pHours;
        minutes = pMinutes;
    }
}
