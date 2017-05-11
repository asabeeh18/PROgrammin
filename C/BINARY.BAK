//binary search
//Insertion Sort
#include<stdio.h>
#include<conio.h>
#define M 20
int search(int a[],int n,int s)
{
	int mid=n/2,right=n,left=0;
	while(a[mid]!=s && right>left)
	{
		if(a[mid]==s)
			break;
		else if(s>a[mid])
			left=mid+1;
		else
			right=mid-1;
		 mid=(right+left)/2;
	}
	if(a[mid]==s)
		return mid;
	return -1;
}
void main()
{
	int a[M],n,i,s;
	printf("Entr the number of elements: \n");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	printf("Entr element to search ");
	scanf("%d",&s);
       s=search(a,n,s);
	printf("%d  ",s);
	getch();
}