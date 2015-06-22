package Constructor;
class Date
{
 int yy,mm,dd;
 Date(int y,int m,int d)                             //Enter year,month,date
                                                        //Enter year,month,date
 {
     yy=y;
     mm=m;
     dd=d;
    }
 Date()
 {
     dd=22;
     yy=1994;
     mm=5;
    }
    void Yearplus()
    {
        yy++;
    }
   void display()
    {
        System.out.println("The date is"+dd+"/"+mm+"/"+yy);
    }
}
    
 