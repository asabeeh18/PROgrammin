/* 
Ahmed Sabeeh
2016CS16
*/

//Binary Search Tree using structure
#include<stdio.h>
#include<malloc.h>
struct Tree
{
	int a;
	struct Tree *right,*left;
};
void preorder(struct Tree *root)
{
	if(root==NULL)
		return;
	printf("%d ",root->a);
	preorder(root->left);
	preorder(root->right);
}
void postorder(struct Tree *root)
{
	if(root==NULL)
		return;
	preorder(root->left);
	preorder(root->right);
	printf("%d ",root->a);
}
void inorder(struct Tree *root)
{
	if(root==NULL)
		return;
	preorder(root->left);
	printf("%d ",root->a);	
	preorder(root->right);
}
void insert(int a,struct Tree *root)
{
	if(a<=root->a)
	{
		if(root->left!=NULL)
			insert(a,root->left);
		else
		{
			root->left=(struct Tree*)malloc(sizeof(struct Tree));
			root->left->a=a;
		}
	}
	else
	{
		if(root->right!=NULL)
			insert(a,root->right);
		else
		{
			root->right=(struct Tree*)malloc(sizeof(struct Tree));
			root->right->a=a;
		}

	}
}
void levelOrder(struct Tree *root,int n)
{
	
	int i=0,top=0;
	struct Tree *q[n];
	int a[n];

	q[top]=(struct Tree*)malloc(sizeof(struct Tree));
	q[top]=root;
	while(top<n)
	{
		root=q[top];
		if(root->left!=NULL)
		{
			q[++i]=(struct Tree*)malloc(sizeof(struct Tree));
			q[i]=root->left;
		}
		if(root->right!=NULL)
		{
			q[++i]=(struct Tree*)malloc(sizeof(struct Tree));
			q[i]=root->right;	
		}
		top++;
	}
	
	
	for(i=0;i<n;i++)
	{
		printf("%d ",q[i]->a);
	}
}
void main()
{
	int n,a,i;
	struct Tree *root;
	printf("Enter number of elements: ");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		scanf("%d",&a);
		if(root==NULL)
		{
			root=(struct Tree*)malloc(sizeof(struct Tree));
			root->a=a;
		}
		else
			insert(a,root);
	}
	printf("Inserted!\n");
	printf("\nPreorder\n");
	preorder(root);
	printf("\nPostorder\n");
	postorder(root);
	printf("\nInorder\n");
	inorder(root);
	levelOrder(root,n);
	levelOrder(root,n);
	printf("\nExit!\n");
}