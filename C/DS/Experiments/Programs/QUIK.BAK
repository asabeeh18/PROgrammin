#include<stdio.h>
#include<conio.h>
int k=0;
int position(int a[],int left,int right)
{
	int i,j,x,t;
	i=left;
	j=right;
	x=a[left];
	while(i<j)
	{
		while(a[i]<=x && i<j)
			i++;
		while(a[j]>x)
			j--;
		if(i<j)
		{
			t=a[i];
			a[i]=a[j];
			a[j]=t;
		}
	}
	t=a[left];
	a[left]=a[j];
	a[j]=t;
	return j;
}
void quik(int a[],int left,int right)
{
	int p;
	k++;
	if(left<right)
	{
	p=position(a,left,right);
	quik(a,left,p-1);
	quik(a,p+1,right);
	}
}
void main()
{
	int i;
	int a[]={123,54,3,754,2,231};
	clrscr();
		quik(a,0,5);
//	printf("\n%d",k);
	for(i=0;i<6;i++)
		printf("\n%d",a[i]);
	getch();
}