/*
Ahmed Sabeeh
2016CS16
Question: Write program for stack, queue, linked list, and doubly linked list.

Singly Linked List
*/

#include<stdio.h>
#include<malloc.h>

struct List *front=NULL;

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
    e=scanf("%d",&a);
    if(e!=1)
	{
		printf("Invalid Input! Try Again!!\n");
		getchar() != '\n';
		//printf("\n%d\n",ch);
		searcher();
		return;
	}
    if(i->a==front->a)
        return i;
    while(i->next!=NULL && i->next->a!=a)
    {
        i=i->next;
    }
    if(i->a==a)
          return i;
    return NULL;

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
    e=scanf("%d",&ch);
    if(e!=1)
	{
		printf("Invalid Input! Try Again!!\n");
		getchar() != '\n';
		//printf("\n%d\n",ch);
		insert(n);
		return;
	}
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
    	pos=front;
    	while(pos->next!=NULL)
    		pos=pos->next;
        pos->next=newNode;
        newNode->next=NULL;
    }
    else
        return 0;
     
    //Init or First time insertion   
    if(front == NULL)
    {
        front=newNode;       
    }
    
    return 1;
}
void delete()
{
    int ch,e;
    struct List *pos;
    
    //Ask user position
    printf("Delete \n1.Front\n2.End\n3.Specific Element\n");
    e=scanf("%d",&ch);
    if(e!=1)
	{
		printf("Invalid Input! Try Again!!\n");
		getchar() != '\n';
		//printf("\n%d\n",ch);
		ch=5;
		delete();
		return;
	}
    if(ch==3)
    {
    	//search for the element and insert
        pos=searcher();
        if(pos==NULL)
            return;
        pos->next=pos->next->next;
    }
    else if(ch==1)
    {
    	//insert element at front
        pos=front->next;
        front->next==NULL;
        front=pos;
    }
    else if(ch==2)
    {
    	//insert element at end
        pos=front;
        while(pos->next!=NULL)
            pos=pos->next;
    }
    else
    {
    	printf("Invalid Input! Try Again!!\n");
    	delete();
        return ;
    }
}

void display()
{
    struct List *i=front;
    if(i==NULL)
    {
    	printf("No element in Linked List");
    }
    while(i!=NULL)
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
    int ch=0,status,e;
    
    while(ch!=4)
    {
        printf("1. Insert\n2. Delete\n3. Display\n4. Exit\n");
        e=scanf("%d",&ch);
        if(e!=1)
		{
			getchar() != '\n';
			//printf("\n%d\n",ch);
			ch=5;
		}
        switch(ch)
        {
            case 1: printf("Enter the number : ");
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
            case 2: delete();
                    break;
            case 3: display();
                    break;
            case 4: break;
            default: printf("Wrong Choice! Try Again!\n");
                            
        }
    }
}
