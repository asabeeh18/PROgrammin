#include<stdio.h>
int main()
{
	long int n;
	int t;
	scanf("%d",&t);
	while(t--)
	{
		scanf("%ld",&n);
		printf("%ld\n",n/2+1);
	}
}