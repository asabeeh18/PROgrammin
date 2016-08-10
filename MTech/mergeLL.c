/*
	Question: Write program for stack, queue, linked list, and doubly linked list.
	Singly Linked List
*/

#include<stdio.h>
#include<malloc.h>
#include<string.h>
struct List *newNode;
struct List
{
    char *a;
    struct List *next;
};

void display(struct List *front)
{
    struct List *i=front;
    while(i!=NULL)
    {
        printf("%s ",i->a);
        i=i->next;
	}
    printf("\n");
}

int count(struct List *front)
{
	int n=0;
	struct List *i=front;
	while(i!=NULL)
	{
		i=i->next;
		n++;
	}
	return n;
}
//remember to kill Shreya

void main()
{
	struct List *i;
	struct List *front1=NULL,*front2=NULL,*front;	
	int ch=0,status,j,n;       
	char s[100];
	
	printf("Number of elements in 1st Linked List\n");
	scanf("%d",&n);
	
	printf("Enter the strings for 1st Linked List\n");
	for(j=0;j<n;j++)
	{
		i=front1;
		scanf("%s",s);
		newNode=(struct List*)malloc(sizeof(struct List));
		newNode->a=(char*)malloc(strlen(s)*sizeof(char)+1);
		strcpy(newNode->a,s);
		newNode->next=NULL;
		if(front1==NULL)
			front1=newNode;
		else
		{
			while(i->next!=NULL)
			{
				i=i->next;
			}
			i->next=newNode;
		}
	}
	
	printf("Number of elements in 2nd Linked List\n");
	scanf("%d",&n);
	printf("Enter the strings for 2nd Linked List\n");
	
	for(j=0;j<n;j++)
	{
		i=front2;
		scanf("%s",s);
		newNode=(struct List*)malloc(sizeof(struct List));
		newNode->a=(char*)malloc(strlen(s)*sizeof(char)+1);
		strcpy(newNode->a,s);
		newNode->next=NULL;
		if(front2==NULL)
			front2=newNode;
		else
		{
			while(i->next!=NULL)
			{
				i=i->next;
			}
			i->next=newNode;
		}
	}
	
	if(count(front1)>count(front2))
	{
		i=front1;
		while(i->next!=NULL)
		{
			i=i->next;
		}
		i->next=front2;
		front=front1;
	}
	else
	{
		i=front2;
		while(i->next!=NULL)
		{
			i=i->next;
		}
		i->next=front1;
		front=front2;		
	}
	printf("Merged List\n");
	display(front);
}