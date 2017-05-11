
#include<stdio.h>
#include<conio.h>
#define n 10

struct st
{
	int stack[n];
	int topa,topb;											//topa and topb are the tops of stack a and b respectively
};
struct st s;

void inserta(int x)
{
		if(s.topa==s.topb-1)								//when both tops are one after the other stack will overflow
			printf("stack overflow\n");
		else
		{
			s.topa++;
			s.stack[s.topa]=x;
			printf("value added successfully\n");
		}
}

void dela()
{
	if(s.topa==-1)
		printf("stack underflow\n");
	else
	{
		printf("value deleted is %d",s.stack[s.topa]);
		s.topa--;
	}
}

void destroya()
{
	s.topa=-1;
}

void displaya()
{
	int i;
	if(s.topa==-1)
		printf("stack underflow\n");
	else
	{
		for(i=0;i<=s.topa;i++)
			printf("%d\t",s.stack[i]);
	}
}

void insertb(int y)
{
		if(s.topa==s.topb-1)
			printf("stack overflow\n");
		else
		{
			s.topb--;										//top b goes on decrementing as we go on adding values
			s.stack[s.topb]=y;
			printf("value added successfully\n");
		}
}

void delb()
{
	if(s.topb==n)
		printf("stack underflow\n");
	else
	{
		printf("value deleted is %d",s.stack[s.topb]);
		s.topb++;
	}
}

void destroyb()
{
	s.topb=n-1;//s.topb=n;
}

void displayb()
{
	int i;
	if(s.topb==n)
		printf("stack underflow\n");
	else
	{
		for(i=n-1;i>=s.topb;i--)
			printf("%d\t",s.stack[i]);
	}
}

void main()
{
	int option,x,y;
	char choice;
	clrscr();
	s.topa=-1;												// stack a starts from left extreme of array while 
	s.topb=n;											  // stack b starts from right extreme of the same array 													
	do
	{
		printf("\nMENU\n");
		printf("1. insert at a\n");
		printf("2. delete at a\n");
		printf("3. display a\n");
		printf("4. destroy a\n");
		printf("5. insert at b\n");
		printf("6. delete at b\n");
		printf("7. display b\n");
		printf("8. destroy b\n");
		printf("select an option\n");
		scanf("%d",&option);
		switch(option)
		{
			case 1: printf("enter the value to be added\n");
					scanf("%d",&x);
					inserta(x);
					break;

			case 2: dela();
					break;

			case 3: displaya();
					break;

			case 4: destroya();
					break;

			case 5: printf("enter the value to be added\n");
					scanf("%d",&y);
					insertb(y);
					break;

			case 6: delb();
					break;

			case 7: displayb();
					break;

			case 8: destroyb();
					break;

			default: printf("invalid option\n");
		}
		printf("press y to continue\n");
		choice=getch();
	}
	while(choice=='y' || choice=='Y');
}
