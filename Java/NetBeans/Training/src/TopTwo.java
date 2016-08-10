
import java.util.Scanner;

/*
 * Source:https://www.codechef.com/NPLTZ15/problems/SCORES
 * Status/Result:NZEC 
 */

class TopTwo {

    public static void main(String[] args)
    {
        Scanner r=new Scanner(System.in);
        int n=r.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=i;//r.nextInt();
        int max1,max2;
        max1=a[0]>a[1]?a[0]:a[1];
        max2=a[0]>a[1]?a[1]:a[0];
        for(int i=2;i<n;i++)
        {
            if(a[i]>max1)
            {
                max2=max1;
                max1=a[i];
            }
            else if(a[i]>max2)
            {
                max2=a[i];
            }
        }
        System.out.println(max1+" "+max2);
    }
    
}
