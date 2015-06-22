#include<stdio.h>
#include<malloc.h>
int* overlap(int *a[4],int n,int b[])
{
	int j,i;
	for(i=0;i<n;i++)
		b[i]=0;
	for(i=0;i<n;i++)
	{
		//printf("0=");
		for(j=i+1;j<n;j++)
		{
			//printf("1=");
			if(!((a[i][0]<a[j][0] && a[i][1]<a[j][0]) ||(a[i][0]>a[j][1] && a[i][1]>a[j][1])))
			{
				//printf("2=");
				//printf(" %d %d  ",(a[i][2]<a[j][2] && a[i][3]<a[j][2]),(a[i][2]>a[j][3] && a[i][3]>a[j][3]));
				if(!((a[i][2]<a[j][2] && a[i][3]<a[j][2]) ||(a[i][2]>a[j][3] && a[i][3]>a[j][3])))
				{
					//printf("3=");
					b[i]++;
					b[j]++;
				}
			}
		}
	}
	//for(i=0;i<n;i++)
		//printf("%d-",b[i]);
	return b;
}
int main()
{
	int **a;
	int t,n,i,j,c,*b,m;
	scanf("%d",&t);
	while(t--)
	{
		c=0;
		b=(int*)malloc(n*sizeof(int));
		scanf("%d",&n);
		a=(int**)malloc(n*sizeof(int *));
		for(i=0;i<n;i++)
			a[i]=(int*)malloc(4*sizeof(int));
		for(i=0;i<n;i++)
		{
			scanf("%d %d %d %d",&a[i][0],&a[i][1],&a[i][2],&a[i][3]);
		}
		do
		{

			overlap(a,n,b);
			j=0;
			for(i=0;i<n;i++)
				j=(b[j]>b[i])?j:i;
			//printf("3-");
			if(b[j]!=0)
			{
				n--;
				b[j]=-1;
				for(i=j;i<n;i++)
					a[i]=a[i+1];
			}
				for(i=0;i<n;i++)
					j=(b[j]>b[i])?j:i;

		}while(b[j]!=0);
		printf("%d\n",n);

		/*for(i=0;i<n;i++)
			//for(j=0;j<4;j++)
				printf("%d %d %d %d\n",a[i][0],a[i][1],a[i][2],a[i][3]);*/
	}
	return 0;
}