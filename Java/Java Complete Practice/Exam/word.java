import java.io.*;
class word

{
  int m=0,m2=0;
  String a,b,c,v,p,z,o,s,f,e,r,t,q,ma,ms,mr,me,mo,mh,mj;
  String g="teen"; 
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
    System.out.println("Enter the no.");
    int n=Integer.parseInt(bf.readLine());
    
    switch(n)
    {
        case 1: a="one";
        System.out.println(a);
        break;
        case 2: b="two";
        System.out.println(b);
        break;
        case 3: c="three";
        System.out.println(c);
        break;
        case 4: v="four";
        System.out.println(v);
        break;
        case 5: p="five";
        System.out.println(p);
        case 6: z="six";
        System.out.println(z);
        case 7: o="seven";
        System.out.println(o);
        case 8: s="eight";
        System.out.println(s);
        case 9: f="nine";
        System.out.println(f);
        case 10: e="ten";
        System.out.println(e);
        case 11: r="eleven";
        System.out.println(r);
        case 12: t="twelve";
        System.out.println(t);
        case 13: q="thirteen";
        System.out.println(q);
        case 14: ma="fourteen";
        System.out.println(ma);;
        case 15: ms="fifteen";
        System.out.println(ms);
        case 16: mr="six"+g;
        System.out.println(mr);
        case 17: mo=o+g;
        System.out.println(mo);
        case 18: me=s+g;
        System.out.println(me);
        case 19: mh=f.concat(g);
        System.out.println(mh);
        break;
        case 20: mj="twenty";
        System.out.println(mj);
        break;
    }
    

        
 
    
    
}
}