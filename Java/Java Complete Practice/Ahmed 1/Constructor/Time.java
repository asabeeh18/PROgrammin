package Constructor;
class Time 
{
 private int hours;
 private int minutes;
 private int seconds;
 Time(byte hour,byte min,byte sec)
    {
       hours=hour;
       minutes=min;
       seconds=sec;      
    } 
   
    
 Time()
 {
     hours=1;
     minutes=1;
     seconds=0;
    }
   Time(byte h)
   {
       hours=h;
       minutes=1;
       seconds=0;
    }
    Time(int s)
    {
        seconds=s;
        hours=1;
        minutes=1;
    }
    Time(short m)
    {
        minutes=m;
        hours=1;
        seconds=0;
    }
        
    void func()
    {
        System.out.println("The time is:  "+hours+":"+minutes+":"+seconds);
    }
}




