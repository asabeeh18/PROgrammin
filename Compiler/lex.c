#include<stdio.h>
#include<string.h>
#include<ctype.h>
#define LN 20
int ala[10];
char var[10][10];
int varC = -1;
int oper(int i, char str[LN])
{
	int c = i;
	if (str[i] == '(' || str[i] == ')' || str[i] == '+' || str[i] == '*' || str[i] == '=')
	{
		printf("Operator %c\n", str[i]);
		i++;
	}
	return i;
}
int chkNum(int i, char s[LN])
{
	int c = i;
	while (isdigit(s[i]))
		i++;
	s[i] = '\0';
	printf("literal:%s\n", &s[c]);
	return i;
}
int chkDatatype(char s[LN])
{
	char INT[4] = "int";
	char CHAR[5] = "char";
	char LONG[6] = "long";
	int i = 0, j;
	if (strncmp(s, INT, 3) == 0)
	{
		printf("int datatype\n");
		i += 3;
	}
	else if (strncmp(s, CHAR, 4) == 0)
	{
		printf("char datatype\n");
		i += 4;
	}
	else if (strncmp(s, LONG, 4) == 0)
	{
		printf("long datatype\n");
		i += 4;
	}
	else
	{
		return 0;
	}
	j = 0;
	i++;
	varC++;
	while (isalpha(s[i]))
	{
		var[varC][j] = s[i];
		i++;
		j++;
	}
	var[varC][j] = '\0';
	if (s[i] == ';')
		return 1;
	else if (s[i] == '=')
	{
		chkNum(i + 1, s);
	}
	return 1;
}
int chkExpression(int i, char s[LN])
{
	char ch[10];
	int j;
	while (s[i] != ';' && s[i] != ')')
	{
		j = 0;
		if (isdigit(s[i]))
			i = chkNum(i, s);
		else if (isalpha(s[i]))
		{
			while (isalpha(s[i]))
			{
				ch[j] = s[i];
				j++;
				i++;
			}
			ch[j] = '\0';
			printf("Identifier: %s\n", ch);
		}
		else
		{
			i = oper(i, s);
		}
	}

}
int chkKeyword(char s[LN])
{
	char IF[3] = "if";
	char ELSE[5] = "ELSE";
	int i = 0;
	if (strncmp(s, IF, 2) == 0)
	{
		printf("if keyword\n");
		i += 2;
		chkExpression(i, s);
		return 1;
	}
	else if (strncmp(s, ELSE, 4) == 0)
	{
		printf("else keyword\n");
		i += 3;
		chkExpression(i, s);
		return 1;
	}
	return 0;
}

void type(char str[LN])
{
	int i = 0;
	while (i<strlen(str))
	{
		if (chkDatatype(str))
			return;
		if (chkKeyword(str))
			return;
		if (chkExpression(0, str))
			return;
	}
}
int main()
{

	FILE *fp;
	char str[LN];
	int i = 0;
	fp = fopen("lex.txt", "r");
	if (fp == NULL)
	{
		printf("Error opening file");
		return 0;
	}
	while (!(feof(fp)))
	{
		printf("\n");
		fgets(str, LN, fp);
		type(str);
	}
	printf("Variable list\n");
	for (i = 0; i <= varC; i++)
	{
		printf("%s\n", var[i]);
	}
	fcloseall();
}