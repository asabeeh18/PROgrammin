#include<conio.h>
#include<stdio.h>
#include<string.h>
#include<math.h>
#define SIZE 100

struct stack
{
 char a[SIZE];
 char top;
};
struct stack s;

void push(char x)
{
 s.a[++s.top]=x;
}

char pop()
{
 return(s.a[s.top--]);
}

void main()
{
 char post[SIZE],ch;
 int result,len,i;
 char r,b,c,t;
 //clrscr();
  s.a[s.top]=-1;
  push('~');

  printf("\nenter the given postfix expression\n");
  gets(post);
  len=strlen(post);
  for(i=0;i<len;i++)
  {
   ch=post[i];

   if(ch!='*' || ch!='^' || ch!='/' || ch!='+' || ch!='-')
    push(ch);

   else
   {
    b=pop();
    c=pop();


    switch(ch)
    {
    case '*':t=c*b;
    break;

    case '^':t=pow(c,b);
    break;

    case '/':t=c/b;
    break;

    case '+':t=c+b;
    break;

    case '-':t=c-b;
    break;

    default:printf("invalid expression");

    }
    push(t);
   }
  }
r=pop();
printf("\nanswer is %d",r);
//getch();
}
