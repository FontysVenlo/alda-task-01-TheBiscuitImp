
package simpletimeimpl;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
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
    @Test
    public void testTime() {
        
        Time time1 = new Time(1,0);
        //Time time2 = new Time(0,10);
        //Time time3 = new Time(1,30);
        
        assertThat(time1.getHours() == 1);
        //assertThat(time2.getMinutes() == 10);
        //assertThat(time3.asMinutes() == 90);
        
    }
    
    public void testTime2() {
        
        Time time2 = new Time(0,10);
        
        assertThat(time2.getMinutes() == 10);
    }
    
    public void testTime3() {
        
        Time time3 = new Time(1,30);
        
        assertThat(time3.asMinutes() == 90);
    }
    
    /*
        test for a correct time being returned correct when the minutes are negative
    */
    @Test
    public void testNegativeMinutes() {
        Time time1 = new Time(1,-10);
        //Time time2 = new Time(2,-30);
        
        assertThat(time1.getMinutes()).isEqualTo(50);
        //assertThat(time2.asMinutes()).isEqualTo(90);
    }
    
    @Test
    public void testNegativeMinutes2() {
        Time time2 = new Time(2,-30);
        
        assertThat(time2.asMinutes()).isEqualTo(90);
    }
    
    /*
        test for adding time
    */
    @Test
    public void testAddTime() {
        Time time1 = new Time(1,30);
      /*Time time2 = new Time(1,30);
        Time time3 = new Time(0,30);*/
        
        time1 = time1.addTime(30);
        //time2 = time2.addTime(time3);
        
        assertThat(time1.getHours()).isEqualTo(2);
        //assertThat(time2.getHours()).isEqualTo(2);
    }
    @Test
    public void testAddTime2() {
        Time time2 = new Time(1,30);
        Time time3 = new Time(0,30);
        
        time2 = time2.addTime(time3);
        
        assertThat(time2.getHours()).isEqualTo(2);
    }
    /*
        test for how times compare
    */
    @Test
    public void testCompareTo() {
        Time time1 = new Time(1,0);
        Time time2 = new Time(1,30);
      /*Time time3 = new Time(1,0);
        Time time4 = new Time(0,30);*/
        
        assertThat(time1.isBefore(time2)).isEqualTo(true);
      /*assertThat(time1.isBefore(time4)).isEqualTo(false);
        assertThat(time1.isBeforeOrEqual(time2)).isEqualTo(true);
        assertThat(time1.isBeforeOrEqual(time3)).isEqualTo(true);
        assertThat(time1.isBeforeOrEqual(time4)).isEqualTo(false);*/
    } 
    @Test
    public void testCompareTo2() {
        Time time1 = new Time(1,0);
        Time time4 = new Time(0,30);
        
        //assertThat(time1.isBefore(time4)).isEqualTo(false);
        assertThat(time1.isBefore(time4)).isFalse();
    } 
    
    @Test
    public void testCompareTo3() {
        Time time1 = new Time(1,0);
        Time time2 = new Time(1,30);
        
        //assertThat(time1.isBeforeOrEqual(time2)).isEqualTo(true);
        assertThat(time1.isBeforeOrEqual(time2)).isTrue();
    } 
    
    @Test
    public void testCompareTo4() {
        Time time1 = new Time(1,0);
        Time time3 = new Time(1,0);
        
        //assertThat(time1.isBeforeOrEqual(time3)).isEqualTo(true);
        assertThat(time1.isBeforeOrEqual(time3)).isTrue();
    }
    
    @Test
    public void testCompareTo5() {
        Time time1 = new Time(1,0);
        Time time4 = new Time(0,30);
        
        //assertThat(time1.isBeforeOrEqual(time4)).isEqualTo(false);
        assertThat(time1.isBeforeOrEqual(time4)).isFalse();
    } 
    /*
        test for time between times
    */
    @Test
    public void testUntillTime() {
        Time time1 = new Time(1,0);
        Time time2 = new Time(1,30);
      /*Time time3 = new Time(1,0);
        Time time4 = new Time(2,30);
        Time time5 = new Time(2,0);*/
        Duration refDuration1 = new Duration(0,30);
      /*Duration refDuration2 = new Duration(0,0);
        Duration refDuration3 = new Duration(0,90);
        Duration refDuration4 = new Duration(1,0);*/
        
        Duration assertDuration1 = time1.untill(time2);
      /*Duration assertDuration2 = time1.untill(time5);
        Duration assertDuration3 = time1.untill(time3);
        Duration assertDuration4 = time1.untill(time4);*/
        
        assertThat(assertDuration1.getMinutes()).isEqualTo(refDuration1.getMinutes());
      /*assertThat(assertDuration2.getHours()).isEqualTo(refDuration4.getHours());
        assertThat(assertDuration3.getMinutes()).isEqualTo(refDuration2.getMinutes());
        assertThat(assertDuration4.asMinutes()).isEqualTo(refDuration3.asMinutes());*/
        
    }
    
    @Test
    public void testUntillTime2() {
        Time time1 = new Time(1,0);
        Time time5 = new Time(2,0);
        
        Duration refDuration4 = new Duration(1,0);
        
        Duration assertDuration2 = time1.untill(time5);
        
        assertThat(assertDuration2.getHours()).isEqualTo(refDuration4.getHours());
    }
    
    @Test
    public void testUntillTime3() {
        Time time1 = new Time(1,0);
        Time time3 = new Time(1,0);
        
        Duration refDuration2 = new Duration(0,0);
        
        Duration assertDuration3 = time1.untill(time3);
        
        assertThat(assertDuration3.getMinutes()).isEqualTo(refDuration2.getMinutes());
    }
    
    @Test
    public void testUntillTime4() {
        Time time1 = new Time(1,0);
        Time time4 = new Time(2,30);
        
        Duration refDuration3 = new Duration(0,90);
        
        Duration assertDuration4 = time1.untill(time4);
        
        assertThat(assertDuration4.asMinutes()).isEqualTo(refDuration3.asMinutes());
    }
    
}
