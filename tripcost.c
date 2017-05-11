//( ∑ ( 6 * x * y * z * Fibo[x] * Fibo[y] * Fibo[z] ) ) % M , where x + y + z = N.
#include<stdio.h>
#include<alloc.h>
int main()
{
	unsigned long long d;
	
	int n,t,D,L,C,i;
	int c[10000],di[10000];
	scanf("%d",&t);
	while(t--)
	{
		scanf("%d %d",&n,&d);
		for(i=0;i<n;i++)
			scanf("%d %d",&c[i],&di[i]);
		i=0;
		printf("Y");
	while(i!=n)
		{
			D=0;
			while(D+di[i]<=d)
			{
				D+=di[i];
				i++;
			}
			i--;
			L++;
			C=c[i]>C?c[i]:C;
		}
	}
}