//Polynomial Addition
#include<stdio.h>
#include<conio.h>
struct node
{
	int n,p;
	struct node *next;
};
struct node *newrec,*no1,*no2;
struct LL
{
	struct node *first,*last;
};
void insertElement(int x,int pw,struct LL *l)
{
	newrec=(struct node*)malloc(sizeof(struct node));
	newrec->n=x;
	newrec->p=pw;
	newrec->next=NULL;
	if(l->first==NULL)
		l->first=newrec;
	l->last->next=newrec;
	l->last=newrec;
}
void display(struct LL *l)
{
	struct node *t=l->first;
	while(t!=NULL)
	{
		printf("%dx%d  ",t->n,t->p);
		t=t->next;
	}
}
void main()
{
	struct LL l1,l2,l3;
	int i,n1,n2,x,pw;
	l1.first=NULL;
	l2.first=NULL;
	l3.first=NULL;
	clrscr();
	printf("\nEnter no. of nodes");
	scanf("%d",&n1);
	for(i=0;i<n1;i++)
	{
		printf("\nPower: ");
		scanf("%d",&pw);
		printf("Base: ");
		scanf("%d",&x);
		insertElement(x,pw,&l1);
	}
	printf("\nEnter no. of nodes");
	scanf("%d",&n2);
	for(i=0;i<n2;i++)
	{
		printf("\nPower: ");
		scanf("%d",&pw);
		printf("Base: ");
		scanf("%d",&x);
		insertElement(x,pw,&l2);
	}
	no1=l1.first;
	no2=l2.first;
	while(no1!=NULL && no2!=NULL)
	{
		if(no1->p==no2->p)
		{
			insertElement(no1->n+no2->n,no1->p,&l3);
			no1=no1->next;
			no2=no2->next;
		}	
		else if(no1->p>no2->p)
		{
			insertElement(no2->n,no2->p,&l3);
			no2=no2->next;
		}	
		else
		{
			insertElement(no1->n,no1->p,&l3);
			no1=no1->next;
		}
	}
	if(no1==NULL)
	{
		while(no2!=NULL)
		{
			insertElement(no2->n,no2->p,&l3);
			no2=no2->next;
		}	
	}
	else if(no1==NULL)
	{
		while(no1!=NULL)
		{
			insertElement(no1->n,no1->p,&l3);
			no1=no1->next;
		}	
	}
	else{}
	printf("\n");
	display(&l1);
	printf("\n");
	display(&l2);
	printf("\n");
	display(&l3);
	getch();
}	