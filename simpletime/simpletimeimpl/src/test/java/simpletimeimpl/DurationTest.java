
package simpletimeimpl;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
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
    @Test
    public void testDuration(){
        
        Duration duration1 = new Duration(1,0);
      /*Duration duration2 = new Duration(0,10);
        Duration duration3 = new Duration(1,30);*/
        
        assertThat(duration1.getHours()).isEqualTo(1) ;
       /*assertThat(duration2.getMinutes()).isEqualTo(10);
        assertThat(duration3.asMinutes()).isEqualTo(90);*/
    }
    
    @Test
    public void testDuration2(){
        
        Duration duration2 = new Duration(0,10);
        
        assertThat(duration2.getMinutes()).isEqualTo(10);
    }
    
    @Test
    public void testDuration3(){
        
        Duration duration3 = new Duration(1,30);
        
        assertThat(duration3.asMinutes()).isEqualTo(90);
    }
    
    /* 
        test if the duration is returned correctly when the duration is put in as 0 hours and many minutes
    */
    
    @Test
    public void testLargeMinuteCount(){
        
        Duration duration1 = new Duration(0,90);
        
        assertThat(duration1.getHours()).isEqualTo(1);
      /*assertThat(duration1.getMinutes()).isEqualTo(30);
        assertThat(duration1.asMinutes()).isEqualTo(90);*/
    }
    
    @Test
    public void testLargeMinuteCount2(){
        
        Duration duration1 = new Duration(0,90);
        
        assertThat(duration1.getMinutes()).isEqualTo(30);
    }
    
    @Test
    public void testLargeMinuteCount3(){
        
        Duration duration1 = new Duration(0,90);
        
        assertThat(duration1.asMinutes()).isEqualTo(90);
    }
    
    /* 
        test if the duration is returned correctly when the duration is put in as 0 hours and many minutes
        and hours
    */
    @Test
    public void testLargeMinuteCountWithHours(){
        
        Duration duration1 = new Duration(1,90);
        
        assertThat(duration1.getHours()).isEqualTo(2);
      /*assertThat(duration1.getMinutes()).isEqualTo(30);
        assertThat(duration1.asMinutes()).isEqualTo(150);*/
    }
    
    @Test
    public void testLargeMinuteCountWithHours2(){
        
        Duration duration1 = new Duration(1,90);
        
        assertThat(duration1.getMinutes()).isEqualTo(30);
    }
    
    @Test
    public void testLargeMinuteCountWithHours3(){
        
        Duration duration1 = new Duration(1,90);
        
        assertThat(duration1.asMinutes()).isEqualTo(150);
    }
    
    
    
    /*
        test adding durations to one another
    */
    @Test
    public void testPlusDuration(){
        
        Duration duration1 = new Duration(1,0);
      /*Duration duration2 = new Duration(0,90);
        Duration duration3 = new Duration(1,90);*/
        Duration duration4 = new Duration(1,30);
      //Duration duration5 = new Duration(0,120);
        
        Duration assertDuration1 = duration1.plus(duration4);
      /*Duration assertDuration2 = duration2.plus(duration3);
        Duration assertDuration3 = duration1.plus(duration5);*/
        
        assertThat(assertDuration1.asMinutes()).isEqualTo(150);
      /*assertThat(assertDuration2.getHours()).isEqualTo(4);
        assertThat(assertDuration3.getHours()).isEqualTo(3);*/
    }
    @Test
    public void testPlusDuration2(){
        
        Duration duration2 = new Duration(0,90);
        Duration duration3 = new Duration(1,90);

        Duration assertDuration2 = duration2.plus(duration3);
        
        assertThat(assertDuration2.getHours()).isEqualTo(4);
    }
    @Test
    public void testPlusDuration3(){
        
        Duration duration1 = new Duration(1,0);
        Duration duration5 = new Duration(0,120);
        
        Duration assertDuration3 = duration1.plus(duration5);
        
        assertThat(assertDuration3.getHours()).isEqualTo(3);
    }
}
