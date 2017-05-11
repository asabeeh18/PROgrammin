//Peephole Optimisation->Simple COnstatn FOldnig
#pragma warning (disable : 4996)
#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>

#define LN 50
float numa, numb;
char opers = '@';

void eval()
{
	switch (opers)
	{
	case '+':	numa = numa + numb;
		break;
	case '-':	numa = numa - numb;
		break;
	case '*':	numa = numa*numb;
		break;
	case '/':	numa = numa / numb;
		break;
	default: 	printf("Wrong Operator");
	}
	opers = '@';
}
int oper(int i, char str[LN])
{
	int c = i;
	if (str[i] == '-' || str[i] == '+' || str[i] == '/' || str[i] == '*')
	{
		opers = str[i];
		i++;
	}
	return i;
}
int chkNum(int i, char s[LN])
{
	char n[10];
	int j = 0;
	while (isdigit(s[i]) && i<strlen(s))
	{
		n[j] = s[i];
		i++;
		j++;
	}
	n[j] = '\0';
	if (opers == '@')
		numa = atoi(n);
	else
	{
		numb = atoi(n);
		eval();
	}
	return i;
}
int chkExpression(int i, char s[LN])
{
	char ch[10];
	int j;
	while (s[i] != ';' && s[i] != ')')
	{
		j = 0;
		if (isdigit(s[i]))
		{
			i = chkNum(i, s);

		}
		else if (isalpha(s[i]) || s[i] == ' ' || s[i] == '\n')
		{
			return 0;
		}
		else
		{
			i = oper(i, s);
		}
	}
	return 1;

}
int main()
{
	FILE *fp,*fpeep;
	char str[LN],res[LN];
	int i = 0;
	fp = fopen("peep.txt", "r");
	fpeep = fopen("peepOpt.txt", "w");
	if (fp == NULL)
	{
		printf("Error opening file");
		return 0;
	}
	while (!(feof(fp)))
	{
		fgets(str, LN, fp);
		i = 0;
		while (isalpha(str[i]) && str[i] != '=')
			i++;
		i++;
		if (chkExpression(i, str))
		{
			str[i] = '\0';
			sprintf(res, "%f", numa);
			sprintf(str, "%s%s;\n", str, res);
		}
		fputs(str, fpeep);
	}
	fcloseall();
	return 0;
}