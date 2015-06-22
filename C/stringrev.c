#include<stdio.h>
#include<string.h>
void main()
{
    char s[20],t;
	int i,n;
	printf("Enter String\n");
	scanf("%s",s);
    n=strlen(s);
	for(i=0;i<n/2;i++)  //swap d character at mirror images(1st and last so on..)
	{
		t=s[i];
		s[i]=s[n-i-1];
		s[n-i-1]=t;
	}
	printf("\n%s",s);
}	