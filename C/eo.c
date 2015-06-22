#include<stdio.h>
void main()
{
	int c;
	printf("YOfff\fee\njj",EOF,EOF);
	c=getchar();
	while(c!=EOF)
	{
		putchar(c);
		c=getchar();
	}
}