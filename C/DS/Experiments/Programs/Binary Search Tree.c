#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#define NULL 0
struct Node
{
	int data;
	struct Node *left,*right;
};
intleaf,nonleaf,total;
leaf=0;
nonleaf=0;
total=0;
struct Node *p,*q,*newrec,*root,*c;
void insertnode(int x)
{

	newrec=(struct Node*)malloc(sizeof(struct Node));
	newrec->data=x;
	newrec->left=NULL;
	newrec->right=NULL;
	if(root==NULL)
	{
		root=newrec;
	}
	else
	{
		p=q=root;
		while(p!=NULL)
		{
			q=p;
			if(x<=p->data)
				p=p->left;
			else
				p=p->right;
		}
		if(x<=q->data)
			q->left=newrec;
		else
			q->right=newrec;
	}
}
void deletenode(int x)
{
	int r;
	p=root;
	q=root;
	while(p!=NULL && p->data!=x)
	{
		q=p;
		if(x<p->data)
			p=p->left;
		else
			p=p->right;
	}
	if(p==NULL)
		printf("Deletion not possible");
	else
	{
		if(p->left!=NULL && p->right==NULL)
		{
			if(p==root)
				root=p->left;
			else
			{
				if(q->left==p)
					q->left=p->left;
				else
					q->right=p->left;
			}
		}
		else if(p->left==NULL && p->right!=NULL)
		{
			if(p==root)
				root=p->right;
			else
			{
				if(q->left==p)
					q->left=p->right;
				else
					q->right=p->right;
			}
		}
		else if(p->left==NULL && p->right==NULL)
		{
			if(p==root)
				root=NULL;
			else
			{
				if(q->left==p)
					q->left=NULL;
				else
					q->right=NULL;
			}
		}
		else
		{
			c=c->left;
			while(c->left!=NULL)
				c=c->left;
			r=c->data;
			deletenode(r);
			p->data=r;
			p=NULL;
		}
		free(p);
	}
}

void inorder(struct Node *p)
{
	if(p->left==NULL && p->right==NULL)
		leaf++;
	if(p->left!=NULL)
		inorder(p->left);
	printf("%d ",p->data);
	if(p->right!=NULL)
		inorder(p->right);
}
void preorder(struct Node *p)
{
	printf("%d ",p->data);
	if(p->left!=NULL)
		preorder(p->left);
	if(p->right!=NULL)
		preorder(p->right);
	if(p->left!=NULL&&p->right!=NULL)
		nonleaf++;
	else if(p->left==NULL||p->right!=NULL)
		nonleaf++;
	else if(p->left!=NULL||p->right==NULL)
		nonleaf++;
}

void postorder(struct Node *p)
{
	if(p->left!=NULL)
		postorder(p->left);
	if(p->right!=NULL)
		postorder(p->right);
	printf("%d ",p->data);
}
void destroy()
{
	root=NULL;
}
void main()
{
	int x,ch;
	root=NULL;
	clrscr();
	do
	{
		printf("\n1:Insert node\n2:Inorder\n3:Preoder\n4:Postorder\n5:Deletenode\n6:Destroy\n7:Total Nodes\n8:Exit\n");
		printf("\nEnter your choice");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:	printf("\nEnter an element\n");
					scanf("%d",&x);
					insertnode(x);
					break;
			case 2:	inorder(root);
					break;
			case 3:preorder(root);
					break;
			case 4:	postorder(root);
					break;
			case 5:	printf("\nEnterelemnt to be deleted\n");
					scanf("%d",&x);
					deletenode(x);
					break;
			case 6:	destroy();
					break;
			case 7: printf("Leaf %d, Non Leaf %d",leaf,nonleaf);
					printf(" Total Node = %d ",(nonleaf+leaf));
					break;
			case 8:	break;		
			default:printf("\nWrong Choice Try Again\n");	
		}
	}while(ch!=8);
}
