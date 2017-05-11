//http://www.hackerearth.com/taxiforsure-hiring-challenge/algorithm/haunted/
#include<stdio.h>
#include<malloc.h>
int max(int *f,int n)
{
	int i,max=n-1;
	for(i=n-1;i>=0;i--)
		if(f[i]>f[max])
			max=i;
	return max;
}
int main()
{
	int *f,*a,i,j,m,n;
	scanf("%d %d",&n,&m);
	f=(int *)malloc(m*sizeof(int));
	a=(int *)malloc(n*sizeof(int));
	//init
	for(i=0;i<m;i++)
		f[i]=0;
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
		f[a[i]]++;
		j=max(f,m);
		printf("%d %d\n",j,f[j]);
	}
}