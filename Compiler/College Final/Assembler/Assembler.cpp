//For some reason works only on VS
#include<stdio.h>
#include<malloc.h>
#include<string.h>
#include<stdlib.h>
//#include<stdafx.h>
//#define _CRT_SECURE_NO_DEPRECATE
#pragma warning (disable : 4996)
#define LN 20
int poz = 0;
char subs[20];
struct Symtab
{
	char sym[LN][LN];
	int val[LN];
	int len[LN];
	char ra[LN];
	int poz;
};
void tokeniser(char s[50])
{
	int i;


	for (i = poz; i<strlen(s); i++)
	{
		//printf("%c",s[i]);
		if (s[i] == ' ')
		{
			break;
		}
		subs[i - poz] = s[i];
	}
	//	printf("\n\n");
	subs[i - poz] = '\0';
	if (i == strlen(s))
		poz = 0;
	else poz = i + 1;



}
int main()
{
	FILE *fp;
	FILE *fw;
	char c[50];
	char e[50];
	char *token;
	int i;
	int *lc;
	int loc = 0;
	int line = 0;
	int col;
	int length;
	int varflag;
	int begin = 0;
	char *d;
	//define keywords
	char load[] = "L\0";
	char add[] = "A\0";
	char store[] = "ST\0";
	char dc[] = "DC\0";
	char ds[] = "DS\0";
	char start[] = "START\0";
	//char end[]="END\0";
	char using1[] = "USING\0";
	char drop[] = "DROP\0";
	char equ[] = "EQU\0";
	char base[] = "BASE\0";
	char end[] = "END\0";
	//define table strucutres
	struct Symtab st;


	fp = fopen("code.asm", "r");
	if (fp == NULL)
	{
		printf("Error opening file");
		return 0;
	}

	st.poz = 0;
	line = 0;
	//rewind(fp);
	while (1)
	{
		if (fgets(c, 50, fp) == NULL)
			break;
		if (!feof(fp))
		{
			c[strlen(c) - 1] = '\0';
			//c[strlen(c) - 1] = '\0';	not needed in VS
		}
		col = 0;
		token = strtok(c, " ");
		varflag = 0;
		while (token != NULL)
		{
			//printf("\n.%s.",token);
			//if(strcmp(token,load)==0)
			//	lc[0]=5;
			if (!strcmp(token, end))
			{
				//printf("END\n");
				break;
			}
			else if (!strcmp(token, load) || !strcmp(token, add) || !strcmp(token, store) || !strcmp(token, dc) || !strcmp(token, ds))
			{
				//opcode
				loc += 4;
				col++;
			}
			else if (!strcmp(token, using1))
			{
				//0 mem tokens
				token = strtok(NULL, " ");
				token = strtok(NULL, " ");
				printf("base %s ", token);
				begin = atoi(token);
				printf("begin:%d\n", begin);
				col++;
			}
			else if (col == 0)
			{
				//variable declaration

				strcpy(st.sym[st.poz], token);
				st.val[st.poz] = loc;
				st.len[st.poz] = 0;
				if (strcmp(token, base) == 0)
					st.ra[st.poz] = 'a';
				else
					st.ra[st.poz] = 'r';
				varflag = 1;
				col++;
				//printf("===BAKRA here: %s \n",token);

			}
			else if (col == 2)
			{
				//	printf("COL 2: %s ", token);
				if (!strcmp("F", token))
				{
					st.len[st.poz] = 4;
				}
				else if (!strcmp("H", token))
				{
					st.len[st.poz] = 2;
				}
				//operand column

				col++;
			}
			//printf( "'%s',,%s\n", token,load );

			token = strtok(NULL, " ");
			//col++;
			if (col>5)
				col = 0;
		}
		if (varflag == 1)
			st.poz++;
		line++;
		if (line>10)
			break;
	}

	//printf("%d  %d\n",loc,st.poz);
	printf("Symbol Value Length Relative/Absolute \n");
	for (i = 0; i<st.poz; i++)
	{
		printf("%5s    %2d    %3d    %2c \n", st.sym[i], st.val[i], st.len[i], st.ra[i]);
	}
	//PASS 1 done
	//PASS 2	
	loc = 0;
	line = 0;
	fw = fopen("pass2.txt", "w");
	rewind(fp);
	printf("\npass 2\n");
	while (1)
	{
		if (fgets(c, 50, fp) == NULL)
			break;
		if (!feof(fp))
		{
			c[strlen(c) - 1] = '\0';
			//c[strlen(c) - 1] = '\0';
		}
		strcpy(e, c);
		col = 0;
		token = strtok(c, " ");
		varflag = 0;
		while (token != NULL)
		{

			//printf("\n.%s.",c);
			//if(strcmp(token,load)==0)
			//	lc[0]=5;
			if (!strcmp(token, end))
			{
				//printf("END\n");
				break;
			}
			else if (!strcmp(token, load) || !strcmp(token, add) || !strcmp(token, store) || !strcmp(token, dc) || !strcmp(token, ds))
			{
				//opcode
				loc += 4;
				col++;
			}
			else if (!strcmp(token, using1))
			{
				//0 mem tokens
				col++;
			}
			else if (col == 0)
			{
				//variable declaration

				/*strcpy(st.sym[st.poz],token);
				st.val[st.poz]=loc;
				st.len[st.poz]=0;
				if(strcmp(token,base)==0)
				st.ra[st.poz]='a';
				else
				st.ra[st.poz]='r';
				varflag=1;
				*/
				//printf("0 %s ", token);
				col++;
				//printf("===BAKRA here: %s \n",token);

			}
			else if (col == 2)
			{
				//printf("IN %s ", token);
				for (i = 0; i<st.poz; i++)
				{
					if (!strcmp(token, st.sym[i]))
					{
						//printf("\nigzo .%s. .%s.\n",e, st.sym[i]);
						//char *strstr(const char *haystack, const char *needle)
						d = strstr(e, token);
						if (d == NULL)
							break;
						//else
						//printf("$$ %s", d);
						e[strlen(e) - strlen(d)] = '\0';
						//c[d]='\0';
						fprintf(fw, "%d %s%d (%d,%d)\n", loc, e, st.val[i], 0, begin); 	//L 1 12 (0,15)
						//printf("%d %s%d (%d,%d)\n", loc,e, st.val[i], 0, begin);
						break;
					}
				}

				col++;
			}
			//printf( "'%s',,%s\n", token,load );
			else
			{
				//printf("e %s ", token);
				col++;
			}
			token = strtok(NULL, " ");
			//col++;
			if (col>5)
				col = 0;
		}

		line++;
		if (line>10)
			break;

	}
	fclose(fw);
	fclose(fp);
	//while (1);

}