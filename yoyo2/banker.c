#include<stdio.h>
#include<malloc.h>
 int allDone(int r[],int n)
 {
  int i;
 	for(i=0;i<n;i++)
 		if(r[i]!=0)
 			return 0;
 	return 1;
 }
void main()
 { 
	int n,*a,*r,resc,i,flag;
	printf("Enter the total resources"); 	
	scanf("%d",&resc); 	
	printf("Number of processes");	 
	scanf("%d",&n);
	r=(int*)malloc(n*(sizeof(int)));
	a=(int*)malloc(n*(sizeof(int)));
	printf("Enter resource for each process:");
	for(i=0;i<n;i++) 
	{ 		
		scanf("%d",&r[i]);
 	    a[i]=r[i];
	}
	for(i=0;i<n;i++)
	  	printf("%d ",r[i]);
	printf("%d\n",resc);
 	while(allDone(r,n)==0)
 	{ 	
 		flag=0;
	 	
    	for(i=0;i<n;i++)
		{
			if(r[i]<resc && r[i]!=0) 	
			{ 		
				flag=1;
				r[i]--; 		
				resc--; 	
				if(r[i]==0)
					resc+=a[i];
			} 
		}
		 for(i=0;i<n;i++)
	  		printf("%d ",r[i]);
	  	printf("%d\n",resc);
		if(flag==0)
		{
			printf("No feasible Solution"); 
			break;
		}
	}
	 	  
}