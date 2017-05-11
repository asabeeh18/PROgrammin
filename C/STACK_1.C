/* 
   The Following Program shows the simple implimetation of STACK DATA Structure in C
   Date: 24/07/2013
   Time Stamp: 6:55pm (UTC +5:30)
   
*/
#include<conio.h>
#include<stdio.h>
#define SIZE 5
struct stack
{
	int a[SIZE];
	int top;
};
int isempty(struct stack s)
{
	if(s.top==-1)
	return 1;
	else
	return 0;
     }
void push(int x,struct stack s)
{
	if (s.top==SIZE-1)
	printf("\nStack OverFlow\n");
	else
	{
	s.top++;
	s.a[s.top]=x;
	}
	}
void pop(struct stack s)
{
	if(isempty(s))
	{
	printf("\nStack UnderFlow\n");
	}
	else
	printf("Poped Element: %d \n",s.a[s.top]);
	s.top--;
	  }
void display(struct stack s)
{
 int i;
 for(i=0;i<=SIZE-1;i++)
 {
 printf("%d   \t",s.a[i]);
    }
}
void dest(struct stack s)
{
 s.top=-1;

}
int main()
{
struct stack s;
int num,ch;
s.top=-1;
do{
printf("\n************Enter Your Choise************ \n 1:Push \n 2: Pop \n 3:Display \n 4: Destroy\n 5: Exit \n");
scanf("%d",&ch);

switch(ch)
{
case 1: printf("\nEnter an intger\n");
	scanf("%d",&num);
	push(num,s);
	break;
case 2: pop(s);
	break;
case 3: display(s);
	break;
case 4: dest(s);
	break;
default: printf("\nInvalid Choise");
	}
       }
while(ch!=5);
{
	printf("\nThank You");
	getch();
    }
}



