//Queue and Stack LL 
#include<stdio.h>
#include<malloc.h>
struct node
{
	int a;
	struct node *next;
};
struct node *last = NULL, *first = NULL;
void insert(int x)
{
	struct node *newrec;
	newrec = (struct node*)malloc(sizeof(struct node));
	newrec->next = NULL;
	if (first == NULL)
		first = newrec;
	if (last != NULL)
		last->next = newrec;
	last = newrec;
	newrec->a = x;
}
int del()
{
	int x;
	struct node *p = first;
	if(first==NULL)
		return -1;
	if(first==last)
		last=NULL;
	
	//Queue
	x = first->a;
	first = first->next;
	
	//Stack
	/*while(p->next!=last)
	p=p->next;
	x=last->a;
	last=p;
	*/
	return x;
}

void display()
{
	struct node *p = first;
	while (p != NULL)
	{
		printf("%d-", p->a);
		p = p->next;
	}
}

void main()
{
	int ch, a;
	do{
		printf("1.Insert 2/Delete 3.Display 4.Exit");
		scanf("%d", &ch);
		switch (ch)
		{
		case 1:printf("Enter number: ");
			scanf("%d", &a);
			insert(a);
			break;
		case 2: a = del();
			printf("%d", a);
		case 3: display();
		case 4: break;
		default: printf("\nTRY AGAIn!!\n");
		}
	} while (ch != 4);
}