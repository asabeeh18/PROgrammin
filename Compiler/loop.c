//Loop optimisation
#include<stdio.h>
#pragma warning (disable : 4996)
#include<string.h>
#include<malloc.h>
#define LN 50
int main()
{
	FILE *fp,*foll;
	char *str, *res, var, *(*list),*bt,*bx;
	int i = 0;


	str = (char *)malloc(50 * sizeof(char));
	res = (char *)malloc(50 * sizeof(char));
	bt = (char *)malloc(1000 * sizeof(char));
	bx = (char *)malloc(1000 * sizeof(char));
	bt[0] = '\0';	//things above loop
	bx[0] = '\0';	//things in loop
		fp = fopen("loop.txt", "r");
	foll = fopen("loopOpt.txt", "w");
	if (fp == NULL)
	{
		printf("Error opening file");
		return 0;
	}
	while (!(feof(fp)))
	{
		
		fgets(str, LN, fp);
		res = strstr(&str[0], "for");
		while (res == NULL)
		{
			//till for is found
			sprintf(bt, "%s%s", bt, str);
			fgets(str, LN, fp);
			res = strstr(str, "for");
		}
		sprintf(bx, "%s%s", bx, str);
		var = res[4];	//take loop variable

		fgets(str, LN, fp);
		sprintf(bx, "%s%s", bx, str);	//store opening bracket
		fgets(str, LN, fp);
		while (res == NULL)
		{
			res = strchr(str,var);	//chk if expression is using loop variable
			if (res != NULL)	//if yes keep it inside loop
			{
				sprintf(bx, "%s%s",bx, str);
			}
			else	//else shift it before loop
			{
				sprintf(bt, "%s%s",bt, str);
			}
			fgets(str, LN, fp);
			res = strstr(str, "}");	//chk for closing bracket
		}
	}
	sprintf(bx, "%s%s", bx, str);	//store closing bracket
	//write everything to file
	fputs(bt, foll);
	fputs(bx, foll);
	fcloseall();
	return 0;
}