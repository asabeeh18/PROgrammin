#include<stdio.h>
#include<conio.h>
struct Cqueue
{
int front,rear;
int a[5];
};	
struct Cqueue q;
void destroy()
{
	q.front=-1;
	q.rear=-1;
}
void insert(int x)
{ 
	q.rear=(q.rear+1)%5;
	q.a[q.rear]=x;
	if(q.front==-1)
		q.front=0;
}
int isempty()
{
	if(q.rear==-1)
		return 1;
	else	return 0;	
}	
int delete()
{
	int x;
	if(isempty())
		return -1;
	else
	{
		x=q.a[q.front];
		if(q.front==q.rear)
			destroy();
		else
			q.front=(q.front+1)%5;	
		return x;
	}
}
void display()
{
	int i=q.front;
	if(isempty())
		printf("QUEUE EMPTY!!");
	else
	{
		do
		{
			printf("%d\t",q.a[i]);
			i=(i+1)%5;
		}while(i!=(q.rear+1)%5);
	}
	printf("\n");
}
void main()
{
	int ch,x;
	clrscr();
	destroy();
	do{
		printf("\n\n\nENTERYoUR CHOICE\n1.Insert \n2.Delete \n3.Display \n4.Destroy \n5.Exit");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:if((q.rear+1)%5==q.front)
					{
						printf("STACK OVERFLOW");
						break;
					}	
					printf("\nEnter the number to insert");
					printf("\nDont ENTER -1\t");
					scanf("%d",&x);
					insert(x);
					break;
			case 2:	if((x=delete())==-1)
						printf("QUEUE ALREADY EMPTY\n");
					else
						printf("\nDeleted Element is: %d\n",x);
					break;
			case 3:	display();
					break;
			case 4:	destroy();
					break;
			case 5:	break;
			default: printf("\nWRONG CHOICE TRY AGAIN");
		}	
	}while(ch!=5);
}	

