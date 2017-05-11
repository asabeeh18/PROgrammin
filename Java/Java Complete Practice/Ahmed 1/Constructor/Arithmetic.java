package Constructor;
class Arithmetic
{
 double a,b;
 Arithmetic(double c,double d)
 {
  a=c;
  b=d;
    }
 void add()
 {
     System.out.println("The added result:"+(a+b));
    }
 void sub()
 {
     System.out.println("The subtracted result:"+(a-b)); 
    }
  void multiply()
  {
   System.out.println("The multiplied result:"+(a*b));
  }
  void division()
  {
       System.out.println("The divided result:"+(a/b));
    }
}