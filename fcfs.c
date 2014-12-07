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
	if(newrec->arrv>time)
	{
		time=newrec->arrv;
		newrec->wait=0;
	}
	else
		newrec->wait=time-newrec->arrv;
	newrec->turn=newrec->wait+newrec->burst;
	time=time+newrec->burst;
}
void display()
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
	printf("TOTAL TIME TAKEN:%d\tAverage Turn Aroud Time:%f\tAverage Waiting Time:%f\n\n\n",time,(float)turnsum/n,(float)waitsum/n);
}
int main()
{
	int ch,f,b,a;
	while(ch!=3)
	{
		printf("1.Insert\t2.Process and Display\t3.Exit\n");
		scanf("%d",&ch);
		 
		switch(ch)
		{
			case 1: printf("Enter Burst time then Arrival time: ");
			scanf("%d %d",&b,&a);
			insert(b,a);
			break;
			case 2:display();
				break;
			case 3: break;
			default: printf("\nTRY AGAIN!! \n");
		}
	}
	return 0;
}
