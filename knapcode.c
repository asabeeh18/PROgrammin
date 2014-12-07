//knap
#include<stdio.h>
int n,w[10000],c[10000],pw[10000];
int max(int a, int b) { return (a > b)? a : b; }
int f(int W)
{
   int i,j;
   int K[n+1][W+1];
 
   // Build table K[][] in bottom up manner
   for (i = 0; i <= n; i++)
   {
       for (j= 0; j<= W; j++)
       {
           if (i==0 || j==0)
               K[i][j] = 0;
           else if (w[i-1] <= j)
                 K[i][j] = max(c[i-1] + K[i-1][j-w[i-1]],  K[i-1][j]);
           else
                 K[i][j] = K[i-1][j];
       }
   }
 
   return K[n][W];
}
int main()
{
	int i,cap=0,tcap;
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		scanf("%d%d",&w[i],&c[i]);
		cap+=w[i];
		//pw[i]=p[i]/w[i];
	}
	for(tcap=1;tcap<=cap;tcap++)
	{
		printf("%d ",f(tcap));
	}
    return 0;
}	
		