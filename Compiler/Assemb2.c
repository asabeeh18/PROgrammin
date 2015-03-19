#include<stdio.h>
#include<malloc.h>
#include<string.h>
#define LN 20
int poz=0;
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
	
	
	for(i=poz;i<strlen(s);i++)
	{
		//printf("%c",s[i]);
		if(s[i]==' ')
		{
			break;
		}
		subs[i-poz]=s[i];		
	}
//	printf("\n\n");
	subs[i-poz]='\0';
	if(i==strlen)
		poz=0;
	else poz=i+1;
	
	
	
}
int main()
{
	FILE *fp;
	char c[50];
	char *token;
	int i;
	int *lc;
	int loc=0;
	int line=0;
	int col;
	int length;
	//define keywords
	char load[]="L\0";
	char add[]="A\0";
	char store[]="ST\0";
	char dc[]="DC\0";
	char ds[]="DS\0";
	char start[]="START\0";
	char end[]="END\0";
	char using[]="USING\0";
	char drop[]="DROP\0";
	char equ[]="EQU\0";
	char base[]="BASE\0";
	//define table strucutres
	struct Symtab st;
	
	
	fp = fopen("code.asm" , "r");
	if(fp == NULL)
	{
      printf("Error opening file");
      return 0;
   	}
	//length of file
	/*
	i=0;
	while(!feof(fp))
	{
		
		fgets(c,50,fp);
		//printf("%s",c);
		i++;
	}	
	//printf("%d",i);
	length=i;
	lc=(int *)malloc(sizeof(int)*length);
	rewind(fp);
	for(line=0;line<i;line++)
		lc[line]=0;
	//tokenise on space
//	fgets(c,50,fp);

	//   /n takes 2 characters ...remove it
	
	//printf("\n%d",strlen(c));
	//printf("%s\n\n",c);
	*/
	//define tables here
	//shifted to structures now
	
	
	st.poz=0;
	line=0;
    while(1)
	{
		if(fgets(c,50,fp)==NULL)
			break;
		c[strlen(c)-1]='\0';
		c[strlen(c)-1]='\0';
		col=0;
		token = strtok(c," ");
		while( token != NULL ) 
		{
			//if(strcmp(token,load)==0)
				//	lc[0]=5;
			if(!strcmp(token,load) || !strcmp(token,add)  || !strcmp(token,store)  || !strcmp(token,dc)  || !strcmp(token,ds) )
			{
				//opcode
				loc+=4;
				col++;
			}
			else if(!strcmp(token,using))		
			{
				//0 mem tokens
				col++;
			}
			else if(col==0)
			{
				//variable declaration
				
				strcpy(st.sym[st.poz],token);
				st.val[st.poz]=loc;
				st.len[st.poz]=1;
				if(strcmp(token,base)==0)
					st.ra[st.poz]='a';
				else	
					st.ra[st.poz]='r';
				st.poz++;
				col++;
				//printf("===BAKRA here: %s \n",token);
				
			}
			else if(col==2)
			{
				//operand column
			}
//printf( "'%s',,%s\n", token,load );

		  token = strtok(NULL," ");
		  col++;
		  if(col>5)
			  col=0;
		}
		line++;
		if(line>10)
			break;
	}
	
	printf("%d  %d\n",loc,st.poz);
	
	for(i=0;i<st.poz;i++)
	{
		printf("%s %d %d %c \n",st.sym[i],st.val[i],st.len[i],st.ra[i]);
	}
		
	
}