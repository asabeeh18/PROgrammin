package Constructor;
class Weight
{
 int w1,w2,w3,w4,w5,w6;
 float ave;
 Weight()
 {
     w1=1;
     w2=2;
     w3=3;
     w4=4;
     w5=5;
     w6=6;
    }
    Weight(int we1,int we2,int we3,int we4,int we5,int we6)
    {
        w1=we1;
        w2=we2;
        w3=we3;
        w4=we4;
        w5=we5;
        w6=we6;
    }
    void cal_avg()
    {
         ave=(w1+w2+w3+w4+w5+w6)/6;
        
    }
    void show()
    {
        System.out.println("The weight of all months \n "+w1+"\n"+w2+"\n"+w3+"\n"+w4+"\n"+w5+"\n"+w6);
        System.out.println("The average weight is:"+ave+"Kg");
        
        
        
    }
}