
import java.util.Arrays;

class Passing
{
    public static int passCount(int n,int l,int m)
    {
        int[] count=new int[n+1];
        Arrays.fill(count,0);
        
        int i=1,passes=0;
        
        count[1]++;
        while(count[i]<m)
        {
            if(count[i]%2==0)
            {
                i=(i+l)%(n);
                if(i==0)
                    i=n;
            }
            
            else
            {
                i=(i+(n-l))%(n);
                
                if(i<1)
                {
                    i=n;
                }
            }
            count[i]++;
            passes++;
        }
        // 1 4 2 5 3 1 3 5 2 4 1
        return passes;
    }
    public static void main(String ar[])
    {
        passCount(5,2,3);
    }
}