//Array Queue
#include<stdio.h>
#include<malloc.h>
#define n 10
int a[n];
int size=0;
void insert(int ab)
{
	if(size==n)
	{
		printf("FULL");
		return;
	}
	a[size]=ab;
	size++;
}
int del()
{
	if(size==0)
		return -1;
	int i,t=a[0];
	for(i=0;i<size;i++)
		a[i]=a[i+1];
	size--;
	return t;
}
void disp()
{
	int i;
	for(i=0;i<size;i++)
		printf("%d",a[i]);
}
void main()
{
	int s=0;
	while(s!=-111)
	{
		scanf("%d",&s);
		if(s==5)
			disp();
		else if(s==0)
			printf("-%d\n",del());
		else
			insert(s);
	}
}