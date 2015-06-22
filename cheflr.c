#include<stdio.h>
#include<string.h>
int calc(char d,long r)
{
	if(r%2==0)
	{
		if(d=='l')
			return r*2-1;
		else if(d=='r')
			return r*2+1;
	}
	else
	{
		if(d=='l')
			return r*2;
		else if(d=='r')
			return r*2+2;
	}	
}
int main()
{
	int t,i,l;
	long r;
	char s[100000];
	scanf("%d",&t);
	while(t--)
	{
		r=1;
		scanf("%s",&s);
		l=strlen(s);
		for(i=0;i<l;i++)
		{
			r=calc(s[i],r);
		}
		printf("%d\n",r);
	}
	return 0;
}	