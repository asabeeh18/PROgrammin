//Binary Search Tree
#include<stdio.h>
#include<conio.h>
struct node
{
	
void main()
{
	do{
		printf("1.Insert 2.Display 3.Exit\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: printf("Enter element to insert");
					scanf("%d",&n);
					insert(n);
					break;
			case 2: display();
					break;
			case 3:break;
			default: printf("AGAIN\n");
		}
	}while(ch!=3);
}	