/*
Ahmed Sabeeh
2016CS16

Question: Write program for stack, queue, linked list, and doubly linked list.

Doubly Linked List
*/

#include<stdio.h>
#include<malloc.h>

struct List *front=NULL,*rear=NULL;

struct List
{
    int a;
    struct List *next;
    struct List *prev;    
};

struct List* searcher()
{
    struct List *i=front;
    int a,e;
    printf("Enter Element: ");
    e=scanf("%d",&a);
	if(e!=1)
	{
		printf("Wrong input Error!");
		return searcher();
	}
    while(i!=NULL && i->a!=a)
    {
        i=i->next;
    }

    if(i->a==a)
        return i;
    return NULL;
}

int insert(int n)
{
    //creating new node
    struct List *newNode,*pos;
    int ch,e;
    
    newNode=(struct List*)malloc(sizeof(struct List));
    newNode->a=n;
    newNode->next=NULL;
    newNode->prev=NULL;
    
    //Ask user position
    printf("Insert at\n1.Start\n2.End\n3.After an element\n");
    e=scanf("%d",&ch);
	if(e!=1)
	{
		printf("Wrong input Error!");
		return searcher();
	}

    if(ch==3)
    {
        pos=searcher();
        if(pos==NULL)
            return 0;


        newNode->next=pos->next;
        pos->next=newNode;
        newNode->next->prev=newNode;
        newNode->prev=pos;
    }
    else if(ch==1)
    {
        newNode->next=front;
        if(front==NULL)
        {
            front=newNode;
        }
        else    
        {
            front->prev=newNode;
            front=newNode;
        }
    }
    else if(ch==2)
    {
        rear->next=newNode;
        newNode->prev=rear;
        newNode->next=NULL;
        rear=newNode;
    }
    else
        return 0;
     
    //Initialisation or First time insertion   
    if(front == NULL)
    {
        front=newNode;       
    }
    
    if(rear==NULL)
        rear=newNode;

    return 1;
}
int delete()
{
    int ch;
    struct List *pos;
    
    //Ask user position
    printf("Delete \n1.Front\n2.End\n3.Specific Element\n");
    e=scanf("%d",&ch);
    if(e!=1)
	{
		printf("Wrong input Error!");
		return delete();
	}

    if(ch==3)
    {
        pos=searcher();
        if(pos==NULL)
            return 0;
        if(pos==front)
        {  
            pos=front->next;
            front->next==NULL;
            front=pos;
            front->prev=NULL;
            if(front==NULL)
                rear=NULL;
        }
        else if(pos==rear)
            rear->prev->next=NULL;        
        else
        {
            pos->prev->next=pos->next;
            pos->next->prev=pos->prev;
        }
    }
    else if(ch==1)
    {
        pos=front->next;
        front->next==NULL;
        front=pos;
        front->prev=NULL;
        if(front==NULL)
            rear=NULL;
    }
    else if(ch==2)
    {
        rear->prev->next=NULL;        
    }
    else
        return 0;
    return ch;
}

void display()
{
    struct List *i=front;
    if(i==NULL)
    {
    	printf("No element in Linked List");
    }
    while(i!=rear)
    {
        printf("%d ",i->a);
        i=i->next;
    }
    printf("%d ",i->a);
    printf("\n");
}

void main()
{
    int ch=0,status,e;
    
    while(ch!=4)
    {
        printf("Enter Choice\n1. Insert\n2. Delete\n3. Display\n4. Exit\n");
        e=scanf("%d",&ch);
        if(e!=1)
		{
			getchar() != '\n';
			ch=5;
		}
        switch(ch)
        {
            case 1: printf("Enter the number: ");
                    scanf("%d",&ch);
                    e=scanf("%d",&ch);
					if(e!=1)
					{
						printf("Invalid Input! Try Again!!\n");
						getchar() != '\n';
						//printf("\n%d\n",ch);
						ch=5;
						break;
					}
                    status=insert(ch);
                    if(status!=1)
                    {
                        printf("Unexpected Error\n");
                    }
                    ch=0;
                    break;
            case 2: if(rear==NULL)
                    {
                        printf("List is empty!\n");
                    }
                    else
                    {
                        ch=delete();
                        printf("Removed Element: %d\n",ch);
                        ch=0;
                    }
                    
                    break;
            case 3: display();
                    break;
            case 4: break;
            default: printf("Wrong Choice! Try Again!\n");
                            
        }
    }
}
