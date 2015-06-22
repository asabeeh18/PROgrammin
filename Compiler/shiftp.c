#include<stdio.h>
#include<string.h>

struct stru1
{
	char non_ter[1],pro[25];
}cfg[25];
int n,st=-1,j,i,t=-1,m;
int v,c,p=1;
char str[20],stack[20],ch,tmp[10];
void match(int k);
void matchl(int k);
int main()
{
	//clrscr();
	printf("Enter the number of productions:\n\r");
	scanf("%d",&n);
	printf("\n\r");
	printf("Enter the productions on LEFT and RIGHT sides:\n\r");
	
	for(i=0;i<n;i++)
	{
		scanf("%s",cfg[i].non_ter);
		printf("\n\r");
		printf("->\n\r");
		scanf("%s",cfg[i].pro);
		printf("\n\r");
	}
	printf("Enter the input string:\n\r");
	scanf("%s",str);
	printf("\n\r");
	i=0;
	do
	{
		ch=str[i];
		stack[++st]=ch;
		tmp[0]=ch;
		match();
		i++;
	}while(str[i]!='\0');
	c=st;
	v=st;
	puts(stack);
	printf("\n\r");
	while(st!=0)
	{
		v=--st;
		t=-1;
		p=0;
		while(v<=c)
		{
			tmp[++t]=stack[v++];
			p++;
		}
		matchl(p);
	}
	cfg[0].non_ter[1]='\0';
	if(strcmp(stack,cfg[0].non_ter)==0)
		printf("String is present in Grammar G\n\r");
	else
		printf("String is not present in Grammar G\n\r");

	return 0;
}


//replace terminals in ip with Variables
void match()
{
	for(j=0;j<n;j++)
	{
		if(strlen(cfg[j].pro)==1)
		{
			if(strcmp(tmp,cfg[j].pro)==0)
			{
				stack[st]=cfg[j].non_ter[0];
				break;
			}
		}
	}
}

//match the converted ip string  with variables
void matchl(int k)
{
	int x=1,y;
	y=k-1;
	for(j=0;j<n;j++)
	{
		if(strlen(cfg[j].pro)==k)
		{
			if(strcmp(tmp,cfg[j].pro)==0)
			{
				k=c-k+1;
				stack[k]=cfg[j].non_ter[0];
				do
				{
					stack[k+x]='\0';
					tmp[t--]='\0';
					c--;
					x++;
				}while(x<=y);
				tmp[t]='\0';
				puts(stack);
				printf("\n\r");
				break;
			}
		}
	}
}
