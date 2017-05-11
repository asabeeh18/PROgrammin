#include<stdio.h>
#include<string.h>
int main()
{
		int t,i,j,c;
		char s[10000];
		char s1[10000];
		char temp[10000];
		scanf("%d",&t);
		while(t--!=0)
		{
			scanf("%s",s);
			scanf("%s",s1);
			if(strlen(s1)<strlen(s))
			{
				temp=s1;
				s1=s;
				s=temp;
			}	
			c=0;
			for(i=0;i<strlen(s);i++)
				for(j=0;j<strlen(s1);j++)
					if(s1[j]!='@' && s[i]==s1[j])
					{
						s1[j]='@';
						c++;
						break;
					}	
			printf("%d\n",c);
		}
		return 0;
}
	