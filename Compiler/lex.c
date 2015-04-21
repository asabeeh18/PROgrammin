/*
	Keywords               (eg: int, while),
	Identifiers               (eg: main, total),
	Constants              (eg: 10, 20),
	Strings                    (eg: “total”, “hello”),
	Special symbols  (eg: (), {}),
	Operators              (eg: +, /,-,*)
*/
#include<stdio.h>
#include<string.h>
#include<ctype.h>
#define LN 20
int ala[10];
char var[10][10];
int varC=-1;
int identifier(int i,char str[LN])
{
	int c=i;
	while(str[i]!=' ' && str[i]!='+' && str[i]!='*' && str[i]!='=' && i<strlen(str))
	i++;
	printf("identifier %d %d\n",c,i);
	return i;
}
int chkNum(int i,char s[LN])
{
	int c=i;
	while(isdigit(s[i]))
		i++;
	s[i]='\0';
	printf("literal:%s\n",&s[c]);
	return i;
}
int chkDatatype(char s[LN])
{
	char INT[3]="int";
	char CHAR[4]="char";
	char LONG[4]="long";
	int i=0,j;
	if(strncmp(s,INT,3)==0)
	{
		printf("int datatype\n");
		i+=3;
	}
	else if(strncmp(s,CHAR,4)==0)
	{
		printf("char datatype\n");
		i+=4;
	}
	else if(strncmp(s,LONG,4)==0)
	{
		printf("long datatype\n");
		i+=4;
	}
	else
	{
		return 0;
	}
	j=0;
	i++;
	varC++;
	while(isalpha(s[i]))
	{
		var[varC][j]=s[i];
		i++;
		j++;
	}
	var[varC][j]='\0';
	if(s[i]==';')
		return 1;
	else if(s[i]=='=')
	{
		chkNum(i+1,s);
	}
	return 1;
}
int type(char str[LN])
{
	/* keywords	int char long short
		identifier
		literals
		assign =
		operator + - * % 
		;
	*/
	
	char IF[2]="if";
	char ELSE[4]="ELSE";
	int i=0;
	while(i<strlen(str))
	{
		if(chkDatatype(str))
			return;
		//else if(chkKeyword());
		//else if(chkExpression());
	}
	/*
		else if(strncmp(str,IF,2)==0)
		{
		printf("if keyword\n");
		i+=2;
		}
		else if(strncmp(str,ELSE,3)==0)
		{
		printf("else keyword\n");
		i+=3;
		}
		else if(isalpha(str[i]))
		{
		i=identifier(i,str);
		}
		else if(isdigit(str[i]))
		{
		i=digit(i,str);
		}
		else	i++;
		
		}
		//	strcpy(INT,"int");
		*/
}
int main()
{
	
    FILE *fp;
    char str[LN];
	int i=0;
	fp = fopen("lex.txt" , "r");
	if(fp == NULL) 
	{
		printf("Error opening file");
		return 0;
	}
   	while(!(feof(fp)))
	{
		printf("\n");
		fgets(str, LN, fp);
		type(str);
	}
	printf("Variable list\n");
	for(i=0;i<=varC;i++)
	{
		printf("%s\n",var[i]);
	}
	fcloseall();
	
}
