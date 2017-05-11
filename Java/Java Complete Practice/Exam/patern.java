import java.io.*;
class patern

{
  int m=0,m2=0;
  String a,b,c,v,p,z,o,s,f,e,r,t,q,ma,ms,mr,me,mo,mh,mj;
  String g; 
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
    System.out.println("Enter the no.");
    a=bf.readLine();
    int t=a.length();
    for(int i=0;i<t;i++)
    {
        String g=a.substring(i,t);
         System.out.println(g);
    }
}

    void man()throws Exception
    {
        System.out.println("Enter the no.");
    int mea=Integer.parseInt(bf.readLine());
    
    for(int i=0;i<mea;i++)
    {
        for(int j=0;j<=i;j=j+i)
        {
            System.out.print(j);
        }
        System.out.println();
    }
}
}
