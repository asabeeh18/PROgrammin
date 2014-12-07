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
void copyLL()
{


/*void insert(int b,int a)
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
	if(newrec->arrv>time)
	{
		time=newrec->arrv;
		newrec->wait=0;
	}
	else
		newrec->wait=time-newrec->arrv;
	newrec->turn=newrec->wait+newrec->burst;
	time=time+newrec->burst;
}*/

void display(int mode)
{
	struct node *p=front;
	int waitsum=0,turnsum=0,n=0;
	if(front==NULL)
	{
		printf("\nUNDERFLOW!!!\n");
		return;
	}
	while(p!=NULL)
	{
		printf("Wait:%d\tTurn Aroud:%d\n\n",p->wait,p->turn);
		waitsum+=p->wait;
		turnsum+=p->turn;
		p=p->next;		
		n++;
	}
//	printf("Arrv:%d\tBurst:%d\tWait:%d\tTurn Aroud:%d\n\n",p->arrv,p->burst,p->wait,p->turn);
	//n++;
	printf("TOTAL TIME TAKEN:%d\tAverage Turn Aroud Time:%f\tAverage Waiting Time:%f\n\n\n",time,(float)turnsum/n,(float)waitsum/n);
}
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
	*/		case 3:display(mode);
				break;
			case 4: break;
			default: printf("\nTRY AGAIN!! \n");
		}
	}
	return 0;
}
