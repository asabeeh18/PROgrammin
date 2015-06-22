//FCFS
#include<stdio.h>
#include<malloc.h>
struct node
{
    int burst,arrv,turn,wait;
	struct node *next;
};
//mode 1=Q 2=Stack
struct node *front=NULL;
struct node *rear=NULL;
int time=0;
//front=NULL;
//rear=NULL;
void display(int mode)
{
	struct node *p=front;
	int waitsum=0,turnsum=0,n=0;
	/*if(front==NULL)
	{
		printf("\nUNDERFLOW!!!\n");
		return;
	}*/
	while(p!=NULL)
	{
		printf("Arrv:%d\tBurst:%d\n\n",p->arrv,p->burst);
		waitsum+=p->wait;
		turnsum+=p->turn;
		p=p->next;
		n++;
	}
	//printf("TOTAL TIME TAKEN:%d\tAverage Turn Aroud Time:%f\tAverage Waiting Time:%f\n\n\n",time,(float)turnsum/n,(float)waitsum/n);
}
void swapNode(struct node *a,struct node *b)
{

	struct node *p=front;
	if(a!=front)
		while(p->next!=a)
			p=p->next;
	else
		front=b;
	if(b==rear)
		rear=a;
	p->next=b;
	a->next=b->next;
	b->next=a;
}
void insert(int b,int a)
{
	struct node *newrec;
	newrec=(struct node*)(malloc(sizeof(struct node)));
	newrec->burst=b;
	newrec->arrv=a;
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

void Lsort()
{
	struct node *p=front;
	struct node *j=front,*t=front,*f=front;
	while(p->next!=NULL)
	{
		//f=p->next;
		j=front;
		display(1);
		while(j->next!=NULL)
		{
//			printf("Here 3y\n");
			if(j->burst>j->next->burst)
			{
				if(p==j)
					p=j->next;
				else if(p==j->next)
					p=j->next;
				swapNode(j,j->next);
			}
		       else
			j=j->next;
			printf("swap:%d\n",j->burst);
		}
		display(1);
		printf("P0:%d\n",f->burst);
		p=p->next;
		printf("p1:%d\n",p->burst);
		
	}
}
/*				if(j==front)
				{
					front=front->next;
					j->next=front->next;
					front->next=j;
					j=j->next;
				}

void process()
{
	struct node *p=front->next;
	struct node *min=front;
	while(p->arrv==front
*/
int main()
{
	int mode,ch,f,b,a;
	printf("1. Stack\t2.Queue");
	scanf("%d",&ch);
	if(ch==1)
		mode=2;
	else
		mode=1;
	while(ch!=4)
	{
		printf("1.Insert\t3.Display\t4.Exit\n");
		scanf("%d",&ch);
		 
		switch(ch)
		{
			case 1: printf("Enter Burst time then Waiting time: ");
			scanf("%d %d",&b,&a);
			insert(b,a);
			break;
/*			case 2:	x=dele(mode,&f);
					if(f==1)
					printf("Element deled:%d\n",x);
				break;
	*/		case 3:Lsort();
				display(mode);
				break;
			case 4: break;
			default: printf("\nTRY AGAIN!! \n");
		}
	}
	return 0;
}
