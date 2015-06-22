//BInary search tree
#include<stdio.h>
#include<conio.h>
struct node
{
	int d;
	struct node *right,*left;
};
struct node *root,*newrec,*p,*q;	
void insertN(int n)
{
	newrec=(struct node*)malloc(sizeof(
	if(root==NULL)
		root=newrec;
	else
	{
		p=root;
		while(p!=NULL)
		{
			q=p;
			if(n<=p->d)
				p=p->left;
			else 
				p=p->right;
		}
		if(n<=q->d)
			q->left=newrec;
		else
			q->right=newrec;
	}
}
void deleteN(int n)
{
	p=root;
	while(p!=NULL && p->d!=x)
	{
		q=p;
		if(n<=p->d)
			p=p->left;
		else 
			p=p->right;
	}
	if(p==NULL)
		printf("NUmber not ofund");
	else
	{
		if(p->left!=NULL && p->right==NULL)
		{
			