#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		char s[200];
		int i,j,n,k=0,cost[100];
		scanf("%d",&n);
		for(;n>0;n--)
		{
			scanf("%s",s);
			cost[k]=0;
			i=0;
			while(i<strlen(s))
			{
				if(s[i]=='@');
				else
				{
					for(j=i+1;j<strlen(s);j++)
						if(s[i]==s[j])
						{
							cost[k]++;
							s[j]='@';
							break;
						 }
					if(s[j]!='@')
						cost[k]++;
				}		 
				i++;
			}
			k++;
		}
		for(i=0;i<k;i++)
			printf("%d\n",cost[i]);
		return 0;
}