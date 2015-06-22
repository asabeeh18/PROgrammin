//knap
#include<stdio.h>
int n,w[10000],c[10000];
int max(int a,int b)
{
    if(a>b)
        return a;
    return b;
}
int f(int i,int cp)
{
    if(i==n)
		return (cp<w[i])?0:c[i];
	if(cp<w[i])
		return f(i+1,cp);
	return max(f(i+1,cp),f(i+1,cp-w[i])+c[i]);
}
int main()
{
	int i,cap=0,tcap;
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		scanf("%d%d",&w[i],&c[i]);
		cap+=w[i];
	}
	for(tcap=1;tcap<=cap;tcap++)
	{
		printf("%d ",f(0,tcap));
	}
    return 0;
}	
		