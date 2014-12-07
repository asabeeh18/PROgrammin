package APC_Comp;
class output
{

void main()
{
byte x=64,y;
y=(byte)(x<<2);
System.out.println(y);
}

    void min()
    {
         int a=3,b=5;
         System.out.println(a%b);
        }
        
        void man()
        {
            int n;
            for(n=5;n!=7;++n)
            {
                System.out.println(n);
            }
       }
       void mi()
       {
           int m,N,p,q=0;
           for(m=2;m<=3;++m)
            {
                for(N=1;N<=m;++N)
                {
                    p=m+N-1;
                    if(p%3==0)
                    {
                        q+=p;
                    }
                }
            }
            System.out.println(q);
        }
        
        void mn()
        {
            int a[]=new int[5];
            int b[]={2,3,4,5};
            System.out.println(a.length);
        }
            
}
