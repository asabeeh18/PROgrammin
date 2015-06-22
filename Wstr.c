#include<stdio.h>
#include<malloc.h>
#include<string.h>
int cnt[10000][26];
int maxx(int i)
{
	int m=0,j;
	for(j=0;j<26;j++)
		m=m>cnt[i][j]?m:cnt[i][j];
	return m;
}

int main()
{
	int t,i,j,k,m;
	int mem=64;
	char *str=malloc(mem);
	int test;
	scanf("%d",&test);
	while(test--)
	{
		k=-1;
		//fflush(stin);
		//fgets(str,mem,stdin);
		scanf("%s",str);
		fflush(stdin);
	/*	while(str[strlen(str)-1]!='\n')
		{//checks if we ran out of space
			mem*=2;
			str=realloc(str,mem);//double the amount of space
			fgets(str+mem/2-1,mem/2+1,stdin);//read the rest (hopefully) of the line into the new space.
		}
		*/for(i=0;i<strlen(str);i++)
		{
			for(j=0;j<26;j++)
				cnt[i][j]=0;
		}
		for(j=0;j<strlen(str);j++)
		{
			if(j>0)
				while(str[j]!='#')
					j++;
			k++;
			m=j+1;
			for(i=0;i<26;i++)
				while(str[m]!='#' && m<strlen(str))
				{
					cnt[k][(int)str[i]]++;
					m++;
				}
		}
		m=0;
		for(i=0;i<k-4;i++)
			m=m>(j=maxx(i)+maxx(i+1)+maxx(i+2)+maxx(i+3))?m:j;
		printf("\n%d",m);
	}
		
			
			
}
	