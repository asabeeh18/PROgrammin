/*
Ahmed Sabeeh
2016CS16
*/

//Heap Sort
#include<stdio.h>
//Heapify the tree rooted at i
void heapify(size_t n,int a[n],int i)
{
	int l,r,large;
	l=i*2;
	r=i*2+1;
	
	if(l<n && a[l]>a[i])
		large=l;
	else
		large=i;
	
	if(r<n && a[r]>a[large])
		large=r;
	
	if(i!=large)
	{
		//swap
		int temp=a[i];
		a[i]=a[large];
		a[large]=temp;
		heapify(n,a,large);
	}
}
void buildheap(size_t n,int a[n])
{
	int i;
	for(i=n/2;i>=0;i--)
	{
		heapify(n,a,i);
	}
}

void heapsort(size_t n,int a[n])
{
	int i;
	for(i=n-1;i>=0;i--)
	{
		//largest element at end of array, decrement heapsize
		int temp=a[i];
		a[i]=a[0];
		a[0]=temp;
		heapify(i,a,0);
	}
}
void display(size_t n,int a[n])
{
	int i;
	for(i=0;i<n;i++)
		printf("%d ",a[i]);
	printf("\n");
}
void main(int argc,char* argv[])
{
	if(argc<1)
	{
		printf("Usage:(list of integers)");
		return;
	}
	
	int a[argc];
	int i;
	printf("argc: %d\n",argc);
	for(i=0;i<argc;i++)
	{
		a[i]=atoi(argv[i]);
		//printf("%d\n",a[i]);
	}
	for(i=0;i<argc;i++)
	{
		//printf("%d ",a[i]);
	}
	
	//process
	buildheap(argc,a);
	heapsort(argc,a);
	//output
	printf("Heap Sort:\n");
	display(argc,a);
}
