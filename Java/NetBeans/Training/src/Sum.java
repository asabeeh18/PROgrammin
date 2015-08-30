import java.util.*;
class Sum
{
	
	static int prevent[];
        static int MON=0;
	static void display(int w[], int x[], int k)
	{
		int i=0;
                int j=0;
		while (j < MON && i<=k)
                {
                     if(x[i]==1)
                     {
                         
                         if(prevent[j] != w[i])
                             break;
                         j++;
                     }
                   
                    i++;
                    
                }
		if (i == k + 1)
		return;
                MON=0;
                int count=0;
                for(i=0;i<=k;i++)
                    if(x[i]==1)
                        count++;
		for (i = k; i >= 0; i--)
		{
                        
			if (x[i] == 1)
                        {
                            prevent[--count] = w[i];
                            MON++;
                            System.out.print(w[i]+" ");
                        }
		}
		System.out.println();
	}
	
	static void sort(int w[], int n)
	{
		int i, j, temp;
		for (i = 0; i<n - 1; i++)
		for (j = 0; j<n - i - 1; j++)
		if (w[j]>w[j + 1])
		{
			temp = w[j];
			w[j] = w[j + 1];
			w[j + 1] = temp;
		}
		
	}
	
	static void sumOfSubsets(int w[], int x[], int sum, int rsum, int csum, int k, int n)
	{
		if (w[0]>sum)
		{
			System.out.println("Sum not possible from these weights");
			return;
		}
		x[k] = 1;
		if (csum + w[k] == sum)
		{
			display(w, x, k);
			return;
		}
		else	if (csum + w[k] + w[k + 1] <= sum && k + 1<n)
		sumOfSubsets(w, x, sum, rsum - w[k], csum + w[k], k + 1, n);
		if (csum + rsum - w[k] >= sum && csum + w[k + 1] <= sum && k + 1<n)
		{
			x[k] = 0;
			sumOfSubsets(w, x, sum, rsum - w[k], csum, k + 1, n);
		}
	}
	
	public static void main(String arg[])
	{
		int w[], x[], sum, rsum = 0, i;
		Scanner r=new Scanner(System.in);
		StringTokenizer s=new StringTokenizer(r.nextLine()," ");
		int n=s.countTokens();
		w=new int[n];
		x=new int[n];
		prevent=new int[n];
		
		sum=r.nextInt();
		for (i = 0; i<n; i++)
		{
			w[i]=Integer.parseInt(s.nextToken());
			rsum += w[i];
			x[i] = 0;
		}
		sort(w, n);
		sumOfSubsets(w, x, sum, rsum, 0, 0, n);
	}
}	