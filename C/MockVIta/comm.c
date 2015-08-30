#include<stdio.h>
#include<malloc.h>
struct node
{
	struct node *prev;
	struct node *next;
	struct head *myhead;
};
struct head
{
	long count;
};
int main()
{
	unsigned long  n,a,b,i,ans,max,min;
	struct node *ppl;
	struct node *p,*q;
	struct head *heads;
	char ch;
	scanf("%lu",&n);
	
	ppl=malloc(n*sizeof(struct node));
	heads=malloc(n*sizeof(struct head));
	for(i=0;i<n;i++)
	{
		ppl[i].prev=NULL;
		ppl[i].next=NULL;
		ppl[i].myhead=&heads[i];
		
		heads[i].count=1;
	}
	scanf("%c",&ch);
	while(ch!='-')
	{
		if(ch=='C')
		{
			scanf("%lu %lu",&a,&b);
			min=(a<b)?a:b;
			max=(a>=b)?a:b;
			heads[min].count+=heads[max].count;
			p=&ppl[max];
			while(p!=NULL)
			{
				p->myhead=&heads[min];
				if(p->prev!=NULL)
					p=p->prev;
				else break;
			}
			//p points to first ...make it point to last of min 
			q=&ppl[min];
			while(q!=NULL)
			{
				if(q->next!=NULL)
					q=q->next;
				else break;
			}
			q->next=p;
			p->prev=q;
			//adjust further vals
			p=&ppl[max];
			while(p!=NULL)
			{
				p->myhead=&heads[min];
				if(p->next!=NULL)
					p=p->next;
				else break;
			}
			heads[max].count=-1;
			
		}
		else if(ch=='Q')
		{
			scanf("%lu %lu",&a,&b);
			ans=0;
			for(i=0;i<n;i++)
			{
				if(heads[i].count!=-1)
					if(heads[i].count%2==0)
						ans++;
			}
			printf("%lu\n",ans);
		}
		scanf("%c",&ch);
	}
	//printf("%lu",n);
	return 0;
}