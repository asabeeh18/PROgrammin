#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
	char s[200];
	int i,n,cost=0;
	scanf("%d",&n);
	for(;n>0;n--)
	{
		gets(s);
		i=0;
		puts(s);
		while(s[i]!='\0')
		{
			if(s[i]=='@');
			else 
				for(j=i+1;s[j]!='\0';j++)
					if(s[i]==s[j])
					{
						cost++;
						s[j]='@';
						break;
					}
			i++;		
		}			
	}				
    return 0;
}





















