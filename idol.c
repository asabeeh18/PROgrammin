//idol
/*
each person i has an integer number Ai.
Let's define functions F and G for a person with ID equals to i:
If i = 1(which means that person i is Mike), then Fi = Ai and Gi = 1;
Otherwise, let Y be the personal idol for i.
If FY + 1 < Ai, then Fi = Ai and Gi = 1;
If FY + 1 > Ai, then Fi = FY + 1 and Gi = GY;
If FY + 1 = Ai, then Fi = FY + 1 and Gi = GY + 1.


0 i NEW_VALUE - change the value of Ai to NEW_VALUE;
1 i - calculate Fi and Gi.
*/
#include<stdio.h>
long long int n,q,a[10000],g[10000],p[10000],f[10000];
void fandg()
{
    int i;
    for(i=1;i<=n;i++)
    {
        if(i==1)
        {
            f[1]=a[1];
            g[1]=1;	
        }
		if(f[p[i]]+1<a[i])
		{
			f[i]=a[i];
			g[i]=1;
		}
		if(f[p[i]]+1>a[i])
		{
			f[i]=f[p[i]]+1;
			g[i]=g[p[i]];
		}
		if(f[p[i]]+1==a[i])
		{
			f[i]=f[p[i]]+1;
			g[i]=g[p[i]]+1;
		}	
	}
}
int main()
{
	int i,x,nw,ch;
	scanf("%d%d",&n,&q);
	for(i=1;i<=n;i++)
		scanf("%d",&a[i]);
	for(i=2;i<=n;i++)
		scanf("%d",&p[i]);
	fandg();	
	for(i=0;i<q;i++)
	{
		scanf("%d",&ch);
		if(ch==1)
		{
			scanf("%d",&x);
			fandg();
            printf("%d %d\n",f[x],g[x]);
            
		}	
		else if(ch==0)
		{	
			scanf("%d%d",&x,&nw);
			a[x]=nw;
                fandg();
		}	
	}
    return 0;
}	