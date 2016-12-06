/* 
Ahmed Sabeeh
2016CS16
*/
//Implement avl tree (insertion, searching, and deletion)
//DOES NOT WORK
#include<stdio.h>
#include<malloc.h>
struct Tree
{
	int a;
	struct Tree *right,*left;
};


struct Tree* rotateRight(struct Tree *top)
{
	struct Tree *a = top->left;
    struct Tree *b = a->right;
 
    a->right = top;
    top->left = b;
 
    return a;
}

struct Tree* rotateLeft(struct Tree *top)
{
	struct Tree *a = top->right;
    struct Tree *b = a->left;
 
    a->left = top;
    top->left = b;
 
    return a;
}

int height(struct Tree *top)
{
	if(top==NULL)
		return 0;
		
	int hLeft,hRight;
	hLeft=height(top->left);
	hRight=height(top->right);		
	int h=hLeft>hRight?hLeft:hRight;
	
	return (1+h);
}

struct Tree* balancer(int a,struct Tree *top)
{
	int hLeft,hRight;
	if(top==NULL)
		return;
		
	hLeft=height(top->left);
	hRight=height(top->right);	

	//LL
    if (hLeft-hRight>1 && a < top->left->a)
        return rotateRight(top);
 
    //RR
    if (hLeft-hRight<-1 && a>top->right->a)
        return rotateLeft(top);
 
    //LR
    if (hLeft-hRight>1 && a>top->left->a)
    {
        top->left =  rotateLeft(top->left);
        return rotateRight(top);
    }
 
    //RL
    if(hLeft-hRight<-1 && a<top->right->a)
    {
        top->right = rotateRight(top->right);
        return rotateLeft(top);
    }
 
	return top;
}


void inorder(struct Tree *top)
{
	if(top==NULL)
		return;
	inorder(top->left);
	printf("%d ",top->a);	
	inorder(top->right);
}


struct Tree* insert(int a,struct Tree *top)
{
	if(a<=top->a)
	{
		if(top->left!=NULL)
			insert(a,top->left);
		else
		{
			top->left=(struct Tree*)malloc(sizeof(struct Tree));
			top->left->a=a;
		}
	}
	else
	{
		if(top->right!=NULL)
			insert(a,top->right);
		else
		{
			top->right=(struct Tree*)malloc(sizeof(struct Tree));
			top->right->a=a;
		}

	}
	return balancer(a,top);
	printf("\nIn Insert!\n");
	inorder(top);
	printf("\n\n");
}

struct Tree* search(int a, struct Tree *top)
{
	if(top==NULL)
		return NULL;
	if(top->a==a)
		return top;
	if(top->a<a)
	{
		return search(a,top->right);
	}
	else
	{
		return search(a,top->left);
	}
}
void delete(int a,struct Tree *top)
{
	
}
void main()
{
	int n,a,i;
	struct Tree *root=NULL,*temp;
	printf("Enter number of elements: ");
	scanf("%d",&n);
	printf("Enter elements\n");
	for(i=0;i<n;i++)
	{
		scanf("%d",&a);
		if(root==NULL)
		{
			root=(struct Tree*)malloc(sizeof(struct Tree));
			root->a=a;
		}
		else
			root=insert(a,root);
	}
	printf("Inserted!\n");
	printf("Enter element to search: ");
	scanf("%d",&a);
	temp=search(a,root);
	if(temp!=NULL)
		printf("Element %d found at %x\n",temp->a,temp);
	else
		printf("Element not found\n");
		
	printf("Enter element to delete: ");
	scanf("%d",&a);	
	delete(a,root);//temp==
	if(temp!=NULL)
		printf("Element was deleted\n");
	inorder(root);
	printf("\nExit!\n");
}
