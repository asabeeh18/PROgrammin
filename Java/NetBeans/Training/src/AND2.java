import java.util.*;

public class AND2
{
    static long maxand=0,c;
    static int k;
    static ArrayList<Long> t;
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        k = in.nextInt();
        //a= new long[n];
        long a;
        ArrayList<Long> t;
        HashMap<Integer,ArrayList<Long>> h=new HashMap<>();
        for(int i=0; i < n; i++)
        {
            a = in.nextLong();
            double d=Math.log(a)/Math.log(2);
            int c=(int)d+1;
            if(h.containsKey(c))
            {
                t=h.get(c);
                t.add(a);
                h.put(c, t);
            }
            else
            {
                t=new ArrayList();
                t.add(a);
                h.put(c, t);
            }
        }
        
        ArrayList<Integer> s=new ArrayList<>();
        for (Map.Entry<Integer,ArrayList<Long>> i : h.entrySet())
        {
            t=i.getValue();
            if(t.size()>=k)
            {
                s.add(i.getKey());
            }
        }
        //s.sort(s);
        Object[] zok=s.toArray();
        Integer[] b = Arrays.copyOf(zok, zok.length, Integer[].class);

        //Integer[] b=(Integer[])s.toArray();
        Arrays.sort(b);
        for(int i=b.length-1;i>=0;i++)
        {
            
            t=h.get(b[i]);
            for(int j=0;j<t.size();j++)
            {
                solve(1,j+1,t.get(j));
            }
            System.out.println(maxand);
        }
        //System.out.println(maxand+"\n"+c);
    }

    
    static long solve(int l,int i,long and)
    {
        long ans;
        if(l<k)
        {
            for(int j=i;j<t.size();j++)
            {
               ans=solve(l+1,j+1,and&t.get(j));
               //System.out.print("Set for: "+and+ "&"+a[j]+"="+ans);
               if(l==k-1 && ans>maxand)
               {
                   //System.out.print(",new,");
                   c=1;
                   maxand=ans;
               }
               else if(l==k-1 && ans==maxand)
               {
                   //System.out.print(",same,");
                   c++;
               }
               
            }
        }
        else return and;
        return maxand;
    }
}