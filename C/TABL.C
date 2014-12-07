#include<stdio.h>
#include<string.h>
int l,p;
char str[10000],c;
int d,i,m=0,t;
int looper(int i,char str[10000],char s)
{
	int j,brac=0;
//	i++;
	for(j=i+1;j<l-1;j++)
	{
		if(str[j]=='{')
			brac++;
		else if(str[j]=='}' && brac>0)
			brac--;
		
		else if(str[j]==s && brac==0)
			return j;
		else if(str[j]=='P')
			p++;
		else
			return -1;
	}

}
int solve
{
		p=0;
		scanf("%s",&str);
		l=strlen(str);
		if(str[l-1]=='}' && str[0]=='{')
		{
			for(i=1;i<l-1;i++)
			{
				switch(str[i])
				{
					case '<':   m++;
								if(m==2)
								{
//									printf("Compilation Errors");
									return 0;
								}
								else
								{
									d=looper(i,str,'>');
									if(d==-1)
									{
	//									printf("Compilation Errors");
										return 0;
									}
									else
										i=d;
								}
								break;
					case '(':
								d=looper(i,str,')');
								if(d==-1)
								{
		//							printf("Compilation Errors");
									return 0;
								}
								else
									i=d;
								break;
					case ' ': break;
					case 'P': p++;
								if(p>100)
								{
			//						printf("Compilation Errors");
									return 0;
								}
								break;
					default: //printf("Compilation Errors");
							return 0;
				}

			}
		}
		else
		{
		//	printf("Compilation Errors");
			return 0;
		}
		//printf("No Compilation Errors");
		return 1;
}
int main()
{
	int t;
	
	scanf("%d",&t);
	while(t--)
	{
		if(solve())
			printf("NO Compilation Errors");
		else
			printf("Compilation Errors");
	}
}