#include<stdio.h>
/*NOTE:This program nly works for source=1 vertex 0 since that much is sufficient...for user accepted source its easy u must b able to do it urself! :)*/
void prims(int a[][10],int v)
{

    int visited[10],d[10],p[10],current=0,i,j,dc=0,dest,min,c=0;
	for(i=0;i<v;i++)	//initialise
	{
		d[i]=9999;		//just some large number
		visited[i]=0;
		p[i]=0;
	}
	visited[current]=1;
	dc=0;
	while(c!=v)		//main calculation	THE ONLY DIFFRENCE IN PRIMS AND DJISTRAS
	{
		for(i=0;i<v;i++)
			if(a[current][i]!=0 && visited[i]!=1)	//if its not visited and an edge exists
				if(a[current][i]+dc<d[i] && a[current][i]!=0)	//a[current][i]!=0 is useless and must be omitted from dis line
				{
					d[i]=a[current][i]+dc;
					p[i]=current;
				}
		min = 9999;		//just some large number

    for (i= 0; i < v; i++)		//finding new current
         if (visited[i] == 0 && a[0][i] <= min)
            min = a[0][i], current = i;
		//update new current mark is visited.....
		visited[current]=1;
		dc=d[current];
		c++;
	}
	//print Result
    printf("\nPATH: ");
    for(i=0;i<v;i++)
		printf("%d  ",p[i]);
        printf("\nCOST: ");
    for(i=0;i<v;i++)
    	printf("%d  ",d[i]);
        
}
void main()
{
int a[10][10],j,i,v;
printf("Enter vertices");
scanf("%d",&v);
printf("Enter the adjacency Matrix");
for(i=0;i<v;i++)
	for(j=0;j<v;j++)
	{
        scanf("%d",&a[i][j]);
        if(a[i][j]==0)		//if an edge doesnt exist change its cost to a large number
            a[i][j]=9999;
	}        
prims(a,v);
}