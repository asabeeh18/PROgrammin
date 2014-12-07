#include<stdio.h>
#include<malloc.h>
struct node
{
    int a;
	struct node *next;
};
//mode 1=Q 2=Stack
struct node *front=NULL;
struct node *rear=NULL;
//front=NULL;
//rear=NULL;
void insert(int x)
{
	struct node *newrec;
	newrec=(struct node*)(malloc(sizeof(struct node)));
	newrec->a=x;
	newrec->next=NULL;
	if(front==NULL)
	{
		front=newrec;
		rear=newrec;
	}
	else
	{
		rear->next=newrec;
		rear=newrec;
	}
}
int dele(int mode,int *f)
{
	struct node *p;
	int x;
	*f=1;
	if(front==NULL)
	{
		printf("UnderFLOW Error!!/n");
		*f=0;
		return 0;
	}
	if(mode==1)
	{
		p=front;
		x=p->a;
		front=p->next;
		if(front==NULL) //last removal
			rear=NULL;
		free(p);
		return x;
	}
	else if(mode==2)
	{
		if(front!=rear)
		{
			p=front;
			while(p->next!=rear)
				p=p->next;
			x=rear->a;
			p->next=NULL;
			free(rear);
			rear=p;
			return x;
		}
		else //last removal
		{
			x=front->a;
			front=NULL;
			rear=NULL;
			return x;
		}
	}
}
void display(int mode)
{
	struct node *p=front;
	while(p->next!=NULL)
	{
		printf("%d-",p->a);
		p=p->next;
	}
	printf("%d-",p->a);	
}
int main()
{
	int mode,ch,f,x;
	printf("1. Stack\t2.Queue");
	scanf("%d",&ch);
	if(ch==1)
		mode=2;
	else
		mode=1;
	while(ch!=4)
	{
		printf("1.Insert\t2.dele\t3.Display\t4.Exit\n");
		scanf("%d",&ch);
		 
		switch(ch)
		{
			case 1: printf("Enter number ");
			scanf("%d",&x);
			insert(x);
			break;
			case 2: 	printf("Here 107\n");
					x=dele(mode,&f);
					if(f==1)
					printf("Element deled:%d\n",x);
				break;
			case 3:display(mode);
				break;
			case 4: break;
			default: printf("\nTRY AGAIN!! \n");
		}
	}
	return 0;
}
