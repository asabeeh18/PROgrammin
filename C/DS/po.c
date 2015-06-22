#include<stdio.h>
#include<conio.h>
#define MAX 100

struct stack
{
char arr[MAX];
int top;
};

struct stack s;
char infix[MAX],postfix[MAX];
int i,j;

void initstack()
{
s.top=-1;
}

int isempty()
{
if(s.top==-1)
return 1;
return 0;
}

int isoper(char ch)
{
if((ch=='*')||(ch=='/')||(ch=='%')||(ch=='+')||(ch=='-'))
return 1;
else
return 0;
}

void push(char ch)
{
if(s.top<MAX-1)
s.arr[++s.top]=ch;
else printf("stack is full \n");
}

char pop()
{
if(isempty())
return (' ');
else
return s.arr[s.top--];
}

char stacktop()
{
if(isempty())
return(' ');
else
return s.arr[s.top];
}

int priority(char ch)
{
if((ch=='*')||(ch=='/')||(ch=='%'))
return 2;
else if((ch=='+')||(ch=='-'))
return 1;
else return 0;
}


void main()
{
char ch; int postfixindex=0;
int curroperpriority=0;
clrscr();
initstack();
printf("ENTER THE INFIX EXPRESSION \n");
gets(infix);
strcpy(postfix,"");
for(i=0;i<strlen(infix);i++)
{
if(infix[i]==' ')
continue;
if(isoper(infix[i]))
{
curroperpriority=priority(infix[i]);
while(isoper(stacktop()))
{
if(priority(stacktop())>=curroperpriority)
{
ch=pop();
postfix[postfixindex++]=ch;
}
else break;
}
push(infix[i]);
}
else if(infix[i]=='(')
push(infix[i]);
else if(infix[i]==')')
{
while((ch=pop())!='(')
if(ch!='(')
postfix[postfixindex++]=ch;
}
else
postfix[postfixindex++]=infix[i];
}
while(!(isempty()))
{
ch=pop();
if(ch!='(')
postfix[postfixindex++]=ch;
}
postfix[postfixindex]='\0';
printf("postfix expression : %s",postfix);
getch();
}
