//Merge SOrt
#include<stdio.h>
#include<conio.h>
#define M 20
void simplemerge(int a[],int left,int mid,int right)
{
	int temp[M],i=left,j=mid,k=-1;

	while(i<mid && j<=right)
	{
		if(a[i]>a[j])
			temp[++k]=a[j++];
		else
			temp[++k]=a[i++];
	}
	if(i>mid-1)
		for(;j<=right;j++)
			temp[++k]=a[j];
	else
		for(;i<mid;i++)
			temp[++k]=a[i];
	for(i=0;i<=k;i++)
		a[i+left]=temp[i];
}
void mergesort(int a[],int left,int right)
{
	int mid=(left+right)/2;
	if(left<right)
	{
		mergesort(a,left,mid);
		mergesort(a,mid+1,right);
		simplemerge(a,left,mid,right);
	}
}
void main()
{
	int a[M],i,n;
	printf("Enter the number of elements");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	mergesort(a,0,n);
	printf("Sorted Array\n");
	for(i=0;i<n;i++)
		printf("%d ",a[i]);
}