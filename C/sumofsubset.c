#include<stdio.h>
int v[10],x[10],sumreq,n;
int sum(int k)
{
    int s=0,i;
    for(i=0;i<k;i++)
		s+=x[i];
	return s;
}	
int proper(int k,int i)
{
	int j;
	for(j=0;j<=k-1;j++)
		if(x[j]==v[i])
			return 0;
	if(sum(k-1)+v[i]>sumreq)
		return 0;
	return 1;
}
void sumset(int k)
{
    int i,j,s;
	for(i=k;i<n;i++)
	{
		if(proper(k,i))
		{
			x[k]=v[i];
			s=sum(k);
			if(s==sumreq)
			{
                printf("Possible Solution\n");
				for(j=0;j<k;j++)
					printf(" %d ",x[j]);
				printf("\n");
                return;
			}
			sumset(k+1);
		}
	}
}	
void main()
{
    int i;    
	printf("number of values: ");
	scanf("%d",&n);
	printf("SUM REQ  ");
	scanf("%d",&sumreq);
	printf("Enter non repeating ascending values  ");
	for(i=0;i<n;i++)
		scanf("%d",&v[i]);
	sumset(0);
}	