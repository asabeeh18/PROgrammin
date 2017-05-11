#include<stdio.h>
#include<conio.h>
void main()
{
	int i,j;
	
	char s1[20],s2[20];
	scanf("%s",s1);
	scanf("%s",s2);
	printf("%s1 %s2  ",s1,s2);
	for(i=0;i<strlen(s1);i++)
	{
		if(s1[i]!=s2[i])
		{
			j=i;
			while(s1[i]!=s2[j] && j<strlen(s2))
			{
				printf("%c ",s2[j]);
				j++;
			}
		}
	}	
}