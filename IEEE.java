import java.util.*;
public class MAIN
{
    public static void main(String args[])
    {
        Scanner src=new Scanner(System.in);
        double db=src.nextDouble(),bk;
        bk=db;
    //    String s=bk+"";
        int i=0;
        int bin[]=new int[1000];
        while(bk!=0)
        {    
            int u=(int)(bk%2);
            bin[i]=u;
            bk=(int)(bk/2);
            i++;
        }
        bk=db;
        for(int j=i+1;j>=0;j--)
            System.out.print(bin[j]);
        int dec[]=new int[1000];
        bk=bk-(int)bk;
        String s=bk+"";
        int l=s.length();
        i=0;
        while(i<l)
        {
            dec[i]=(int)(bk*2);    
            System.out.println(bk+" "+dec[i]);
            bk=(int)(bk*2);
            System.out.println(bk);
            bk=bk-(int)bk;
            i++;
               System.out.println(bk);
        }    
        System.out.println();
        for(int j=i+1;j>=0;j--)
            System.out.print(dec[j]);

            
    }

}    

