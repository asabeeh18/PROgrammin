//quik insrt radix
//adix Sort
#include<stdio.h>
#include<conio.h>
void radix(int a[],int n)
{
	int i,j,m,d,k,t,dig,e=1,buk[10][10],count[10];
	m=a[0];
	for(i=1;i<n;i++)
		if(a[i]>m)
			m=a[i];
	if(m<10)
		d=1;
	else if(m<100)
		d=2;
	else if(m<1000)
		d=3;
	else if(m<10000)
		d=4;
       //	else if(m<100000)
	 //	d=5;
	else{}
	for(i=0;i<d;i++,e*=10)
	{
		k=0;
		for(t=0;t<10;t++)
		{
			count[t]=0;
			for(j=0;j<10;j++)
				buk[t][j]=-1;
		}
		for(j=0;j<n;j++)
		{
			dig=(a[j]/e)%10;
			buk[count[dig]][dig]=a[j];
			count[dig]++;
		}
		for(t=0;t<10;t++)
		{
			for(j=0;j<count[t];j++)
				a[k++]=buk[j][t];
		}
	}
}
void main()
{
	int a[10],i,n;
	clrscr();
	printf("Enter the number of elements");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	radix(a,n);
	for(i=0;i<n;i++)
		printf("\n%d",a[i]);
	getch();
}