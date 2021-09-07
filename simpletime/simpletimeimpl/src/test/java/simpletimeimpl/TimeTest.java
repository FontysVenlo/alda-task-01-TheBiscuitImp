
package simpletimeimpl;

import static org.assertj.core.api.Assertions.*;
//import simpletimeapi.AbstractAPFactory;

/**
 *
 * @author lukas
 */
public class TimeTest {
    
    //ServiceFinder sf = new ServiceFinder();
    //AbstractAPFactory factory = sf.getFactory();
    /*
        test for the time put in being returned correct
    */
    public void testTime() {
        
        Time time1 = new Time(1,0);
        Time time2 = new Time(0,10);
        Time time3 = new Time(1,30);
        
        assertThat(time1.getHours() == 1);
        assertThat(time2.getMinutes() == 10);
        assertThat(time3.asMinutes() == 90);
        
    }
    /*
        test for a correct time being returned correct when the minutes are negative
    */
    public void testNegativeMinutes() {
        Time time1 = new Time(1,-10);
        Time time2 = new Time(2,-30);
        
        assertThat(time1.getMinutes() == 50);
        assertThat(time2.asMinutes() == 90);
    }
    /*
        test for adding time
    */
    public void testAddTime() {
        Time time1 = new Time(1,30);
        Time time2 = new Time(1,30);
        Time time3 = new Time(0,30);
        
        time1 = time1.addTime(30);
        time2 = time2.addTime(time3);
        
        assertThat(time1.getHours() == 2);
        assertThat(time2.getHours() == 2);
    }
    /*
        test for how times compare
    */
    public void testCompareTo() {
        Time time1 = new Time(1,0);
        Time time2 = new Time(1,30);
        Time time3 = new Time(1,0);
        Time time4 = new Time(0,30);
        
        assertThat(time1.isBefore(time2) == true);
        assertThat(time1.isBefore(time4) == false);
        assertThat(time1.isBeforeOrEqual(time2) == true);
        assertThat(time1.isBeforeOrEqual(time3) == true);
        assertThat(time1.isBeforeOrEqual(time4) == false);
    } 
    /*
        test for time between times
    */
    public void testUntillTime() {
        Time time1 = new Time(1,0);
        Time time2 = new Time(1,30);
        Time time3 = new Time(1,0);
        Time time4 = new Time(2,30);
        Time time5 = new Time(2,0);
        Duration refDuration1 = new Duration(0,30);
        Duration refDuration2 = new Duration(0,0);
        Duration refDuration3 = new Duration(0,90);
        Duration refDuration4 = new Duration(1,0);
        
        Duration assertDuration1 = time1.untill(time2);
        Duration assertDuration2 = time1.untill(time5);
        Duration assertDuration3 = time1.untill(time3);
        Duration assertDuration4 = time1.untill(time4);
        
        assertThat(assertDuration1.getMinutes() == refDuration1.getMinutes());
        assertThat(assertDuration2.getHours() == refDuration4.getHours());
        assertThat(assertDuration3.getMinutes() == refDuration2.getMinutes());
        assertThat(assertDuration4.asMinutes() == refDuration3.asMinutes());
    }
}
