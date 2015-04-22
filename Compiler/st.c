#include<stdio.h>
#include<malloc.h>
#include<string.h>
#define LN 20
int poz = 0;
char subs[20];
struct Symtab
{
	char sym[LN][LN];
	int val[LN],len[LN];
	char ra[LN],poz;
};
int main()
{
	FILE *fp;
	char c[50],e[50],*token;
	int i,*lc,loc = 0,line = 0, col,length,varflag,begin = 0;
	char *d;
	//define keywords
	char end[] = "END\0",using1[] = "USING\0",base[] = "BASE\0",load[] = "L\0",add[] = "A\0",store[] = "ST\0",dc[] = "DC\0",ds[] = "DS\0",start[] = "START\0";
	struct Symtab st;

	fp = fopen("code.asm", "r");
	if (fp == NULL)
	{
		printf("Error opening file");
		return 0;
	}

	st.poz = 0;
	line = 0;
	while (1)
	{
		if (fgets(c, 50, fp) == NULL)
			break;
		if (!feof(fp))
			c[strlen(c) - 1] = '\0';
		col = 0;
		token = strtok(c, " ");
		varflag = 0;
		while (token != NULL)
		{
			if (!strcmp(token, end))
				break;
			else if (!strcmp(token, load) || !strcmp(token, add) || !strcmp(token, store) || !strcmp(token, dc) || !strcmp(token, ds))
			{
				loc += 4;
				col++;
			}
			else if (!strcmp(token, using1))
			{
				token = strtok(NULL, " ");
				token = strtok(NULL, " ");
				//printf("base %s ", token);
				begin = atoi(token);
				//printf("begin:%d\n", begin);
				col++;
			}
			else if (col == 0)	
			{
				strcpy(st.sym[st.poz], token);
				st.val[st.poz] = loc;
				st.len[st.poz] = 0;
				if (strcmp(token, base) == 0)
					st.ra[st.poz] = 'a';
				else
					st.ra[st.poz] = 'r';
				varflag = 1;
				col++;
			}
			else if (col == 2)	//size or operand column
			{
				if (!strcmp("F", token))
				{
					st.len[st.poz] = 4;
				}
				else if (!strcmp("H", token))
				{
					st.len[st.poz] = 2;
				}
				col++;
			}
			
			token = strtok(NULL, " ");
			if (col>5)
				col = 0;
		}
		if (varflag == 1)
			st.poz++;
		line++;
		if (line>10)
			break;
	}

	printf("Symbol Value Length Relative/Absolute \n");
	for (i = 0; i<st.poz; i++)
		printf("%5s    %2d    %3d    %2c \n", st.sym[i], st.val[i], st.len[i], st.ra[i]);
}