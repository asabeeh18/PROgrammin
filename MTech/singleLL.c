/*
Question: Write program for stack, queue, linked list, and doubly linked list.
Singly Linked List
*/

#include<stdio.h>
#include<malloc.h>

struct List *front=NULL,*rear=NULL;

struct List
{
    int a;
    struct List *next;
};

//Return the previous node of element to search
struct List* searcher()
{
    struct List *i=front;
    int a;
    printf("Enter Element: ");
    scanf("%d",&a);
    if(i->a==front->a)
        return i;
    while(i->next!=NULL && i->next->a!=a)
    {
        i=i->next;
    }
    if(i==rear)
    {
        if(i->a==a)
           return i;
        return NULL;
    }
    if(i->next->a==a)
        return i;
     return NULL;
}

int insert(int n)
{
    //creating new node
    struct List *newNode,*pos;
    int ch;
    
    newNode=(struct List*)malloc(sizeof(struct List));
    newNode->a=n;
    newNode->next=NULL;
    
    //Ask user position
    printf("Insert at\n1.Start\n2.End\n3.After an element\n");
    scanf("%d",&ch);
    if(ch==3)
    {
        pos=searcher();
        if(pos==NULL)
            return 0;
        //insert AT the user position
        pos=pos->next;
        newNode->next=pos->next;
        pos->next=newNode;
    }
    else if(ch==1)
    {
        newNode->next=front;
        front=newNode;
    }
    else if(ch==2)
    {
        rear->next=newNode;
        newNode->next=NULL;
        rear=newNode;
    }
    else
        return 0;
     
    //Init or First time insertion   
    if(front == NULL)
    {
        front=newNode;       
    }
    
    if(rear==NULL)
        rear=newNode;

    return 1;
}
void delete()
{
    int ch;
    struct List *pos;
    
    //Ask user position
    printf("Delete \n1.Front\n2.End\n3.Specific Element\n");
    scanf("%d",&ch);
    if(ch==3)
    {
        pos=searcher();
        if(pos==NULL)
            return;
        pos->next=pos->next->next;
    }
    else if(ch==1)
    {
        pos=front->next;
        front->next==NULL;
        front=pos;
        if(front==NULL)
            rear=NULL;
    }
    else if(ch==2)
    {
        pos=front;
        while(pos->next!=rear)
            pos=pos->next;
        rear=pos;
        if(rear==NULL)
            front=NULL;
        else
            rear->next=NULL;
        
    }
    else
        return ;
}

void display()
{
    struct List *i=front;
    while(i!=NULL && i!=rear)
    {
        printf("%d ",i->a);
        i=i->next;
    }
    if(i!=NULL)
        printf("%d ",i->a);
    printf("\n");
}

void main()
{
    int ch=0,status;       

    while(ch!=4)
    {
        printf("1. Insert\n2. Delete\n3. Display\n4. Exit\n");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1: printf("Enter the element : ");
                    scanf("%d",&ch);
                    status=insert(ch);
                    if(status!=1)
                    {
                        printf("Unexpected Error\n");
                    }
                    ch=0;
                    break;
            case 2: if(rear==NULL)
                    {
                        printf("Unexpected Error!\n");
                    }
                    else
                    {
                        delete();
                    }
                    
                    break;
            case 3: display();
                    break;
            case 4: break;
            default: printf("Try Again!");
                            
        }
    }
}