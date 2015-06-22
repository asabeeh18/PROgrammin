//https://www.hackerrank.com/challenges/sherlock-and-the-beast
// 99 899
#include<stdio.h>
#include<assert.h>
int main()
{
	int t;
	long long n,k=0,i=0;
	scanf("%d",&t);
	assert(t<=20 && t>=1);
	while(t--)
	{
		i=0;
		k=n;
		scanf("%lld",&n);
		assert(1<=n && n<=100000);
		k=n;		
		while(k>=0 && k%3!=0)
			{
				i++;
				k=n-(i*5);
			}
			if(k<0)
			{
				printf("-1\n");
			}
			else
			{
				while(k--)
					printf("5");
				i*=5;
				while(i--)
				{
					printf("3");
				}
				printf("\n");
			}
	}
	return 0;
}