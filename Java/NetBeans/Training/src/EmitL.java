import java.util.Scanner;

/*
 * Source:https://www.codechef.com/LTIME29/problems/EMITL
 * Status/Result: WA
 */

class EmitL {

    public static void main(String[] args)
    {
        Scanner r=new Scanner(System.in);
        int t=r.nextInt();
        //r.nextLine();
        while(t-->0)
        {
            char[] s=r.nextLine().toCharArray();
            //HashMap<Character,Integer> freq=new HashMap<>();
            int[] freq=new int[5];
            boolean t1=false,t2=false,t3=false,t4=false,t5=false;
            //ltime
            for(char c:s)
            {
                if(c=='L')
                {
                    freq[0]++;
                    if(freq[0]==2)
                        t1=true;
                }
                if(c=='T')
                {
                    freq[1]++;
                    if(freq[1]==2)
                        t2=true;
                }
                if(c=='I')
                {
                    freq[2]++;
                    if(freq[2]==2)
                        t3=true;
                }
                if(c=='M')
                {
                    freq[3]++;
                    if(freq[3]==2)
                        t4=true;
                }
                if(c=='E')
                {
                    freq[4]++;
                    if(freq[4]==2)
                        t5=true;
                }
                if(t1 & t2 & t3 & t4 & t5)
                {
                    break;
                }
            }
            if(t1 & t2 & t3 & t4 & t5)
            {
                System.out.println("Yes");
             
            }
            else
            {
                if(s.length==9 && t1 & t2 & t3 & t4 && (freq[4]==1))
                {
                    System.out.println("Yes");
                }
                else
                    System.out.println("No");
            }
        }
    }
    
}
