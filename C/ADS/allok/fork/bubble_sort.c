/*
Ahmed Sabeeh
2016CS16
*/
#include<stdio.h>
void sort(int n,int* ser)
{
//    int n=sizeof(ser)/sizeof(ser[0]);
    int i,j,t;
    for(i=1;i<n;i++)
    {
    	for(j=1;j<n-1;j++)
        {
            if(ser[j]>ser[j+1])
			{
				t=ser[j];
				ser[j]=ser[j+1];
				ser[j+1]=t;
			}
        }
    }
}
void display(int n,int* a)
{
	int i;
	for(i=1;i<n;i++)
	{
		printf("%d ",a[i]);
	}
	printf("\n");
}
void main(int argc,char* argv[])
{
	printf("Bubble Sort\n");
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
	}
	for(i=1;i<argc;i++)
	{
//		printf("%d ",a[i]);
	}
	sort(argc,a);
	
	display(argc,a);	
}
