/* 
Ahmed Sabeeh
2016CS16
*/

//Splay Tree
/*
	make gg->x
*/
#include<stdio.h>
#include<malloc.h>
struct Tree
{
	int a;
	struct Tree *right,*left;
};

void rotateRight(struct Tree *top)
{
	struct Tree *temp,*t;
	t=top->left;
	temp=top->left->right;
	top->left->right=top;
	top->left=temp;
	top=t;
}

void rotateLeft(struct Tree *top)
{
	struct Tree *temp,*t;
	t=top->right;
	temp=top->right->left;
	top->right->left=top;
	top->right=temp;
	top=t;
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
	printf("\nExit!\n");
}


