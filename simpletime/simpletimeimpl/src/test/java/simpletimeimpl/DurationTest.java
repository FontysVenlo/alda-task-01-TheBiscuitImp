
package simpletimeimpl;

import static org.assertj.core.api.Assertions.*;
//import simpletimeapi.AbstractAPFactory;

/**
 *
 * @author lukas
 */
public class DurationTest {
    
    //ServiceFinder sf = new ServiceFinder();
    //AbstractAPFactory factory = sf.getFactory();
    
    /* 
        test if the duration is returned correctly
    */
    
    public void testDuration(){
        
        Duration duration1 = new Duration(1,0);
        Duration duration2 = new Duration(0,10);
        Duration duration3 = new Duration(1,30);
        
        assertThat(duration1.getHours() == 1);
        assertThat(duration2.getMinutes() == 10);
        assertThat(duration3.asMinutes() == 90);
    }
    
    /* 
        test if the duration is returned correctly when the duration is put in as 0 hours and many minutes
    */
    
    public void testLargeMinuteCount(){
        
        Duration duration1 = new Duration(0,90);
        
        assertThat(duration1.getHours() == 1);
        assertThat(duration1.getMinutes() == 30);
        assertThat(duration1.asMinutes() == 90);
    }
    
    /* 
        test if the duration is returned correctly when the duration is put in as 0 hours and many minutes
        and hours
    */
    
    public void testLargeMinuteCountWithHours(){
        
        Duration duration1 = new Duration(1,90);
        
        assertThat(duration1.getHours() == 2);
        assertThat(duration1.getMinutes() == 30);
        assertThat(duration1.asMinutes() == 150);
    }
    
    /*
        test adding durations to one another
    */
    public void testPlusDuration(){
        
        Duration duration1 = new Duration(1,0);
        Duration duration2 = new Duration(0,90);
        Duration duration3 = new Duration(1,90);
        Duration duration4 = new Duration(1,30);
        Duration duration5 = new Duration(0,120);
        
        Duration assertDuration1 = duration1.plus(duration4);
        Duration assertDuration2 = duration2.plus(duration3);
        Duration assertDuration3 = duration1.plus(duration5);
        
        assertThat(assertDuration1.asMinutes() == 150);
        assertThat(assertDuration2.getHours() == 4);
        assertThat(assertDuration3.getHours() == 3);
    }
}
