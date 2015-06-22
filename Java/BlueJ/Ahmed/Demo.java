class Demo
{ 
 int marks;
 void setmark(int math)
 {
     marks=math;
    }
 int getmark()
 {
     return marks;
    }
  void compare(Demo d1)
  {
      if(d1.marks>marks)
      {
      System.out.println("second object is greater");
    }
      else
      System.out.println("First object is greater");
    }
    int calc(Demo d1)
    {
        return (d1.marks+marks)/2;
    }
}