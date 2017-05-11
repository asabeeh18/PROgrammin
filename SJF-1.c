#include<stdio.h>
#include<stdlib.h>

struct Node
{
	int pid,at,bt,wt,tat,e;
	struct Node *next;
};

int time=0;




void insert(struct Node **front,struct Node **rear,int id,int a,int b)
{
	struct Node *p;
	p=(struct Node*)malloc(sizeof(struct Node));
	p->pid=id;
	p->at=a;
	p->bt=b;
	p->e=0;
	p->next=NULL;
	if(*front==NULL)
			*front=*rear=p;
	else	
	{
			(*rear)->next=p;
			(*rear)=p;
	}
}

void solve(struct Node *front,struct Node *rear)
{
	struct Node *p,*q;
	int flag,min,ck=0;

	while(ck!=1)
	{
			flag=0;
			min=32767;

			while(flag==0)
			{
				p=front;
				while(p!=NULL)
				{
					if(p->at<=time && p->e==0)
					{
						flag=1;
						if(p->bt<min)
						{
							min=p->bt;
							q=p;
						}
					}
					p=p->next;
				}

				if(flag==0)
					time++;
			}
			q->wt=time-q->at;
			time+=q->bt;
			q->tat=time-q->at;
			q->e=1;
			p=front;
			while(p!=NULL)		
			{
				if(p->e==0)
					break;
				p=p->next;
			}

			if(p==NULL)
				ck=1;
		}
}
void display(struct Node *front,struct Node *rear)
{
	solve(front,rear);
	struct Node *p;
	int count=0,twt=0,ttat=0;
	p=front;
	printf("===================================\n");
	printf("Pid	At	Bt	Wt	Tat\n");
	printf("===================================\n");
	while(p!=NULL)
		{
		printf("%d	%d	%d	%d	%d\n",p->pid,p->at,p->bt,p->wt,p->tat);
		twt+=p->wt;		
		ttat+=p->tat;	
		count++;
		p=p->next;
	}
	printf("Average Wait time=%f\n",(float)twt/count);
	printf("Average Turn Around time=%f\n",(float)ttat/count);
}

void main()
{
	struct Node *front,*rear;
	int id=0,a,b,ch=0;
	front=rear=NULL;
	printf("**MENU**\n1.)Insert\n2.)Display\n3.)Menu\n4.)Exit\n");
	while(ch!=4)
	{
		printf("Enter 3 to see MENU or enter choice:");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:	printf("Enter arrival time and burst time\n");
				scanf("%d%d",&a,&b);
				insert(&front,&rear,++id,a,b);
				break;
			case 2:	display(front,rear);
				break;
			case 3:	printf("**MENU**\n1.)Insert\n2.)Display\n3.)Menu\n4.)Exit\n");
				break;
			case 4:	printf("Thank You\n");
				break;
			default:printf("Invalid choice");
		}
	}
}
