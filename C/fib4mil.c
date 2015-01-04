//http://www.hackerearth.com/UPESHourOfCode/algorithm/problem-2-18/
#include<stdio.h>
int main()
{
	long long t,i=1,j=2,s=1,es=0;
	while(j<4000000)
	{
		s+=j;
		if(j%2==0)
			es+=j;
		t=j;
		j+=i;
		i=t;
	}
	printf("%llu",es);		
	return 0;
}