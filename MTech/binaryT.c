/* 
Ahmed Sabeeh
2016CS16
*/

//Binary Tree using structure
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
void readTree(struct Tree *root)
{
	int ch;	

	printf("Enter Element: ");
	scanf("%d",&root->a);
	while(1)
	{
		printf("Choose\n");
		if(root->right==NULL)
		{
			printf("1. Right subtree\n");
		}
		if(root->left==NULL)
		{
			printf("2. Left subtree\n");
		}		
		printf("3. Move up\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:
					root->right=(struct Tree*)malloc(sizeof(struct Tree));
					readTree(root->right);
					break;
			case 2:
					root->left=(struct Tree*)malloc(sizeof(struct Tree));
					readTree(root->left);
					break;
			case 3:
					return;

		}
	}
}
//count number of elements
int count(struct Tree *root)
{
	if(root==NULL)
		return 0;
/*
	if(root->left==NULL && root->right==NULL)
		return 1;
*/
	return (1+count(root->left)+count(root->left));
	
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
	int n,i,a;
	struct Tree *root;
	//read

	root=(struct Tree*)malloc(sizeof(struct Tree));
	readTree(root);

	printf("\nPreorder\n");
	preorder(root);
	printf("\nPostorder\n");
	postorder(root);
	printf("\nInorder\n");
	inorder(root);
	printf("\nLevelorder\n");
	
	n=count(root);
	
	levelOrder(root,n);
	printf("\nExit!\n");
	/*
	printf("Enter Elements (-1 to skip a node)\n");
	while(i<n)
	{
		scanf("%d",&a);
		if(a==-1)
			put
		newNode=(struct Tree*)malloc(sizeof(struct Tree));
		newnode->a=a;
		
	}
	*/
}
