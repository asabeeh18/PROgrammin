/*
Ahmed Sabeeh
2016CS16
*/
/*
Implement your own shell (like bash, ksh, sh etc. as in Linux) in C. 
*/
/*

History with up down arrow keys
first character typed cannot be changed
*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include <termios.h>
#include <stdio.h>

char hist[100][1024];
int hCount,hLen;
char esc='\033';
//=======START========

static struct termios old, new;

/* Initialize new terminal i/o settings */
void initTermios(int echo) 
{
  tcgetattr(0, &old); /* grab old terminal i/o settings */
  new = old; /* make new settings same as old settings */
  new.c_lflag &= ~ICANON; /* disable buffered i/o */
  new.c_lflag &= echo ? ECHO : ~ECHO; /* set echo mode */
  tcsetattr(0, TCSANOW, &new); /* use these new terminal i/o settings now */
}

/* Restore old terminal i/o settings */
void resetTermios(void) 
{
  tcsetattr(0, TCSANOW, &old);
}

/* Read 1 character - echo defines echo mode */
char getch_(int echo) 
{
  char ch;
  initTermios(echo);
  ch = getchar();
  resetTermios();
  return ch;
}

/* Read 1 character without echo */
char getch(void) 
{
  return getch_(0);
}

/* Read 1 character with echo */
char getche(void) 
{
  return getch_(1);
}

/* Let's test it out */
/*int main(void) {
  char c;
  printf("(getche example) please type a letter: ");
  c = getche();
  printf("\nYou typed: %c\n", c);
  printf("(getch example) please type a letter...");
  c = getch();
  printf("\nYou typed: %c\n", c);
  return 0;
} */
//=======END========
void clear()
{
	int c;
	while ((c = getchar()) != '\n' && c != EOF);

}
int isArrowKey()
{
	char d;
	 // if the first value is esc
    	getc(stdin); // skip the [

    	switch(getc(stdin)) 
    	{ // the real value
    		case 'A':
				//UP
				//printf("UP");
		        return 1;
		    case 'B':
		    	//DOWN
				return 2;
		    case 'C':
		        //right
				return 3;
		    case 'D':
		        //left
		        return 4;
     	}
     
     return 0;	
}
int escMod()
{
	int c,d;
	do
	{
//		printf("waiting-\n");
		if(c=isArrowKey())
		{

			if(c==1)
			{
				//UP
				hCount--;
				if(hCount<0)
				{
					hCount=0;
					continue;
				}
				if(hLen==0)
					return;
				else
				{
					printf("\n.%s.\n",hist[hCount]);
				}
			}
			if(c==2)
			{
				hCount++;
				if(hCount>=hLen)
				{
					hCount=hLen-1;
					continue;
				}
				if(hLen==0)
					return;
				else
				{
					printf("\n.%s.\n",hist[hCount]);
				}
			}
		}
		
	}while((d=getch())==esc);
	if(d=='\n')
	{
		return hCount;
	}
	else return -1;
}
void printHelp()
{
	printf("Help HERE\n");
}
void main()
{
	char txt[1024],buff[1024],tmp[1024];
	int i=0,c,d=0,escFlag=0;
	hLen=0;
	while(1)
	{
		i=0;

		printf("shell> ");
		if(c>0)
		{	
			if(!escFlag)
				clear();
			else
			{
				escFlag=0;
			}	
		}
		d=getch();
//		printf("GETCH IP %c\n",d);
		
		if(d==esc)
		{
//			printf(".\n");
			escFlag=1;
			strcpy(txt,hist[escMod()]);
			//continue;
			hCount=hLen-1;
		}
		
		else
		{
			printf("%c",d);
			scanf("%[^\n]s",txt);
//			printf("\n%s\n",txt);
//			strcat();
//			printf("\n%c%s\n",d,txt);
			sprintf(tmp,"%c%s",d,txt);
			strcpy(txt,tmp);
//			printf("\nExec: %s\n",txt);
			c++;
			
			//history

			strcpy(hist[hLen],txt);
			hLen++;
			hCount=hLen;
		}

		//printf("\n%s\n",&txt[3]);
		
		if(strcmp("exit",txt)==0)
		{
			return;
		}
		while(txt[i]!=' ' && i<strlen(txt))
		{
			//printf("\nSgegv\n");
			buff[i]=txt[i];
			i++;

		}
		buff[i]='\0';

		
		
		//d++;
		//printf("I/P count: %d \n",d);
		if(!fork())
		{
			if(strcmp("cd",buff)==0)
			{
				//printf("\nCan't %s\n",&txt[3]);			

//				execl("/bin/sh", "-c", "cd", (const char *)0);
			}
			
			else
			{

				system(txt);
			}
			exit(0);
			//printf("%d\n",execv("ls",1));
		}
		else
		{
			if(strcmp("cd",buff)==0)
			{
				//printf("\nCan't %s\n",&txt[3]);			
				chdir(&txt[3]);
//				execl("/bin/sh", "-c", "cd", (const char *)0);
			}
			
			
			wait();
			//fflush(stdin);

		}
	}
}