//1 2 3 5 7 11
//http://www.codechef.com/problems/COINS/
#include<stdio.h>

long long int dividor(long long int n)
{
	if(n==1LL || n==2LL || n==3LL || n==5LL || n==7LL || n==11LL)
		return n;
	return dividor(n/2)+dividor(n/3)+dividor(n/4);
}
int main()
{
	long long int n;
	int i=0;
	while(i<=1000000000)
	{
		
		n=dividor(++i);
		printf("%llu\n",n);
		i++;
	}
	return 0;
}