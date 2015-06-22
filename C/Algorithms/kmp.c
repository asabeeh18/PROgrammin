//KMP
#include<stdio.h>
#include<string.h>
int f[20];
void fail(char p[20])
{
    int i=1,j=0;
    while(i<strlen(p))
	{
		if(p[i]==p[j])
		{
			f[i]=j+1;
			j++;
			i++;
		}
		else if(j>0)
			j=f[j-1];
		else
		{
			f[i]=0;
			i++;
		}
	}
}
int kmp(char t[20],char p[20])
{
	int i=0,j=0,n=strlen(t),m=strlen(p);
	while(i<n)
	{
		if(t[i]==p[j])
		{
			if(j==m-1)
				return n-m;
			else
			{
				i++;
				j++;
			}	
		}		
		else if(j>0)	
			j=f[j-1];
		else
			i++;
	}
	return -1;
}	
				
void main()
{
	char t[20],p[20],i;
	printf("Enter String");
	scanf("%s",t);
	printf("Pattern");
	scanf("%s",p);
	fail(p);
	if((i=kmp(t,p))==-1)
		printf("Pattern not found");
	else
		printf("Pattern found at index %d",i);
}		
	