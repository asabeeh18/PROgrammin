#include<stdio.h>
#include<malloc.h>
int main()
{
	int t,i,j,n,*a,l,g;
	scanf("%d",&t);
	while(t--)
	{
		l=0;
		g=0;
		scanf("%d",&n);
		a=(int*)malloc(n*sizeof(int));
		for(i=0;i<n;i++)
			scanf("%d",&a[i]);
		for(i=0;i<n-1;i++)
		{
			if(a[i]>a[i+1])
			{
				l++;
				g++;
			}
			for(j=i+2;j<n;j++)
				if(a[i]>a[j])
					g++;
		}
		if(l==g)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}