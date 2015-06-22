#include<stdio.h>
#include<stdlib.h>

int main()
{
	long long *a,n,k,i,max,nmax,j;
	scanf("%lld %lld",&n,&k);
	a=(long long *)malloc(n*sizeof(long long));
	scanf("%lld",&a[0]);
	max=a[0];
	for(i=1;i<n;i++)
	{
		scanf("%lld",&a[i]);
		if(max<a[i])
			max=a[i];
	}
	nmax=max;
	k=k%2==0?2:1;
	printf("%lld\n",k);
	for(j=0;j<k;j++)
	{
		max=nmax;
		nmax=max-a[0];
		for(i=0;i<n;i++)
		{
			a[i]=max-a[i];
			//printf("%d ",a[i]);
			if(nmax<a[i])
				nmax=a[i];
		}
	}
	for(i=0;i<n;i++)
		printf("%d ",a[i]);	
	return 0;
}
