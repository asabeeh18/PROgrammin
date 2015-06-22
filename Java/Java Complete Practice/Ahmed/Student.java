class Student
{
  int roll;
   String Name;
    int m1,m2,ave;
  void set(byte rollno, String name,int mar,int m3)
  {
     roll=rollno;
     Name=name;
     m1=mar;
     m2=m3;
   }
   int getavg(int m5,int m6)
   {
       ave=(m1+m2)/2;
       return ave;
    }
    void display()
    {
        
         System.out.println(Name+" roll no ::"+roll+"has got");
         System.out.println(m1+" :MArks:   "+m2);
         System.out.println("Average : "+ave);
    }
          
}
