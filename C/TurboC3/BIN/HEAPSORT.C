//HeapSort
#include<conio.h>
#include<stdio.h>
#define M 20
void adjust(int parent,int a[],int n)
{
	int child=parent*2,x;
	x=a[parent];	//store original parent
	while(child<=n)
	{
		if(child<n && a[child+1]>a[child])	//if brother exists & it is larger
			child++;
		if(a[parent]>a[child])
			break;	//gtfo wen parent is larger
		a[parent]=a[child];
		parent=child;	//increments
		child=child*2;
	}
	a[parent]=x;
}
void main()
{
	int a[M],i,t,n;
	clrscr();
	printf("Enter Number of elements");
	scanf("%d",&n);
	printf("Enter the elements");
	for(i=1;i<=n;i++)
		scanf("%d",&a[i]);
	//----
	for(i=n/2;i>=1;i--)
		adjust(i,a,n);
	printf("Adjusted or Heap Array\n");
	for(i=1;i<=n;i++)
		printf("%d ",a[i]);
	//Sorting
	for(i=n;i>1;i--)
	{
		t=a[1];
		a[1]=a[i];
		a[i]=t;
		adjust(1,a,i-1);
	}
	printf("\nSorted Array: ");
	for(i=1;i<=n;i++)
		printf("%d ",a[i]);
}