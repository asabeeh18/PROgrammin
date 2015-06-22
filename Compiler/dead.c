//Deadcode elimination
#include<stdio.h>
#include<string.h>
#include<malloc.h>
#define LN 50
int main()
{
	FILE *fp,*fdead;
	char *str,*res;
	int i = 0;
	str=(char *)malloc(50*sizeof(char));
	res=(char *)malloc(50*sizeof(char));
	fp = fopen("dead.txt", "r");
	fdead = fopen("deadOpt.txt", "w");
	if (fp == NULL)
	{
		printf("Error opening file");
		return 0;
	}
	while (!(feof(fp)))
	{
		fgets(str, LN, fp);
		res=strstr(&str[0],"return");
		if(res==NULL)
		{
			fputs(str,fdead);
			continue;
		}
		else
		{
			fputs(str,fdead);
			fgets(str, LN, fp);
			res=strstr(str,"}");
			while(res==NULL)
			{
				fgets(str, LN, fp);
				res=strstr(str,"}");
			}
			fputs(str,fdead);
		}
	}
	fcloseall();
}