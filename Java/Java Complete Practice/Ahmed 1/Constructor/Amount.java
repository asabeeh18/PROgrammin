package Constructor;
class Amount
{
 double amt,p,r,n,a;
 Amount()
 {
     p=20000;
     n=1.5;
     amt=27983;
     a=1/n;
    }
    void cal()
    {
        r=100*(Math.pow((amt/p),a)-1);
    } 
    void disp()
    {
        System.out.println("The RAte  "+r);
    }
}

    