package Constructor;
class Interest
{
 double p,r,t;
 Interest()
 {
     p=1000;
     r=9.5;
     t=5;
    }
    void disp()
    {
     System.out.println(((p*r*t)/100));
    }
}
