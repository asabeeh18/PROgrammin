#include <stdio.h>
#include <stdlib.h>

int ctr;

typedef struct node
{
	int id, arrival, burst, turn, flag;
	struct node *next;
};

struct node *first, *last, *newNode, *current;

void addProcess()
{
	newNode=(struct node *)malloc(sizeof(struct node));
	newNode->next=NULL;
	newNode->arrival=0;
	newNode->id=++ctr;
	
	printf("\nEnter burst time: ");
	scanf("%d", &newNode->burst);
	newNode->flag=newNode->burst;
	
	if(first==NULL)
	{
		first=newNode;
		last=newNode;
	}
	else
	{
		current=first;
		
		while(current->next!=NULL)
			current=current->next;
			
		current->next=newNode;
		last=newNode;
	}
}

void roundRobin()
{
	int cpuBurst=1;
	int time=0;
	
	current=first;
	
	do
	{
		if(current->flag!=0)
		{
			current->flag--;
			time++;
			
			printf("\nID: %d   Remaining burst: %d     Elapsed time: %d", current->id, current->flag, time);
			
			last->next=current;
			first=first->next;
			last=current;
		}
		else
		{
			if(first==last)
			{
				first=NULL;
				last=NULL;
			}
			else
				first=first->next;
		}
		
		current=first;
	}
	while(current!=NULL);
	
	printf("\n");
}

void main()
{
	int opt;
	
	first=NULL;
	last=NULL;
	ctr=0;
	
	do
	{
		printf("\n1) Add process   2) Print execution plan   3) Exit");
      	printf("\nEnter option: ");
      	scanf("%d", &opt);
      
      	switch(opt)
      	{
        	case 1: addProcess();
         	 		break;
         	case 2: if(first==NULL)
         	    		printf("The queue is empty!");
         	 		else
         	    		roundRobin();
         	 		break;
         	case 3: printf("The program will terminate now");
         	 		break;
         	 
         	default: printf("Invalid option entered!!!");
		}
	}
	while(opt!=3);
}