//Linked List
#include<stdio.h>
#include<stdio.h>
#include<alloc.h>
struct node
{
	int d;
	struct node *next;
};
struct node *newrec,*first,*last,*p;
struct node* search(int n)
{
	p=first;
	while(p!=NULL && p->d!=n)
		p=p->next;
	return p;
}
void insert(int n)
{
	int ch;
       newrec=(struct node*)malloc(sizeof(struct node*));
	newrec->next=NULL;
	newrec->d=n;
	if(first==NULL)
	{
		first=newrec;
		last->next=newrec;
		last=newrec;
	}
	else
	{
		printf("Where to insert 1.Beg @.End 3.between");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: newrec->next=first;
					first=newrec;
					break;
			case 2: last->next=newrec;
					last=newrec;
					break;
			case 3: printf("Entr the elemtn after which 2 insert\n");
					scanf("%d",&n);
					p=search(n);
					newrec->next=p->next;
					p->next=newrec;
					break;
			default:    ;
		}
	}
}
int delete()
{
	int ch;;
	if(first==NULL)
		printf("Empty LL");
	else
	{
		printf("\ndelete from 1. beg 2.end 3.after an elemt\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: ch=first->d;
					p=first;
					first=first->next;
					free(p);
					break;
			case 2: p=first;
					ch=last->d;
					while(p->next->next!=NULL)
						p=p->next;
					last=p;
					last->next=NULL;
					free(p->next);
					break;
			case 3: printf("\nEnter Element to search for\n");
					scanf("%d",&ch);
					p=search(ch);
					p->next=p->next->next;
					free(p->next);
					break;
			default:                        ;
		}
	}
	return ch;
}
void display()
{
	p=first;
	do
	{
		printf("%d ",p->d);
		p=p->next;
	}while(p!=NULL);
}
void main()
{
	int n,x,ch;
	clrscr();
	do{
		printf("\n1.Insert 2.Remove 3.Disply 4.Destroy 5.Exit\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: printf("\nEnter the element to insert: ");
					scanf("%d",&n);
					insert(n);
					break;
			case 2: n=delete();
					printf("Entered Element is: %d ",n);
					break;
			case 3: display();
					break;
			//case 4: destroy();
				//	break;
			case 5: break;
			default:printf("\nTRY AGAIN!!\n");
		}
	}while(ch!=5) ;
}
