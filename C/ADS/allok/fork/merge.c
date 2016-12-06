/*
Ahmed Sabeeh
2016CS16

Merge Sort
*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

//MERGE SORT
void merge(int *a,int start,int mid,int end)
{
	
	int temp[1024];
	int k=0,i=start,j=mid+1;
	
	//printf("In25\n");
	while(i<=mid && j<=end && i<j)
	{
		if(a[i]<a[j])
		{
			temp[k]=a[i];
			k++;
			i++;
		}
		else
		{
			temp[k]=a[j];
			k++;
			j++;
		}
	}
	
	while(i<=mid)
	{
			temp[k]=a[i];
			k++;
			i++;		
	}
	while(j<=end)
	{
			temp[k]=a[j];
			k++;
			j++;		
	}
	
	
	
	for(i=0,j=start;i<k;i++,j++)	
	{
		a[j]=temp[i];
	//	printf(".%d",a[j]);
	}
}
void mergeSort(int *a,int start,int end)
{
	//printf("In Sorting %d %d\n",start,end);
	int mid;
	if(start<end)
	{
		mid=(start+end)/2;
		//printf("%d",mid);
		mergeSort(a,start,mid);
		mergeSort(a,mid+1,end);
		merge(a,start,mid,end);
	}
}
//END MERGESORT

void main(int argc,char* argv[])
{
	printf("Merge Sort\n");
	if(argc<1)
	{
		printf("Usage:(list of integers)");
		return;
	}
	
	int a[argc];
	int i;
	//printf("argc: %d\n",argc);
	for(i=1;i<argc;i++)
	{
		a[i]=atoi(argv[i]);
		//printf("%d\n",a[i]);
	}
	for(i=1;i<argc;i++)
	{
		//printf("%d ",a[i]);
	}
	mergeSort(a,1,argc-1);
	//print output here
	 
	for(i=1;i<argc;i++)
	{
		printf("%d ",a[i]);
	}
}
