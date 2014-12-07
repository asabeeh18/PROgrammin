class Rupees
{
 void main(int amt)
 {
     int a=amt/20;
     System.out.println("20*"+a);
     amt=amt%20;
     int d=amt/5;
     System.out.println("5*"+d);
      amt=amt%5;
     int f=amt/2;
     System.out.println("2*"+f);
     amt=amt%2;
     int h=amt/1;
     System.out.println("1*"+h);
    }
}