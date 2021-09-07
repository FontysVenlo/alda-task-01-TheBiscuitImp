
package simpletimeimpl;

import static org.assertj.core.api.Assertions.*;
import simpletimeapi.AbstractAPFactory;

/**
 *
 * @author lukas
 */
public class TimeTest {
    
    ServiceFinder sf = new ServiceFinder();
    AbstractAPFactory factory = sf.getFactory();
    /*
        test for the time put in being returned correct
    */
    public void testTime() {
        
        Object time1 = factory.createTime(1,0);
        Object time2 = factory.createTime(0,10);
        Object time3 = factory.createTime(1,30);
        
        assertThat(time1.getHours == 1);
        assertThat(time2.getMinutes == 10);
        assertThat(time3.asMinutes == 90);
        
    }
    /*
        test for a correct time being returned correct when the minutes are negative
    */
    public void testNegativeMinutes() {
        Object time1 = factory.createTime(1,-10);
        Object time2 = factory.createTime(2,-30);
        
        assertThat(time1.getMinutes == 50);
        assertThat(time2.asMinutes == 90);
    }
    /*
        test for adding time
    */
    public void testAddTime() {
        Object time1 = factory.createTime(1,30);
        Object time2 = factory.createTime(1,30);
        Object time3 = factory.createTime(0,30);
        
        time1 = time1.addTime(30);
        time2 = time2.addTime(time3);
        
        assertThat(time1.getHours == 2);
        assertThat(time2.getHours == 2);
    }
    /*
        test for how times compare
    */
    public void testCompareTo() {
        Object time1 = factory.createTime(1,0);
        Object time2 = factory.createTime(1,30);
        Object time3 = factory.createTime(1,0);
        Object time4 = factory.createTime(0,30);
        
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
        Object time1 = factory.createTime(1,0);
        Object time2 = factory.createTime(1,30);
        Object time3 = factory.createTime(1,0);
        Object time4 = factory.createTime(2,30);
        Object time5 = factory.createTime(2,0);
        Object refDuration1 = factory.createDuration(0,30);
        Object refDuration2 = factory.createDuration(0,0);
        Object refDuration3 = factory.createDuration(0,90);
        Object refDuration4 = factory.createDuration(1,0);
        
        Object assertDuration1 = time1.untill(time2);
        Object assertDuration2 = time1.untill(time5);
        Object assertDuration3 = time1.untill(time3);
        Object assertDuration4 = time1.untill(time4);
        
        assertThat(assertDuration1.getMinutes() == refDuration1.getMinutes());
        assertThat(assertDuration2.getHours() == refDuration4.getHours());
        assertThat(assertDuration3.getMinutes() == refDuration2.getMinutes());
        assertThat(assertDuration4.asMinutes() == refDuration3.asMinutes());
    }
}
