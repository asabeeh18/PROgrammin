
import java.util.HashMap;
import java.util.Scanner;


//https://www.codechef.com/problems/COMM3
//Shameful Series: 7
class Forgpttem
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        
        while(t-->0)
        {
            HashMap<String,Integer> hs=new HashMap<>();
            int n=in.nextInt();
            int m=in.nextInt();
            in.nextLine();
            boolean[] c=new boolean[n];
            String s[]=in.nextLine().split(" ");
            for(int i=0;i<n;i++)
            {
                hs.put(s[i],i); 
            }
            
            
            for(int i=0;i<m;i++)
            {
                int k=in.nextInt();
                s=in.nextLine().split(" ");
                for(int j=0;j<k;j++)
                {
                    if(hs.containsKey(s[j]))
                    {
                        c[hs.get(s[j])]=true;
                    }
                                
                }
            }
            for(int i=0;i<n;i++)
            {
                
                if(c[i])
                    System.out.print("Yes");
                else
                    System.out.print("No");
                if(i!=n-1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}