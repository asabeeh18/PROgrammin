package Constructor;
class Time1
{
 private int hours;
 private int minutes;
 private int seconds;
 Time1(byte hour,byte min,byte sec)
    {
       hours=hour;
       minutes=min;
       seconds=sec;      
    } 
   
    
 Time1()
 {
     hours=1;
     minutes=1;
     seconds=0;
    }
    void show()
 {
     System.out.println("The time is:"+hours+":"+minutes+":"+seconds);
    }
    void reset()
    {
        hours=0;
        minutes=0;
        seconds=0;
        
    }
}
