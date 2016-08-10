//Question: Write program for stack, queue, linked list, and doubly linked list.
//Queue
#include<stdio.h>
#define n 10
int a[n];
int size=0;	
void insert(int ab)
{
	if(size==n)
	{
		printf("FULL");
		return;
	}
	a[size]=ab;
	size++;
}
int delete()
{
	if(size==0)
		return -1;
	int i,t=a[0];
	for(i=0;i<size;i++)
		a[i]=a[i+1];
	size--;
	return t;
}
void display()
{
	int i;
	for(i=0;i<size;i++)
	{
		printf("%d ",a[i]);
	}
}
void main()
{
	int ch,rear=-1,front=-1;
	while(ch!=4)
	{
		printf("1. Insert\n2. Remove\n3. Display\n4. Exit\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: printf("Number: ");
					scanf("%d",&ch);
					insert(ch);
					break;
			case 2: delete();
					break;
			case 3: display();
					break;
			case 4: break;
			default: printf("Try Again!\n");
		}
	}
}
