class Dist
{
 double feet,cm;
 void accept(double metre,double centimetre)
 {
    cm=(metre*100)+centimetre;
    feet=cm/30;
    System.out.println("in cm  "+cm+"in feet  "+feet);
 }
}