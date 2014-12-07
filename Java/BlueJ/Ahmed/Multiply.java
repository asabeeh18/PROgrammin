class Multiply
{
 int b,c;
 void accept(Test t1,int x)
 {
     
     b=t1.get1()*x;
     c=t1.get2()*x;
     
    }
    void Display()
    {
        System.out.println("b is:"+b+"  c is:"+c);
     }
}