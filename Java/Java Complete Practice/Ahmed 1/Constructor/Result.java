package Constructor;
class Result
{
 int rn,mks1,mks2;
 double avg;
 String n;
 Result(int m1,int m2)
 {
     mks1=m1;
     mks2=m2;
    }
    Result()
    {
        mks1=0;
        mks2=0;
    }
  void ave()
  {
       avg=(mks1+mks2)/2;
    }
    void display()
    {
         System.out.println("The average  result:"+avg);
        }
    }