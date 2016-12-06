//Binary Search Tree
#include<stdio.h>
#include<malloc.h>
#define N 50
int *a,n=N;
void insert(int x,int p)
{
	printf("IN %d %d\n",p,a[p]);
	if(p<n && a[p]==-1)
		a[p]=x;
	else if(x>a[p])
		insert(x,2*p+1);
	else insert(x,2*p);
	printf("OUTs\n");
}
void display(int p)
{
	if(p<n && a[p]!=-1)
	{
		display(2*p);
		printf("%d ",a[p]);
		display(2*p+1);
	}
}
void main()
{
	int c,i;
	a=(int*)malloc(sizeof(int)*n);
	for(i=0;i<n;i++)
		a[i]=-1;
	for(i=0;i<n;i++)
		printf("%d ",a[i]);
	do{
		printf("\n1.Insern2.Display\n3.Exit\n");
		scanf("%d",&c);
		switch(c)
		{
			case 1: scanf("%d",&c);
					insert(c,1);
					c=0;
					break;
			case 2: display(1);break;
			case 3: break;
			default: break;
		}
	}while(c!=3);
}