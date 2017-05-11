class AreaTri
{
 void main(double a,double b,double c)
 {
     double s=(a+b+c)/2;
     double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
     System.out.println("The area of triangle is:"+area);
    }
}