	/*
Question: Write program for stack, queue, linked list, and doubly linked list.
Queue using array
*/
#include<stdio.h>
#define N 10

int rear=-1,front=-1;

int insert(int *a,int n)
{
    if(rear>=N-1)
        return 0;
    if(front==-1)
        front++;
    rear++;
    a[rear]=n;
    return 1;
}

int delete(int *a)
{
    int n,i;
    n=a[front];
    for(i=0;i<rear;i++)
        a[i]=a[i+1];
    rear--;
    return n;
}

void display(int *a)
{
    int i=0;
    for(i=0;i<=rear;i++)
    {
        printf("%d ",a[i]);
    }
        printf("\n");    
}

void main()
{
    int a[N],ch=0,status;       
    while(ch!=4)
    {
        printf("1. Insert\n2. Delete\n3. Display\n4. Exit\n");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1: printf("Enter: ");
                    scanf("%d",&ch);
                    status=insert(a,ch);
                    if(status!=1)
                    {
                        printf("Queue overflow!\n");
                    }
                    ch=0;
                    break;
            case 2: if(rear==-1)
                    {
                        printf("Queue underflow!\n");
                    }
                    else
                    {
                        ch=delete(a);
                        printf("Removed Element: %d\n",ch);
                        ch=0;
                    }
                    
                    break;
            case 3: display(a);
                    break;
            case 4: break;
            default: printf("Try Again!");
                            
        }
    }
}

/*
Question: Write program for stack, queue, linked list, and doubly linked list.
Stack using array
*/

#include<stdio.h>
#define N 10
int top=-1;

int push(int *a,int n)
{
    if(top>=N-1)
        return 0;
    top++;
    a[top]=n;
    return 1;
}

int pop(int *a)
{
    int n;
    n=a[top];
    top--;
    return n;
}

void display(int *a)
{
    int i=0;
    for(i=0;i<=top;i++)
    {
        printf("%d ",a[i]);
    }
        printf("\n");    
}

void main()
{
    int a[N],ch=0,status;       
    while(ch!=4)
    {
        printf("1. Push\n2. Pop\n3. Display\n4. Exit\n");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1: printf("Enter: ");
                    scanf("%d",&ch);
                    status=push(a,ch);
                    if(status!=1)
                    {
                        printf("Stack overflow!\n");
                    }
                    ch=0;
                    break;
            case 2: if(top==-1)
                    {
                        printf("Stack underflow!\n");
                    }
                    else
                    {
                        ch=pop(a);
                        printf("Popped Element: %d\n",ch);
                        ch=0;
                    }
                    
                    break;
            case 3: display(a);
                    break;
            case 4: break;
            default: printf("Try Again!");
                            
        }
    }
}

/*
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
    int a;
    printf("Enter Element: ");
    scanf("%d",&a);

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
    int ch;
    
    newNode=(struct List*)malloc(sizeof(struct List));
    newNode->a=n;
    newNode->next=NULL;
    newNode->prev=NULL;
    
    //Ask user position
    printf("Insert at\n1.Start\n2.End\n3.After an element\n");
    scanf("%d",&ch);
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
    scanf("%d",&ch);
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
                        ch=delete();
                        printf("Removed Element: %d\n",ch);
                        ch=0;
                    }
                    
                    break;
            case 3: display();
                    break;
            case 4: break;
            default: printf("Try Again!");
                            
        }
    }
}