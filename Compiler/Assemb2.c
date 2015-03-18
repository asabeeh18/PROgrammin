#include<stdio.h>
#include<malloc.h>
#include<string.h>
int poz=0;
char * tokeniser(char s[50])
{
	int i;
	char subs[20];
	
	for(i=poz;i<strlen(s);i++)
	{
		printf("%c",s[4]);
		if(s[i]==' ')
		{
			break;
		}
		subs[i-poz]=s[i];		
	}
	printf("\n\n");
	if(i==strlen)
		poz=0;
	else poz=i+1;
	subs[i]='\0';
	return subs;
	
}
int main()
{
	FILE *fp;
	char c[50];
	char *token;
	int i;
	int *lc;
	//define keywords
	char load[]="L";
	char add[]="A";
	char store[]="ST";
	char dc[]="DC";
	char ds[]="DS";
	char start[5]="START";
	char end[3]="END";
	char using[5]="USING";
	char drop[4]="DROP";
	char equ[3]="EQU";
	char base[4]="BASE";
	
	
	fp = fopen("code.asm" , "r");
	if(fp == NULL)
	{
      printf("Error opening file");
      return 0;
   	}
	//read a line
	i=0;
	while(!feof(fp))
	{
		
		fgets(c,50,fp);
		//printf("%s",c);
		i++;
	}	
	printf("%d",i);
	lc=(int *)malloc(sizeof(int)*i);
	rewind(fp);

	//tokenise on space
	fgets(c,50,fp);
	fgets(c,50,fp);
	//   /n takes 2 characters ...remove it
	c[strlen(c)-1]='\0';
	c[strlen(c)-1]='\0';
	//printf("\n%d",strlen(c));
	printf("%s\n\n",c);
	token = tokeniser(c);
	
//	while( token != NULL ) 
	{
		//read take action
		printf("@%s@\n",token);
		
		token = tokeniser(c);
	}
   
	
	
}