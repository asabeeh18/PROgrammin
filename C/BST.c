//Binary Search Tree
#include<stdio.h>
#include<conio.h>
#include<alloc.h>
//left <=
struct Node
{
	int a;
	struct Node *left,*right;
};
struct 	Node *newrec,*root,*p,*q;
void insertNode(int x)
{
	newrec=(struct Node*)malloc(sizeof(struct Node));
	newrec->a=x;
	newrec->left=NULL;
	newrec->right=NULL;
	if(root==NULL)
		root=newrec;
	else
	{
		p=root;
		while(p!=NULL)
		{
			q=p;
			if(x<=p->a)
				p=p->left;
			else
				p=p->right;
		}
		if(x<=q->a)
			q->left=newrec;
		else
			q->right=newrec;
	}
}
/*void insertnode(int x)
	{
newrec=(struct Node*)malloc(sizeof(struct Node));
		newrec->a=x;
		newrec->left=NULL;
		newrec->right=NULL;
		if(root==NULL)
			root=newrec;
		else
		{
			 p=q=root;
			while(p!=NULL)
			{
				q=p;
				if(x<=p->a)
					p=p->left;
				else
					 p=p->right;
			}

			if(x<=q->a)
				 q->left=newrec;
			else
				 q->right=newrec;
		}
	}

*/
void display(struct Node *r)
{
	if(r!=NULL)
	{
		display(r->left);
		printf("%d-",r->a);
		display(r->right);
	}
}
/*void postorder(struct Node *p)
	{
if(p->left!=NULL)
			postorder(p->left);
		if(p->right!=NULL)
			postorder(p->right);
		printf("%d ",p->a);
			}
*/
void deleteNode(int x)
{
	p=root;	//init
	//search
	while(p!=NULL && p->a!=x)
	{
		q=p;
		if(x<=p->a)
			p=p->left;
		else
			p=p->right;
	}		
	if(p->left==NULL && p->right==NULL)
	{
		if(p==root)
			root=NULL;
		free(p);
		if(x<=q->a)
			q->left=NULL;
		else
			q->right=NULL;
	}
	else if(p->right==NULL)
	{
		if(p->a<=q->a)
			q->left=p->left;
		else
			q->right=p->left;	
	}
	else if(p->left==NULL)	//
	{
		if(p->a<=q->a)
			q->left=p->right;
		else
			q->right=p->right;	
	}
	else//KAZAKENDA!!!
	{
		
void main()
{
	int n,x,i;
	clrscr();
	printf("Enter number of nodes to insert ");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("Enter value: ");
		scanf("%d",&x);
		insertNode(x);
	}
	display(root);
	getch();
}
	