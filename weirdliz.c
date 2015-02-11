#include<stdio.h>
#include<malloc.h>
#define flip(x) ((x=='L')?'R':'L')
int main()
{
    int n,i,q,d,b,c,k,j;
    char *a;
    scanf("%d",&n);
    a=(char *)malloc(n*sizeof(char));
	getchar();
	for(i=0;i<n;i++)
	{
        a[i]=getchar();
	}
	scanf("%d",&q);
	for(i=0;i<q;i++)
	{
		c=0;
		scanf("%d%d",&d,&b);
		for(j=d;j<=b;j++)
			a[j]=flip(a[j]);
		for(j=0;j<n-1;j++)
		{
			if(a[j]=='R')
				for(k=j+1;k<n;k++)
					if(a[k]=='L')
						c++;
		}
		printf("%d",c);
	}
	return 0;
}	