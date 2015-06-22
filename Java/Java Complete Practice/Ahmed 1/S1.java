class S1
{
 void main(int sc,int ma,int co)
 {
     Semister S3=new Semister(sc,ma,co);
     Semister S2=new Semister(sc,ma,co);
     Semister S4=new Semister(sc,ma,co);
     Semister stotal=new Semister();
     stotal=S3.Total(S2);    
     stotal.Display();
     stotal=stotal.add(s4);
     
    }
   
}
