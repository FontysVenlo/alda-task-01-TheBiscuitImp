
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
        Object time2 = factory.createTime(0,1);
        Object time3 = factory.createTime(1,3);
        int[] refTime3 = new int[2];
        
        assertThat(time1.getHour == 1);
        assertThat(time2.getMinute == 1);
        assertThat(time3.getTime == refTime3);
        
    }
    /*
        test for a correct time being returned correct when the minutes are negative
    */
    public void testNegativeMinutes() {
        
    }
    /*
        test for how times compare
    */
    public void testCompareTo(){
        
    } 
}
