/*
Ahmed Sabeeh
2016CS16

Write  a program to merge two linked list having string. The linked list having longer lenght would be the first.
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

void main()
{
	struct List *i;
	struct List *front1=NULL,*front2=NULL,*front;	
	int ch=0,status,j,n,e;
	char s[100];
	while(ch!=4)
	{	
		printf("Enter Choice\n1. Insert in 1st Linked List\n2. Insert in 2nd Linked List\n3. Merge\n4. Exit\n");
		e=scanf("%d",&ch);
		getchar();
        if(e!=1)
		{
	//		getchar() != '\n';
			printf("Error!");
			//printf("\n%d\n",ch);
			ch=5;
			break;
		}

		switch(ch)	
		{
			case 1: 
				printf("Enter the string\n");
				i=front1;
				scanf("%[^\n]s",s);
				getchar();
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
				break;
			
			case 2:	
				printf("Enter the string\n");
				i=front2;
				scanf("%[^\n]s",s);
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
				break;
			case 3:
				if(front1==NULL && front2==NULL)
				{
					printf("Nothing to merge\n");
					break;
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
				i->next=NULL;
				break;
			case 4:break;
			default: printf("Wrong Choice!!\n");
		}
	}
}
