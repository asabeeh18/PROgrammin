//Quick Sort
#include<stdio.h>
#include<conio.h>
int partition(int a[],int left,int right)
{
	int i=left,j=right,x=a[left];
	while(a[i]<=x && i<left)
		i++;
	while(a[j]>x)
		j--;
	if(i<j)
	{
		t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	a[left]=a[j];
	a[j]=x;	
	return j;
}
void quick(int a[],int n	