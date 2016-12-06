/*
	Ahmed Sabeeh
	2016CS16
*/

/*
	Question 1. Write a program to implement B+ Tree for N=4.
*/
#include<stdio.h>
#include<malloc.h>
#define N 4
struct node
{
	int key[N];
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
	struct node *q=newnode(),*parent;
	
	for(i=p->n/2,j=0;i<p->n;i++,j++)
	{
		q->key[j]=p->key[i];
		q->point[j-1]=p->point[i+1];
		p->key[i]=-1;
		p->point[i+1]=NULL;
	}
	p->n=p->n/2;
	
	printf("78 e\n");
	//Insert the new leaf's smallest key and address into the parent.
	//p is root
	//if(p->parent==NULL)
		
	parent=p->parent;
	i=0;
	//make space for new key 
	
	//If the parent is full, split it too.
	if(parent->n>=N)
	{
		//split and insert
	}
	// or move em
	else
	{
		while(i<N && parent->key[i]<q->key[0])
		{
			i++;
		}
		//move everything after i
		//insert here
	}
	//If the root splits, create a new root which has one key and two pointers. (That is, the value that gets pushed to the new root gets removed from the original node)
	return q;
}


struct node* insert(int k)
{
	struct node *p=search(k),*q;

	//If the bucket is not full (at most b - 1 entries after the insertion), add the record.
	if(p->n<N)
	{
		p->n++;
		p->key[p->n-1]=k;
	}
	else
	{
		//		Otherwise, split the bucket.
		//		Allocate new leaf and move half the bucket's elements to the new bucket.
		q=splitter(p);
	}
	return q;
}

int delete(int n)
{
	return 0;
}

void dfs(struct node *root)
{
	
	int i;
	if(root==NULL)
		return;
	for(i=0;i<root->n;i++)
	{
		dfs(root->point[i]);
		printf("%d ",root->key[i]);
	}
	dfs(root->point[root->n]);
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
