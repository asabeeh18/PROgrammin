//https://www.hackerrank.com/challenges/reduced-string
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
	char s[100],c[100];
	int i,k=0;
    scanf("%s",s);
	c[k]=s[0];
	for(i=1;i<strlen(s);i++)
	{
		if(s[i]==c[k])
		{
			k--;
			if(k<0)
			{
				k=0;
				c[k]=s[i+1];
				i++;
			}
		}
		else
		{
			k++;
			c[k]=s[i];
		}
	}
	c[k+1]='\0';
	if(strlen(c)==0)
	{
		printf("Empty String");
	}
	else
		printf("%s",c);
    return 0;
	
}
