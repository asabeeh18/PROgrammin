#include<stdio.h>
insertion(int a[],int n)
{
	int i,k,temp;
	for(i=1;i<n;i++)
	{
		for (k = i; k > 0 && a[k] < a[k-1]; k--)
		{
			temp=a[k];
			a[k]=a[k-1];
			a[k-1]=temp;
		}
	}
	//return a;
}
void main()
{
	int i;
	int a[]={12,1,46,76,7,3};
	insertion(a,6);
	for(i=0;i<6;i++)
	{
		printf("%d ",a[i]);
	}
}