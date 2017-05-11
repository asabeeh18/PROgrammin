//http://www.codechef.com/LTIME23/problems/TICKETS5
#include<stdio.h>
#include<string.h>
#include<malloc.h>
#include<ctype.h>
int main()
{
	int n,t,i;
	char *s;
	scanf("%d",&t);
	s=(char *)malloc(101*sizeof(char));
	for(;t>0;t=t-1)
	{
		//s[0]='\0';
		scanf("%s",&s);
		for(i=0;i<strlen(s)-2;i++)
		{
			if(!isupper(s[i]) || !isupper(s[i+2]))
					break;
			if(s[i]!=s[i+2] && s[i]!=s[i+1])
					break;			
		}
		if(i==strlen(s)-2)
			printf("YES\n");
		else
			printf("NO\n");
		printf("T: %d\n",t);
	}
	return 0;
}