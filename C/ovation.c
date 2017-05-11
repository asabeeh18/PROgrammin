//https://code.google.com/codejam/contest/6224486/dashboard
#include<stdio.h>

int main()
{
	int t,sum,n,a,p,f,c;
	char str[1000];
	
	
	scanf("%d",&t);
	for(a=0;a<t;a++)
	{
		p=0;
		sum=0;
		n=0;
		c=0;
		f=0;
		scanf("%d %s",&sum,str);
		//printf("%s",str);
		//n=sum-1;
		while(n<=sum)
		{
			c=n-p;
			if(c<=0)
				p+=str[n]-'0';
			else 
			{
				f+=c;
				p+=c+str[n]-'0';
			}
			n++;
		}
		printf("Case #%d: %d\n",a+1,f);
		
		
	}
	
}