/*
	Ahmed Sabeeh
	2016CS16
*/

/*
	Question 1. Write a program to implement B+ Tree for N=4.
*/
#include<stdio.h>
#include<malloc.h>
#include<math.h>
#define N 4
struct node
{
	int key[N+1];
	struct node *point[N+1];
	struct node *parent;
	int n;
	int leaf;
};

struct node *root;




struct node* tree_search(int k, struct node* p)
{
	int i=0;
	if(p->leaf==1)
	return p;
	
	for(i=0;i<p->n;i++)
	{
		if(k<p->key[i])
		{
			return tree_search(k,p->point[i]);
			break;
		}
	}
	if(i>=p->n)
	return tree_search(k,p->point[i+1]);
	
    return NULL;
}

struct node* search(int k)
{
	return tree_search(k, root);
}

void insertForSure(struct node *p,int k)
{
	int j,i;
	for(i=0;i<p->n;i++)
	{
		if(p->key[i]>k)
		break;
	}
	
	for(j=p->n-1;j>i;j--)
	{
		p->key[j+1]=p->key[j];
		p->point[j+2]=p->point[j+1];
	}
	p->key[i]=k;
	p->n++;
}

struct node* newnode()
{
	//malloc and init
	int i;
	
	struct node *p=(struct node*)malloc(sizeof(struct node));
	p->leaf=1;
	p->n=0;
	p->parent=NULL;
	for(i=0;i<=N;i++)
	{
		p->point[i]=NULL;
	}
	return p;
}

struct node* splitter(struct node *p)
{
	int i,j;
	//		Allocate new leaf and move half the bucket's elements to the new bucket.
	struct node *q=newnode(),*parent;
	
	for(i=p->n/2,j=0;i<p->n;i++,j++)
	{
		q->key[j]=p->key[i];
		q->point[j-1]=p->point[i+1];
		p->key[i]=-1;
		p->point[i+1]=NULL;
	}
	q->n=ceil(p->n/2.0);
	p->n=p->n/2;
	
	//printf("78 e\n");

	//p is root
	//If the root splits, create a new root which has one key and two pointers. (That is, the value that gets pushed to the new root gets removed from the original node)
	if(p->parent==NULL)
	{
		parent=newnode();
		insertForSure(parent,q->key[0]);
		parent->point[0]=p;
		parent->point[1]=q;
		root=parent;
	}
	else
	{
		parent=p->parent;
		//Insert the new leaf's smallest key and address into the parent.
		insertForSure(parent,q->key[0]);
	//If the parent is full, split it too.
		if(parent->n>N)
			splitter(parent);
	}
	return q;
}


struct node* insert(int k)
{
	struct node *p=search(k),*q;
	
	//If the bucket is not full (at most b - 1 entries after the insertion), add the record.
	if(p->n<N)
	{
		insertForSure(p,k);
		return p;
	}
	else
	{
		//		Otherwise, split the bucket.
		insertForSure(p,k);
		q=splitter(p);
	}
	return q;
}

int delete(int k)
{
	//Start at root, find leaf L where entry belongs.
	struct node *p,*parent;
	int i,messyFlag=0;
	p=search(k);
	if(p==NULL)
	{
		printf("Does not exist");
	}
	else
	{
		i=0;
		while(p->key[i]!=k)
			i++;
		if(i==0)
			messyFlag=1;
		for(;i<p->n-1;i++)
		{
			p->key[i]=p->key[i+1];
		}
		p->n--;
		//If L is at least half-full, done!
		if(p->n>=N/2)
		{
			//fine all ok here
			if(messyFlag)
			{
				parent->key[0]=p->key[0];
			}
		}
		//If L has fewer entries than it should,

Otherwise, sibling is exactly half-full, so we can merge L and sibling.
		else
		{
			//If sibling (adjacent node with same parent as L) is more than half-full, re-distribute, borrowing an entry from it.
			//if parent has 2 child siblings must exist
			if(parent->point[0]!=NULL && parent->point[1]!=NULL)
			{
				i=0;
				while(parent->key[i]<k && i<parent->n)
				{
					i++;
				}
				if(parent->point[k])
			}
		}
	}
	//Remove the entry.
	return 0;
}

void dfs(struct node *root)
{
	
	int i;
	if(root==NULL)
	return;
	for(i=0;i<root->n;i++)
	{
		if(i==0)
			printf("|");
		dfs(root->point[i]);
		printf("%d ",root->key[i]);
		if(i==root->n-1)
			printf("|");
	}
	
	dfs(root->point[root->n]);
	//printf("|");
}
void display()
{
	if(root==NULL)
	{
		printf("Nothing to display\n");
		return;
	}
	dfs(root);
}

int main()
{
	int ch,a;
	root=newnode();
	root->leaf=1;
	root->n=0;
	while(ch!=4)
	{
		printf("Choose\n1. insert\n2. delete\n3. display\n4. exit\n");
		scanf("%d",&ch);
		switch(ch)	
		{
			case 1: printf("Enter number: ");
			scanf("%d",&a);
			if(insert(a)!=NULL)
			printf("Inserted\n");
			else
			printf("Error! %d\n",a);
			break;
			case 2: printf("Enter number: ");
			scanf("%d",&a);
			a=delete(a);
			if(a==0)
			printf("Deleted\n");
			else
			printf("Error! %d\n",a);
			break;
			case 3: display();
			break;
			case 4: break;		
			default: printf("Wrong Input Try Again!\n");
		}
	}
    return 0;
}
