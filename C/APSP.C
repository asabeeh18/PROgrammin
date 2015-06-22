//ALL PAIR SHORTest path
#include<stdio.h>
#include<conio.h>
void main()
{
	int i,j,k,n,a[10][10],A[10][10];
 printf("\nEnter the no. of vertices\n");
 scanf("%d",&n);
 printf("\nEnter the cost adjacency matrix\n");
 for(i=1;i<=n;i++)
 {
  for(j=1;j<=n;j++)
  {
   scanf("%d",&a[i][j]);
   if(a[i][j]==0)
    a[i][j]=999;
  }
 }
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			A[i][j]=a[i][j];
	for(k=0;k<n;k++)
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				A[i][j]=A[i][j]<(A[i][k]+A[k][j])?A[i][j]:(A[i][k]+A[k][j]);
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
			printf("%d ",A[i][j]);
		printf("\n");
	}
}