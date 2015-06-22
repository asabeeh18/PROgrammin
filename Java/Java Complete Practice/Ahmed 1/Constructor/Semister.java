package Constructor;
class Semister
{
 int rn,sci,math,comp;
 Semister(int s,int m,int c)
 {
     sci=s;
     math=m;
     comp=c;
    }
    
    void Display()
    {
      System.out.println("The result:/n:Math"+math+"/nScience:"+sci+"/n Computer:"+comp);
    }
}