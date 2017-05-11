//nmh tk tk
#include<stdio.h>
int main()
{
    long long int n,m,h,t[10000],c[10000],ctr=0,k,i,j,cp=0,cst=0;
    scanf("%d%d%d",&n,&m,&h);
	for(i=0;i<h;i++)
	{
		scanf("%d%d",&t[i],&c[i]);
	}
    for(i=0;i<h;i++)
        printf("\n%d %d",t[i],c[i]);
    
	for(i=0;i<n-1;i++)
		for(j=0;j<n-1;j++)
			if(c[j]>c[j+1])
			{
                printf("IN");
				k=c[j];
				c[j]=c[j+1];
				c[j+1]=k;
				k=t[j];
				t[j]=t[j+1];
				t[j+1]=k;
			}
    for(i=0;i<h;i++)
        printf("\n%d %d",t[i],c[i]);
	for(i=0;i<h && cp<m*n;i++)
	{
		if((cp+t[i])>m*n)
		{
			cp+=m*n-cp;
			cst+=(m*n-cp)*c[i];
		}
		else
		{
			cp+=t[i];
			cst+=t[i]*c[i];
		}	
	}
	if(cp==m*n)
		printf("%d",cst);
	else
		printf("Impossible");
	return 0;
}	