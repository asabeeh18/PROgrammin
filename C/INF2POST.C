//infix to postfix
#include<stdio.h>
#include<conio.h>
#include<string.h>
#define M 10
struct stack
{
	char a[M];
	int top;
};
struct stack s;
void push(char c)
{
	s.a[++s.top]=c;
}
char pop()
{
	return s.a[s.top--];
}
int priority(char c)
{
	if(c=='*' || c=='/')
		return 3;
	if(c=='+' || '-')
		return 2;
	return 1;
}
char stacktop()
{
	return s.a[s.top];
}
void main()
{
	char a[M],post[M],k=0;
	int i;
	s.top=-1;
	push('~');
	printf("Enter the string\n");
	gets(a);
	for(i=0;i<strlen(a);i++)
	{
		switch(a[i])
		{
			case '+':
			case '-':
			case '*':
			case '/': if(priority(a[i])>priority(stacktop()))
						push(a[i]);
					else
					{
						while(priority(a[i])>priority(stacktop()))
							post[k++]=pop();
						push(a[i]);
					}
					break;
			case '(': push(a[i]);
						break;
			case ')': while(stacktop()!='(')
						post[k++]=pop();
						pop();
						break;
			default: post[k++]=a[i];
		}
	}
	while(stacktop()!='~')
		post[k++]=pop();
	post[k++]='\0';
	puts(post);
	getch();
}
