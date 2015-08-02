//https://www.hackerrank.com/contests/countercode/challenges/degree-of-dirtiness
import java.util.*;

public class Toilet {

    public static void main(String[] args) {
        Scanner r=new Scanner(System.in);
		int t=r.nextInt();
		while(t-->0)
		{
			int n=r.nextInt();
			int m=r.nextInt();
			int rem=0,toi;
			rem=m%n;
			if(rem==0)
				toi=n/2+1;
			else if(m%2==0)
				toi=n-rem/2;
			else 
				toi=rem/2+1;
			if(rem%2==0 && rem!=0)
				toi++;
			System.out.println((toi)+" "+m/n);
		}
    }
}