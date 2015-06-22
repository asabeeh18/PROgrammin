package Constructor;
class Student
{
  int roll;
   String Name;
    int m1,m2;
    float average;
  Student(byte rollno, String name,int mar,int m3)
  {
     roll=rollno;
     Name=name;
     m1=mar;
     m2=m3;
   }
   Student()
  {
      roll=0;
      Name="null";
      m1=100;
      m2=100;
    }
  
      
    void disp()
   {
       System.out.println(Name+"  has got marks  "+m1+"  "+m2+"Average:"+((m1+m2)/2));
    }
    
}
