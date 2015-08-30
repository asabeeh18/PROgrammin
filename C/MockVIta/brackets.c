#include<stdio.h>
#include<string.h>
char p[10000];
int n;
char stack[10000];
int ST=-1;
int popS()
{
	if(ST>-1)
	{
		ST++;
		return 1;
	}
	return 0;
}
void pushS()
{
	ST++;
}
int maiin(int i) //i is '<'
{
	
	i+=2;
	while(i<n && p[i]!='>')
	{
		if(p[i]=='{')
			pushS();
		else if(p[i]=='}')
		{
			if(popS()==0)
				return 0;
		}
		else if(p[i]=='P')
		{}
		else
			return 0;
		i+=2;
	}
	if(ST==-1 && p[i]=='>')
		return 1;
	return 0;
}
int main()
{
	char fl[2];
int t,i;
	scanf("%d",&t);
	while(t--)
	{
		int status=0;
		i=0;
		fgets(fl,2,stdin);
		fgets(p, 10000,stdin);
		n=strlen(p);
		printf("%s",p);
		if(p[0]=='{' && p[n-1]=='}')
		{
			while(i!=n-1)
			{
				
				i+=2;
				switch(p[i])
				{
					case '<':	status=maiin(i);
								break;
			/* 		case '(': 	userdef(i);
								break; */
					case 'P':break;
				}
				if(status==0)
				{
					printf("Compilation Errors\n");
					return 0;
				}
			}
			printf("No Compilation Errors\n");
		}
		else
		{
			printf("Compilation Errors\n");
		}
	}
	
	return 0;
}