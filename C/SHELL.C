#include<stdio.h>
#include<conio.h>
#define M 20
void shell(int a[],int n)
{
	int i,k,j,x;
	for(i=n/2;i>0;i=i/2)
		for(j=i;j<n;j++)
		{
			x=a[j];             //take current chk elemt
			for(k=j;k>=i;k=k-i)      //performs main chking af gap el1emnts
			{
				if(x<a[k-i]) //compare main elemnt wid odr gap elemnts
					a[k]=a[k-i];
				else break;
			}
			a[k]=x;
		}
}
void main()
{
	int a[M],n,i;
	printf("Entr the number of elements: \n");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	shell(a,n);
	for(i=0;i<n;i++)
		printf("%d  ",a[i]);
}