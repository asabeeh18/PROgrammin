//SINGLY LINKED LIST	
struct node
{
	int n;
	struct node *next;
};
struct node *first,*last,*newrec;
void add(int x)
{
	newrec=(struct node*)malloc(sizeof(struct node));
	newrec->n=x;
	newrec->next=NULL;
	if(first==NULL)
	{
		first=newrec;
		last=newrec;
	}
	else
	{
		last->next=newrec;
		last=newrec;
	}
}
void delete(int x)
{
	struct node *q,*p=first;
	while(p!=NULL && p->n!=x)	
	{
		q=p;
		p=p->next;
	}	
	if(p==NULL)
		printf("\nNOT FOUND");
	else
	{
		q->next=p->next;
		if(p==last)
			q=last;
		free(p);
	}
}
void destroy()
{
	first=NULL;
	last=NULL;
}
void display()

{		
		