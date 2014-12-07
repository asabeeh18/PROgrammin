#include<stdio.h>
void main()
{
	unsigned long long int a,i,k;
	scanf("%llu",&a);
	for(i=0,k=1;i!=a && i<a && k!=a;i++,k+=6)
	{
		if(i*3==a)
			break;
		if(k==a)
			break;
	}	
	if(i*3==a||k==a)
		printf("yes");
	else
		printf("no");
}		