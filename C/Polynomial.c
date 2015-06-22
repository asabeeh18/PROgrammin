#include<stdio.h>
#include<conio.h>
struct Node
{
	int a,pw;
	struct Node *next;
};
struct LL
{
	struct Node *first,*last;
};	
struct Node *newrec,*p,*q;	
void insertEl(int x,int p,struct LL *l)
{
	newrec=(struct Node*)malloc(sizeof(struct Node));
	newrec->next=NULL;
	newrec->a=x;
	newrec->pw=p;
	if(l->first==NULL)
	{
		l->first=newrec;
		l->last=newrec;
	}
	else
	{
		l->last->next=newrec;
		l->last=newrec;
	}
}	
void add(struct LL *l1,struct LL *l2,struct LL *l3)
{
	p=l1->first;
	q=l2->first;
	while(p!=NULL && q!=NULL)
	{
		if(p->pw==q->pw)
		{
			insertEl(p->a+q->a,p->pw,l3);
			p=p->next;
			q=q->next;
		}
		else if(p->pw>q->pw)
		{
			insertEl(q->a,q->pw,l3);
			q=q->next;
		}	
		else
		{
			insertEl(p->a,p->pw,l3);
			p=p->next;
		}	
	}
	if(p==NULL)
	{
		while(q!=NULL)
		{
			insertEl(q->a,q->pw,l3);
			q=q->next;
		}
	}
	else if(q==NULL)
	{
		while(p!=NULL)
		{
			insertEl(p->a,p->pw,l3);
			p=p->next;
		}
	}
	else{}
}
void display(struct LL *l)
{
	p=l->first;
	while(p!=NULL)
	{
		printf("%d x %d   ",p->a,p->pw);
		p=p->next;
	}
}
void main()
{
	struct Node LL l1,l2,l3;
	l1.first=NULL;
	l1.last=NULL;
	l2.first=NULL;
	l2.last=NULL;
	l3.first=NULL;
	l3.last=NULL;
	printf("Enter No. of Nodes for 1st Polynomial ");
	scanf("%d",&n1);
	printf("Enter No. of Nodes for 2nd Polynomial ");
	scanf("%d",&n2);
	for(i=0;i<n1;i++)
	{
		printf("\nCoefficient: ");
		scanf("%d",&x);
		printf("Power: ");
		scanf("%d",&p);
		insertEl(x,p,&l1);
		disply(&l1);
		printf("===\n");
	}
	disply(&l1);
	for(i=0;i<n2;i++)
	{
		printf("\nCoefficient: ");
		scanf("%d",&x);
		printf("Power: ");
		scanf("%d",&p);
		insertEl(x,p,&l2);
	}
	add(&l1,&l2,&l3);
	disply(&l1);
	disply(&l2);
	disply(&l3);
}	
	