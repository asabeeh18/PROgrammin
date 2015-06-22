//Fractional Knapsack
#include<stdio.h>
void main()
{
    float pw[20],t;
    int i,j,o[20],p[20],w[20],n,m,profit=0;
	printf("Enter nmbr of objcts");
	scanf("%d",&n);
	printf("Enter max weight");
	scanf("%d",&m);
	
	printf("Enter Objects Profit Then Weight");
	for(i=0;i<n;i++)
	{
		scanf("%d %d",&p[i],&w[i]);
		o[i]=i;
		pw[i]=(float)p[i]/w[i];
	}	
	//Sort according to profit/weight ratio
	for(i=0;i<n;i++)
		for(j=0;j<n-i-1;j++)
			if(pw[j]<pw[j+1])
			{
				t=pw[j];
				pw[j]=pw[j+1];
				pw[j+1]=t;
				
				t=p[j];
				p[j]=p[j+1];
				p[j+1]=t;
				
				t=w[j];
				w[j]=w[j+1];
				w[j+1]=t;
				
				t=o[j];
				o[j]=o[j+1];
				o[j+1]=t;
			}
	for(i=0;i<n;i++)
	{
		if(m-w[i]>0)
		{
			m=m-w[i];
			profit+=p[i];
			printf("\nObject Added: %d Weight: %d Profit: %d ",o[i],w[i],p[i]);
		}
		else
			break;
	}
	if(i<n)
	{
		profit=profit+(pw[i])*m;
		printf("\nObject Added: %d Weight: %d Profit: %f ",o[i],m,(pw[i])*m);
	}	
    printf("\nPROFIT %d ",profit);
}	
			
				