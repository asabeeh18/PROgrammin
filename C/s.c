#include<stdio.h>
#include<stdlib.h>
 
int main(void)
{
	long long int *a,n,k,i,j,max;
	scanf("%lld %lld",&n,&k);
	a=(long long int *)malloc(n*sizeof(long long int));
	for(i=0;i<n;i++)
		scanf("%lld",&a[i]);
	for(j=0;j<k;j++)
	{
		max=a[0];
		for(i=0;i<n;i++)	
		{
			if(max<a[i])
				max=a[i];
			//printf("%d\t",max);
		}
		for(i=0;i<n;i++)
			a[i]=max-a[i];
		//printf("\n%d\n",a[j]);
	}
	for(i=0;i<n;i++)
		printf("%lld ",a[i]);
	
	return 0;
} 