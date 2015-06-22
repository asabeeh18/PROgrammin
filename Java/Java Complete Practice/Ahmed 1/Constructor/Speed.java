package Constructor;
class Speed
{
 int u,t,a;
 Speed()
 {
     
     u=0;
     t=2;
     a=16;
    }
    void sp()
    {
         System.out.println((u*t+(0.5f*a*t*t)));
        }
    }