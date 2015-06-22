//Brute force
#include<stdio.h>
#include<string.h>
int brute(char t[20],char p[20])
{
    int i,j;
	for(i=0;i<=(strlen(t)-strlen(p));i++)
	{
		j=0;
		while(t[i+j]==p[j])
		{
			if(j==strlen(p)-1)
				return i;
			else
				j++;
		}
	
	}
        return -1;
}	
void main()
{
	char t[20],p[20],i;
	printf("Enter String");
	scanf("%s",t);
	printf("PAttern");
	scanf("%s",p);
	if((i=brute(t,p))==-1)
		printf("Pattern not found");
	else
		printf("Pattern found at index %d",i);
}		
	