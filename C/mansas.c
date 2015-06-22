//https://www.hackerrank.com/challenges/manasa-and-stones
#include<stdio.h>
#include<malloc.h>
int a,b,ar[10000],k;
int search(int s)
{
	int n=k;
	int mid=n/2,right=n,left=0;
	while(ar[mid]!=s && right>left)
	{
		if(ar[mid]==s)
			break;
		else if(s>ar[mid])
			left=mid+1;
		else
			right=mid-1;
		 mid=(right+left)/2;
	}
	if(ar[mid]==s)
		return 1;
	return 0;
}
void count(int s,int n)
{
	if(n!=0)
	{
		count(s+a,n-1);
		count(s+b,n-1);
	}
	else if(!search(s))
	{
		
		ar[++k]=s;
		printf("%d ",s);
	}
}

int main()
{
	int t,n,i;
	scanf("%d",&t);
	while(t--)
	{
		k=-1;
		for(i=0;i<10000;i++)
			ar[i]=-1;
		scanf("%d %d %d",&n,&a,&b);
		count(0,n-1);
		printf("\n");
	}
}