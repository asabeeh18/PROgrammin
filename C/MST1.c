//http://www.spoj.com/problems/MST1/
#include<stdio.h>
#include<malloc.h>
unsigned long min(unsigned long a,unsigned long b)
{
		if(a<b) return a;
		return b;
}
int main()
{
	unsigned long n,i;
	int t;
	scanf("%d",&t);
	unsigned long dp[20000000];
	//printf("%llu",(n+1)*sizeof(unsigned long));
	//dp[1]=0;
	while(t--)
	{
		scanf("%lu",&n);
		//dp=(unsigned long*)malloc((n+1)*sizeof(unsigned long));
		//printf("%lu\n",(n+1)*sizeof(unsigned long));
		
		//0 1 2 3 4
		//- 0 1 2 2
		for(i=2;i<=n;i++)
		{
			dp[i]=1+dp[i-1];
			if(i%2==0)
			dp[i]=min(dp[i],1+dp[i/2]);
			//dp[i]=(dp[i]<1+dp[i/2])?dp[i]:1+dp[i/2];
			if(i%3==0)
			dp[i]=min(dp[i],1+dp[i/3]);
			//printf("%llu\n",i);
		}
		printf("%lu\n",dp[n]);
		//free(dp);
	}
	return 0;
}	