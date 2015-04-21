//http://www.codechef.com/PSCD2015/problems/PSUDO4
#include<stdio.h>
#include<string.h>
void main()
{
	int t,n,sum,i;
	char s[50];
	scanf("%d",&t);
	while(t--)
	{
		scanf("%s",s);
		n=strlen(s);
		sum=0;
		for(i=0;i<n;i++)
		{
			sum+=s[i];
		}
		sum=sum-n*64;
		printf("%d\n",sum);
	}
	
}