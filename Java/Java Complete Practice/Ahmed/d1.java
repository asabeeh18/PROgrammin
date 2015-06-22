class d1
{
 void main(int mark,int m)
 {
     Demo t1=new Demo();
     Demo t2=new Demo();
     t1.setmark(mark);
     t2.setmark(m);
     System.out.println("t1 marks  "+t1.getmark());
     System.out.println("t2 marks  "+t2.getmark());
     t1.compare(t2);
     System.out.println("The average marks  "+t2.calc(t1));
    }
     
}