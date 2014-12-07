
class Semister
{
 int rn,sci,math,comp,tot;
 Semister(int s,int m,int c)
 {
     sci=s;
     math=m;
     comp=c;
    }
    Semister()
    {
    }
    int added()
    {
         tot=math+sci+comp;
        return tot;
    }
    
    void Display()
    {
      
      System.out.println("The Total of Semister:"+sci+"\n"+math+"\n"+comp);
    }
   
    Semister Total(Semister S3)
    {
       Semister S4=new Semister(S3.sci+sci,S3.math+math,S3.comp+comp); 
       return S4;
    }
    
}